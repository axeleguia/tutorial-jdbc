package com.example.code.model;

import java.util.List;

public class Orders {

	private int id;
	private int customerId;
	private String orderDate;
	private String status;
	private double totalPrice;
	private String createdDate;
	private String updatedDate;
	private String deletedDate;
	private String deleted;

	private List<OrderDetail> orderDetailList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Orders]");
		sb.append("[ id='" + id);
		sb.append("', customerId='" + customerId);
		sb.append("', orderDate='" + orderDate);
		sb.append("', status='" + status);
		sb.append("', totalPrice='" + totalPrice);
		sb.append("', createdDate='" + createdDate);
		sb.append("', updatedDate='" + updatedDate);
		sb.append("', deletedDate='" + deletedDate);
		sb.append("', deleted='" + deleted);
		sb.append("']");
		return sb.toString();
	}

}
