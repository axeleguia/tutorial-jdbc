package com.example.code.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.code.enums.PatternDate;

public class DateFormatter {

	public String getSystemDate(PatternDate pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern.getValue());
		Date date = new Date();
		String formattedDate = formatter.format(date);
		return formattedDate;
	}
}
