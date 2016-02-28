package com.example.code.model;

import com.example.code.service.ProductService;
import com.example.code.service.impl.ProductServiceImpl;

public class OrderDetail {

	private int id;
	private int orderId;
	private int productId;
	private double unitPrice;
	private int quantity;
	private double subTotal;

	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Product getProduct() {
		ProductService productService = new ProductServiceImpl();
		product = productService.findProductById(productId);
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[OrderDetail]");
		sb.append("[ id='" + id);
		sb.append("', orderId='" + orderId);
		sb.append("', productId='" + productId);
		sb.append("', unitPrice='" + unitPrice);
		sb.append("', quantity='" + quantity);
		sb.append("', subTotal='" + subTotal);
		sb.append("']");
		return sb.toString();
	}

}
