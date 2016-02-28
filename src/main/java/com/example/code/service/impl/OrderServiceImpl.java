package com.example.code.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.code.common.ConnectionDB;
import com.example.code.enums.OrderStatus;
import com.example.code.model.OrderDetail;
import com.example.code.model.Orders;
import com.example.code.service.OrderDetailService;
import com.example.code.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private static final Logger log = LogManager.getLogger(OrderServiceImpl.class);

	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public int createOrder(Orders order) {

		log.info("#generateOrder");
		
		String sql = "INSERT INTO db_sales.orders (id, customerId, orderDate, status, totalPrice, createdDate, updatedDate, deletedDate, deleted) "
				+ "VALUES (NULL,?,NULL,?,0,NOW(),NULL,NULL,0);";
		
		try {
			
			cn = new ConnectionDB().getConnection();
			pstm = cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, order.getCustomerId());
			pstm.setString(2, OrderStatus.generated.getValue());

			int count = pstm.executeUpdate();
			log.info("Records inserted: " + count);
			
			rs = pstm.getGeneratedKeys();
			if(rs.next()){
				order.setId(rs.getInt(1)); // lastIncrementalId
			}
			
			log.info("Last orderId: " + order.getId());
			return order.getId();
			
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
		
		return order.getId();
	}

	public boolean updateOrderWithOrderDetail(Orders order) {
		
		log.info("#updateOrderWithOrderDetail");
		
		boolean flag = false;
		String sql = "UPDATE db_sales.orders o "
				+ "SET o.orderDate = NOW(), "
				+ "o.status = ?, "
				+ "o.totalPrice = ?, "
				+ "o.updatedDate = NOW() "
				+ "WHERE o.id = ?";
		try {
			
			order = findOrderById(order.getId());
			OrderDetailService orderDetailService = new OrderDetailServiceImpl();
			List<OrderDetail> orderDetailList = orderDetailService.findDetailbyOrderId(order.getId());
			
			cn = new ConnectionDB().getConnection();
			pstm = cn.prepareStatement(sql);
						
			double totalPrice = 0;
			for (OrderDetail orderDetail : orderDetailList) {
				totalPrice += orderDetail.getSubTotal();
			}
			
			pstm.setString(1, OrderStatus.pending.getValue());
			pstm.setDouble(2, totalPrice);
			pstm.setInt(3, order.getId());
			
			int count = pstm.executeUpdate();
			flag = count > 0 ? true : false;
			log.info("Records updated: " + count);
			
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

	public Orders findOrderById(int id) {
		
		log.info("#findOrderById");

		String sql = "SELECT o.id, "
				+ "o.customerId, "
				+ "o.orderDate, "
				+ "o.status, "
				+ "o.totalPrice, "
				+ "o.createdDate, "
				+ "o.updatedDate, "
				+ "o.deletedDate, "
				+ "o.deleted "
				+ "FROM db_sales.orders o "
				+ "WHERE o.id = ?;";
		
		try {
			
			cn = new ConnectionDB().getConnection();
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			Orders order = null;
			if (rs.next()) {
				order = new Orders();
				order.setId(rs.getInt("id"));
				order.setCustomerId(rs.getInt("customerId"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setStatus(rs.getString("status"));
				order.setTotalPrice(rs.getDouble("totalPrice"));
				order.setCreatedDate(rs.getString("createdDate"));
				order.setUpdatedDate(rs.getString("updatedDate"));
				order.setDeletedDate(rs.getString("deletedDate"));
				order.setDeleted(rs.getString("deleted"));
			}
			
			log.info(order);
			return order;	
			
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

}
