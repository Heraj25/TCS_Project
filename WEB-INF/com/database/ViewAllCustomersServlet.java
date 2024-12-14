package com.database;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class ViewAllCustomersServlet
 */
@WebServlet("/ViewAllCustomersServlet")
public class ViewAllCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Customeer> customers = new ArrayList<>();
        
        try (Connection con = Database.connect()) {
            String sql = "SELECT * FROM BankDatabase.CustDetails";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Customeer customer = new Customeer();
                customer.setSsnId(rs.getString("ssn_id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("cust_email"));
                customer.setAddress(rs.getString("cust_address"));
                customer.setContactNumber(rs.getString("cust_contact_no"));
                customer.setAadhar(rs.getString("cust_aadhar"));
                customer.setPan(rs.getString("cust_pan"));
                customer.setAccountNumber(rs.getString("cust_acc_no"));
                customer.setAccountType(rs.getString("cust_acc_type"));
                customer.setBalance(rs.getString("cust_balance"));
                customers.add(customer);
            }
            
            // Set customers as request attribute
            request.setAttribute("customers", customers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Forward to JSP page
        request.getRequestDispatcher("AllCustDetails.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
