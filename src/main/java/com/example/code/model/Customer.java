package com.example.code.model;

public class Customer {

	private int id;
	private String companyName;
	private String contactName;
	private String address;
	private String mailContact;
	private String phoneNumber;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailContact() {
		return mailContact;
	}

	public void setMailContact(String mailContact) {
		this.mailContact = mailContact;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		sb.append("[Customer]");
		sb.append("[ id='" + id);
		sb.append("', companyName='" + companyName);
		sb.append("', contactName='" + contactName);
		sb.append("', address='" + address);
		sb.append("', mailContact='" + mailContact);
		sb.append("', phoneNumber='" + phoneNumber);
		sb.append("', createdDate='" + createdDate);
		sb.append("', updatedDate='" + updatedDate);
		sb.append("', deletedDate='" + deletedDate);
		sb.append("', deleted='" + deleted);
		sb.append("']");
		return sb.toString();
	}
}
