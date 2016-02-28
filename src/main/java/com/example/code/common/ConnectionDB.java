package com.example.code.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionDB {

	private static final Logger log = LogManager.getLogger(ConnectionDB.class);

	public Properties loadProperties() {
		Properties properties = new Properties();
		InputStream input = null;
		try {
			input = getClass().getResourceAsStream("/db.properties");
			properties.load(input);
			input.close();
			if (properties.size() > 0) {
				log.info("Loaded connection parameters successfully");
				return properties;
			} else {
				log.warn("Empty file");
			}
		} catch (Exception exception) {
			log.error("Some happend with the properties file", exception);
		}
		return null;
	}

	public Connection getConnection() {
		Connection cn = null;
		try {
			Properties prop = loadProperties();
			Class.forName(prop.getProperty("mysql.driverClassName"));
			log.info("Driver registered successfully");
			try {
				cn = DriverManager.getConnection(
						prop.getProperty("mysql.url") + 
						prop.getProperty("mysql.database"),
						prop.getProperty("mysql.username"), 
						prop.getProperty("mysql.password"));
				log.info("Connection established with the server");
			} catch (Exception exception) {
				log.error("Could not establish connection", exception);
			}
		} catch (ClassNotFoundException exception) {
			log.error("Driver not registered", exception);
		}
		return cn;
	}
}
