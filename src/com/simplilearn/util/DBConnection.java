package com.simplilearn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection connection;

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerce";
	private final String USER_NAME = "root";
	private final String PASSWORD = "password";

	public DBConnection() {
		try {

			// STEP 1 : Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// STEP 2: Gets Connection Object
			this.connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void closeConnection() {
		if (this.connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
