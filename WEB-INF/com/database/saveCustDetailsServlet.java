package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class saveCustDetailsServlet
 */
@WebServlet("/saveCustDetailsServlet")
public class saveCustDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveCustDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String cust_ssn_no = C_Database.generateID();
		request.setAttribute("customer_ssn_no", cust_ssn_no);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String ssn_id = request.getParameter("customer_ssn_id");
		String name = request.getParameter("customer_name");
		String cust_email = request.getParameter("customer_email");
		String cust_address = request.getParameter("customer_address");
		String cust_contact_no = request.getParameter("contact_no");
		String cust_aadhar = request.getParameter("aadhar_no");
		String cust_pan = request.getParameter("pan_no");
		String cust_acc_no = request.getParameter("account_no");
		String cust_acc_type = request.getParameter("account_type");
		String cust_balance = request.getParameter("account_balance");
		
		Customer c = new Customer(ssn_id, name, cust_email, cust_address, cust_contact_no, cust_aadhar, cust_pan, cust_acc_no, cust_acc_type, cust_balance);
		
		try(Connection con = Database.connect()) {
			
			int updated = C_Database.insert(c);
			if(updated == 1){
				out.println("<h3>Customer Successfully Registered.</h3>");
				out.println("<a href='EmpHome.jsp'>Go back to Employee Home Page</a>");
				//response.sendRedirect("EmpHome.jsp");
			}
			else {
				out.println("<h3> Failed to register the customer.</h3>");
				out.println("<a href='index.jsp'>Go back to index Page</a>");
			}
			
			
			
			/*
			String sql1 = "insert into BankDatabase.CustDetails (ssn_id, name, cust_email, cust_address, cust_contact_no, cust_aadhar, cust_pan, cust_acc_no, cust_balance) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql1);
			
			ps.setString(1, ssn_id);
			ps.setString(2, name);
			ps.setString(3, cust_email);
			ps.setString(4, cust_address);
			ps.setString(5, cust_contact_no);
			ps.setString(6, cust_aadhar);
			ps.setString(7, cust_pan);
			ps.setString(8, cust_acc_no);
			ps.setString(9, cust_balance);
			
			int rowsInserted = ps.executeUpdate();
			if(rowsInserted > 0) {
				out.println("<h3> Emp details are saved successfully</h3>");
			} else {
				out.println("<h3> Failed to save Emp Details</h3>");
			}	
			*/
			
			
		}catch (Exception e) {
			e.printStackTrace();
			out.println("<h3>Error: "+e.getMessage() +"</h3>");
		}	
		
		
	}

}
