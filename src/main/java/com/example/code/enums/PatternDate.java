package com.example.code.enums;

public enum PatternDate {

	yearMonthDay("yearMonthDay", "yyyy-MM-dd hh:mm:ss"), 
	dayMonthYear("dayMonthYear", "dd-MM-yyyy hh:mm:ss");

	private String key;
	private String value;

	private PatternDate(String key, String value) {
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
