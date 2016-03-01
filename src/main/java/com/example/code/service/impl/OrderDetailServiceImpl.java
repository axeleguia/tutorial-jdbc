package com.example.code.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.code.common.ConnectionDB;
import com.example.code.model.OrderDetail;
import com.example.code.model.Orders;
import com.example.code.model.Product;
import com.example.code.service.OrderDetailService;
import com.example.code.service.ProductService;

public class OrderDetailServiceImpl implements OrderDetailService {

	private static final Logger log = LogManager.getLogger(OrderDetailServiceImpl.class);

	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	public List<OrderDetail> findDetailbyOrderId(int id) {
		
		log.info("#findDetailbyOrderId");

		String sql = "SELECT od.id, "
				+ "od.orderId, "
				+ "od.productId, "
				+ "od.unitPrice, "
				+ "od.quantity, "
				+ "od.subTotal "
				+ "FROM db_sales.orderDetail od "
				+ "WHERE od.orderId = ?;";
		
		try {
			
			cn = new ConnectionDB().getConnection();
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
			OrderDetail orderDetail = null;
			
			ProductService productService = new ProductServiceImpl();
			
			while (rs.next()) {
				orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrderId(rs.getInt("orderId"));
				orderDetail.setProductId(rs.getInt("productId"));
				orderDetail.setUnitPrice(rs.getDouble("unitPrice"));
				orderDetail.setQuantity(rs.getInt("quantity"));
				orderDetail.setSubTotal(rs.getDouble("subTotal"));
				orderDetail.setProduct(productService.findProductById(rs.getInt("productId")));
				orderDetailList.add(orderDetail);
			}
			
			int count = orderDetailList.size();
			log.info("Records selected: " + count);
			return orderDetailList;
			
		} catch (Exception exception) {
			log.error(exception);
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception exception2) {
				log.error(exception2);
			}
		}
		
		return null;
	}

	public boolean addDetailsInOrder(Orders order, List<OrderDetail> orderDetailList) {
		
		log.info("#addDetailsInOrder");
		
		boolean flag = false;
				
		try {
			
			int counter = 0; 
			ProductService productService = new ProductServiceImpl();
			for (OrderDetail orderDetail : orderDetailList) {
				
				Product product = productService.findProductById(orderDetail.getProductId());
				if(product.getStock() < orderDetail.getQuantity()){
					log.warn("No stock for product: [" + product.getId() +"]["+ product.getProductName() + "]. Current stock is: " + product.getStock()+". Quantity required is: " + orderDetail.getQuantity());
					counter++; // If more than 1 product doesn't present stock
				}
				
			}
			
			if(counter > 0){ // If counter is 0 then all products have stock, More than 0 means some product doens't have stock then byebye
				flag = false;
				return flag;
			}
			
		} catch (Exception exception) {
			log.error("Insufficient Stock");
		}
		
		//Begin transaction
		try {
			flag = false;
			
			cn = new ConnectionDB().getConnection();
			cn.setAutoCommit(false);
					
			try { // Add items
				
				String sqlAddItemsToDetail = "INSERT INTO db_sales.orderDetail (id, orderId, productId, unitPrice, quantity, subTotal) "
						+ "VALUES(NULL,?,?,?,?,?);";
				pstm = cn.prepareStatement(sqlAddItemsToDetail);
				
				for (OrderDetail orderDetail : orderDetailList) {
					pstm.setInt(1, order.getId());
					pstm.setInt(2, orderDetail.getProduct().getId()); //productId
					pstm.setDouble(3, orderDetail.getProduct().getUnitPrice()); //unitPrice
					pstm.setInt(4, orderDetail.getQuantity());
					pstm.setDouble(5, orderDetail.getProduct().getUnitPrice() * orderDetail.getQuantity());
					pstm.addBatch();
				}
				
				int[] count = pstm.executeBatch();
				cn.commit();
				flag = count.length > 0 ? true : false;
				
			} catch (Exception exception) {
				cn.rollback();
				log.error("An error occurred when adding items", exception);
			}

			if(flag == false) { // On error adding items, don't update product
				return flag;
			}
			
			try { // Remove items
				
				String sqlRemoveItems = "UPDATE db_sales.product p SET p.stock = p.stock-?, p.updatedDate = NOW() WHERE p.id = ?;";
				pstm = cn.prepareStatement(sqlRemoveItems);
				
				for (OrderDetail orderDetail : orderDetailList) {
					pstm.setInt(1, orderDetail.getQuantity());
					pstm.setInt(2, orderDetail.getProductId());
					pstm.addBatch();
				}
				
				pstm.executeBatch();
				cn.commit();
				
			} catch (Exception exception) {
				cn.rollback();
				log.error("An error occurred when removing items", exception);
			}
			
			int[] count = pstm.executeBatch();
			cn.commit();
			flag = count.length > 0 ? true : false;
			
		} catch (Exception exception) {
			log.error(exception);
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception exception2) {
				log.error(exception2);
			}
		}
		
		return flag;
	}

}
