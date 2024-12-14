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
 * Servlet implementation class BalanceEnquiryServlet
 */
@WebServlet("/BalanceEnquiryServlet")
public class BalanceEnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceEnquiryServlet() {
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
		PrintWriter out = response.getWriter();
		
		String accountNo = request.getParameter("account_no");

        try (Connection con = Database.connect()) {
            // Query to get balance from CustDetails table
            String sql = "SELECT cust_balance FROM BankDatabase.CustDetails WHERE cust_acc_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accountNo);
            ResultSet rs = ps.executeQuery();
            

            if (rs.next()) {
                // Fetch the balance
                String balance = rs.getString("cust_balance");
                
                request.setAttribute("balance", balance); // Pass balance to JSP
            } else {
                // Account not found
            	
                request.setAttribute("errorMessage", "Account number not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error occurred: " + e.getMessage());
        }

        // Forward back to JSP
        request.getRequestDispatcher("BalanceEnquiry.jsp").forward(request, response);
    }
	

}
