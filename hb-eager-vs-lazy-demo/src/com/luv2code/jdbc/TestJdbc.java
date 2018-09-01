package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		System.out.println("Connecting to database: " + jdbcUrl);
		
		try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password)) {
			System.out.println("Connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
