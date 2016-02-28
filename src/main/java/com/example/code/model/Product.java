package com.example.code.model;

public class Product {

	private int id;
	private String productName;
	private double unitPrice;
	private int stock;
	private String createdDate;
	private String updatedDate;
	private String deletedDate;
	private String deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Product]");
		sb.append("[ id='" + id);
		sb.append("', productName='" + productName);
		sb.append("', unitPrice='" + unitPrice);
		sb.append("', stock='" + stock);
		sb.append("', createdDate='" + createdDate);
		sb.append("', updatedDate='" + updatedDate);
		sb.append("', deletedDate='" + deletedDate);
		sb.append("', deleted='" + deleted);
		sb.append("']");
		return sb.toString();
	}

}
