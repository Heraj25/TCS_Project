package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustLoginServlet
 */
@WebServlet("/CustLoginServlet")
public class CustLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustLoginServlet() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String custssnid = request.getParameter("custssnid");
		String custpassword = request.getParameter("custpassword");
		
		try(Connection con = Database.connect()) {
			String sql3 = "select ssn_id, name, cust_acc_no from BankDatabase.CustDetails where ssn_id=?";
			PreparedStatement ps = con.prepareStatement(sql3);
			//setting the entered customer id in the login page as custssnid
			ps.setString(1, custssnid);
			ResultSet rs = ps.executeQuery();

			
			if(rs.next()) {
				String name = rs.getString("name");
				String accNo = rs.getString("cust_acc_no");
				
				String defaultPassword = name.substring(0,4) + accNo.substring(accNo.length()-4);
				
				if(custpassword.equals(defaultPassword)) {
					out.println("<h3> Customer Login Successful</h3>");
					out.println("<a href='CustHome.jsp'>Go to Customer Home Page</a>");
					
					}
				 else {
					out.println("<h3>Invalid Password. Please try again.</h3>");
					out.println("<a href='CustLogin.jsp'>Go back to Customer login page</a>");
				}
			}
			else {
				out.println("<h3>Invalid Customer Ssn Id. Please try again.</h3>");
				out.println("<a href='CustLogin.jsp'>Go back to Customer login page</a>");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			out.println("<h3>Error: "+ e.getMessage() +"</h3>");
		}
	}

}
