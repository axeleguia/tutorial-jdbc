package com.example.code.enums;

public enum OrderStatus {

	generated("GENERATED", "GENERATED"),
	pending("PENDING", "PENDING"),
	completed("COMPLETED","COMPLETED"),
	denied("DENIED", "DENIED");

	private String key;
	private String value;

	private OrderStatus(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
