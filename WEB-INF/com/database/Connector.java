package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public Connector() {
		// TODO Auto-generated constructor stub
	}
	public static Connection link() throws ClassNotFoundException, SQLException {
		// Class.forName("org.apache.derby.jdbc.ClientDriver");
		// Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527//BankDatabase;create=true","aal","123");
		Class.forName("com.mysql.cj.jdbc.Driver");
		String type4URLmysql = "jdbc:mysql://172.18.0.3:3306/BankDatabase";
		Connection con = DriverManager.getConnection(type4URLmysql, "root", "12345");
		return con;
	}

}
