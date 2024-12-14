package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	public static Connection connect() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/BankDatabase;create=true","aal","123");
		String type4URLmysql = "jdbc:mysql://172.18.0.3:3306/BankDatabase";
		Connection con = DriverManager.getConnection(type4URLmysql, "root", "12345");
		System.out.println("Database Connected!!!!");
		return con;

	}
}
