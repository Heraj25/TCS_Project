package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustRetrieveServlet
 */
@WebServlet("/CustRetrieveServlet")
public class CustRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustRetrieveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String ssnId = request.getParameter("customer_ssn_id");
		Customer customer = null;
		
		try(Connection con = Database.connect()) {
			String sql4 = "select *  from BankDatabase.CustDetails where ssn_id=?";
			PreparedStatement ps = con.prepareStatement(sql4);
			ps.setString(1, ssnId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				customer = new Customer();
				
				 customer.setC_ssn(rs.getString("ssn_id"));
				 customer.setC_name(rs.getString("name"));
				 customer.setC_email(rs.getString("cust_email"));
				 customer.setC_address(rs.getString("cust_address"));
				 customer.setC_number(rs.getString("cust_contact_no"));
				 customer.setC_aadhar(rs.getString("cust_aadhar"));
				 customer.setC_pan(rs.getString("cust_pan"));
				 customer.setC_acno(rs.getString("cust_acc_no"));
				 customer.setC_actyp(rs.getString("cust_acc_type"));
				 customer.setC_bal(rs.getString("cust_balance"));
				 
			}
			request.setAttribute("customer", customer);
		} catch(Exception e){
			e.printStackTrace();
			out.println("<h3>Error: "+e.getMessage()+"</h3>");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustRetrieve.jsp");
		dispatcher.forward(request, response);
	}

}
