package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class E_Database {
	
	public static String generateID(){
        Random random = new Random();
        // Generate a number between 1000000 and 9999999 (inclusive)
        int id = 1000000 + random.nextInt(9000000);
        return Integer.toString(id);
    }

	
	public static int insert(Employee c) throws ClassNotFoundException, SQLException {
		String E_id;
		String E_fname, E_lname, E_email, E_address, E_number, E_password, E_cpassword;
		E_id=c.getE_Id();
		E_fname=c.getE_fname();
		E_lname=c.getE_lname();
		E_email=c.getE_email();
		E_address=c.getE_address();
		E_number=c.getE_contact();
		E_password=c.getE_password();
		E_cpassword=c.getE_cpassword();
//		E_acno=c.getE_acno();
//		E_bal=c.getE_bal();
		
		Connection x=Connector.link();
		String sql1="insert into BankDatabase.EmpDetails (id, empfname, emplname, email, password, cpassword, address, contact_no) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=x.prepareStatement(sql1);
		ps.setString(1, E_id);
		ps.setString(2, E_fname);
		ps.setString(3, E_lname);
		ps.setString(4, E_email);
		ps.setString(5, E_password);
		ps.setString(6, E_cpassword);
		ps.setString(7, E_address);
		ps.setString(8, E_number);
		int flag=ps.executeUpdate();
		return flag;
		}


	public static int search(String id, String pass) throws ClassNotFoundException, SQLException {
//		String E_id;
		String password;
		int flag=0;
		
		Connection x=Connector.link();
		String sql1="select password from cust_table where id=?";
		PreparedStatement ps=x.prepareStatement(sql1);
		ps.setString(1, id);
		
		
		ResultSet r=ps.executeQuery(sql1);
		password=r.getString(1);
		if(password.equals(pass))
			flag= 1;
		else
			flag=0;
//			o=new Customer(E_id, E_name, E_email, E_address, E_number, E_aadhar, E_pan, E_acno, E_bal);
		return flag;// if 1 log in, 0 don't log in
		}



}
