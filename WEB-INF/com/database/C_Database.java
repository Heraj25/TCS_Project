/**
 * 
 */
package com.database;

/**
 * @author 2732350
 *
 */

//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class C_Database {
	
	
	public static String generateID(){
        Random random = new Random();
        // Generate a number between 1000000 and 9999999 (inclusive)
        int id = 1000000 + random.nextInt(9000000);
        return Integer.toString(id);
    }

	
	public static int insert(Customer c) throws ClassNotFoundException, SQLException {
		String C_ssn;
		String C_name, C_email, C_address, C_number, C_aadhar, C_pan, C_acno, C_actyp, C_bal;
		C_ssn=c.getC_ssn();
		C_name=c.getC_name();
		C_email=c.getC_email();
		C_address=c.getC_address();
		C_number=c.getC_number();
		C_aadhar=c.getC_aadhar();
		C_pan=c.getC_pan();
		C_acno=c.getC_acno();
		C_actyp = c.getC_actyp();
		C_bal=c.getC_bal();
		
		Connection x=Connector.link();
		String sql1="insert into BankDatabase.CustDetails (ssn_id, name, cust_email, cust_address, cust_contact_no, cust_aadhar, cust_pan, cust_acc_no, cust_acc_type, cust_balance) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=x.prepareStatement(sql1);
		ps.setString(1, C_ssn);
		ps.setString(2, C_name);
		ps.setString(3, C_email);
		ps.setString(4, C_address);
		ps.setString(5, C_number);
		ps.setString(6, C_aadhar);
		ps.setString(7, C_pan);
		ps.setString(8, C_acno);
		ps.setString(9, C_actyp);
		ps.setString(10, C_bal);
		
		int flag=ps.executeUpdate();
		return flag;
		}
	
	


	public static ArrayList<Customer> list_of_customers() throws SQLException, ClassNotFoundException{
        String C_ssn;
        String C_name, C_email, C_address, C_number, C_aadhar, C_pan, C_acno, C_actyp, C_bal;
        Connection x=Connector.link();
        Customer o;
        ArrayList<Customer> a=new ArrayList<Customer>();
        String sql1="select * from BankDatabase.CustDetails";
        PreparedStatement ps=x.prepareStatement(sql1);
        ResultSet r=ps.executeQuery();
        while(r.next()){
            C_ssn=r.getString(1);
            C_name=r.getString(2);
            C_email=r.getString(3);
            C_address=r.getString(4);
            C_number=r.getString(5);
            C_aadhar=r.getString(6);
            C_pan=r.getString(7);
            C_acno=r.getString(8);
            C_actyp=r.getString(9);
            C_bal=r.getString(10);
            o=new Customer(C_ssn, C_name, C_email, C_address, C_number, C_aadhar, C_pan, C_acno, C_actyp, C_bal);
            a.add(o);
        }
        return a;
       }


	public static int update(String ssn, Customer c) throws ClassNotFoundException, SQLException {
//		int C_ssn;
		String C_name, C_email, C_address, C_number, C_aadhar, C_pan, C_acno, C_actyp, C_bal;
		
//		C_ssn=c.getC_ssn();
		C_name=c.getC_name();
		C_email=c.getC_email();
		C_address=c.getC_address();
		C_number=c.getC_number();
		C_aadhar=c.getC_aadhar();
		C_pan=c.getC_pan();
		C_acno=c.getC_acno();
		C_actyp = c.getC_actyp();
		C_bal=c.getC_bal();
		
		Connection x=Connector.link();
		String sql1="update cust_table set C_Name=?, C_Email=?, C_Address=?, C_Number=?, C_Aadhar=?, C_Pan=?, C_Account_No=?, C_Accoutn_Type=?, C_Balance=? where C_Ssn=?";
		PreparedStatement ps=x.prepareStatement(sql1);
//		ps.setInt(1, C_ssn);
		ps.setString(1, C_name);
		ps.setString(2, C_email);
		ps.setString(3, C_address);
		ps.setString(4, C_number);
		ps.setString(5, C_aadhar);
		ps.setString(6, C_pan);
		ps.setString(7, C_acno);
		ps.setString(8, C_actyp);
		ps.setString(9, C_bal);
		
		int flag=ps.executeUpdate();
		return flag;
		}

	public static int delete(String ssn) throws ClassNotFoundException, SQLException {
		
		Connection x=Connector.link();
		String sql1="delete from BankDatabase.CustDetails where ssn_id=?";
		PreparedStatement ps=x.prepareStatement(sql1);
		ps.setString(1, ssn);
		
		int flag=ps.executeUpdate();
		return flag;
		}

	
	public static Customer search(String ssn) throws ClassNotFoundException, SQLException {
		String C_ssn;
		String C_name, C_email, C_address, C_number, C_aadhar, C_pan, C_acno, C_actyp, C_bal;
		Customer o;
		
		Connection x=Connector.link();
		String sql1="select * from cust_table where C_Ssn=?";
		PreparedStatement ps=x.prepareStatement(sql1);
		ps.setString(1, ssn);
		
		
		ResultSet r=ps.executeQuery(sql1);
		C_ssn=r.getString(1);
		C_name=r.getString(2);
		C_email=r.getString(3);
		C_address=r.getString(4);
		C_number=r.getString(5);
		C_aadhar=r.getString(6);
		C_pan=r.getString(7);
		C_acno=r.getString(8);
		C_actyp = r.getString(9);
		C_bal=r.getString(10);
		if(r.wasNull())
			o=null;
		else
			o=new Customer(C_ssn, C_name, C_email, C_address, C_number, C_aadhar, C_pan, C_acno, C_actyp, C_bal);
		return o;
		}


}

