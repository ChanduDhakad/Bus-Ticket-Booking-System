package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {

	
	
	
	public static Connection provideConnection() {
		Connection conn=null;

		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			
			System.out.println("JDBC Driver cannot connected to the database");
		}

		
		String url="jdbc:mysql://localhost:3306/ticket_booking_system";
		
		
		try {
			
		conn=DriverManager.getConnection(url,"root","1234");
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return conn;

	}
}
