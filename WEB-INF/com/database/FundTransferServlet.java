package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FundTransferServlet
 */
@WebServlet("/FundTransferServlet")
public class FundTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundTransferServlet() {
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
		 	String fromAccount = request.getParameter("from_account");
	        String password = request.getParameter("password");
	        String toAccount = request.getParameter("to_account");
	        String amountStr = request.getParameter("amount");

	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            double amount = Double.parseDouble(amountStr);
	            DecimalFormat df = new DecimalFormat("#.00");
	            amount = Double.parseDouble(df.format(amount));
	            con = Database.connect();
	            con.setAutoCommit(false); // Begin transaction

	            // Validate sender account and password
	            String query = "SELECT name, cust_balance FROM BankDatabase.CustDetails WHERE cust_acc_no = ?";
	            ps = con.prepareStatement(query);
	            ps.setString(1, fromAccount);
	            rs = ps.executeQuery();

	            if (!rs.next()) {
	                request.setAttribute("errorMessage", "Invalid sender account number.");
	                request.getRequestDispatcher("FundTransfer.jsp").forward(request, response);
	                return;
	            }

	            String custName = rs.getString("name");
	            double fromBalance = Double.parseDouble(rs.getString("cust_balance"));
	            String expectedPassword = custName.substring(0, 4) + fromAccount.substring(fromAccount.length() - 4);

	            if (!expectedPassword.equals(password)) {
	                request.setAttribute("errorMessage", "Invalid password.");
	                request.getRequestDispatcher("FundTransfer.jsp").forward(request, response);
	                return;
	            }

	            // Check recipient account
	            query = "SELECT cust_balance FROM BankDatabase.CustDetails WHERE cust_acc_no = ?";
	            ps = con.prepareStatement(query);
	            ps.setString(1, toAccount);
	            rs = ps.executeQuery();

	            if (!rs.next()) {
	                request.setAttribute("errorMessage", "Recipient account not found.");
	                request.getRequestDispatcher("FundTransfer.jsp").forward(request, response);
	                return;
	            }

	            double toBalance = Double.parseDouble(rs.getString("cust_balance"));

	            // Validate sufficient funds
	            if (fromBalance < amount) {
	                request.setAttribute("errorMessage", "Insufficient funds for transfer.");
	                request.getRequestDispatcher("FundTransfer.jsp").forward(request, response);
	                return;
	            }
	            
	            
	            // Update sender's balance
	            double updatedFromBalance = fromBalance - amount;
	            query = "UPDATE BankDatabase.CustDetails SET cust_balance = ? WHERE cust_acc_no = ?";
	            ps = con.prepareStatement(query);
	            ps.setString(1, String.valueOf(df.format(updatedFromBalance)));
	            ps.setString(2, fromAccount);
	            ps.executeUpdate();

	            // Update recipient's balance
	            double updatedToBalance = toBalance + amount;
	            ps.setString(1, String.valueOf(df.format(updatedToBalance)));
	            ps.setString(2, toAccount);
	            ps.executeUpdate();

	            // Insert transaction for sender
	            query = "INSERT INTO BankDatabase.TransactionHistory (account_no, transaction_type, amount, balance_after_transaction) VALUES (?, ?, ?, ?)";
	            ps = con.prepareStatement(query);
	            ps.setString(1, fromAccount);
	            ps.setString(2, "withdrawal");
	            ps.setString(3, amountStr);
	            ps.setString(4, String.valueOf(df.format(updatedFromBalance)));
	            ps.executeUpdate();

	            // Insert transaction for recipient
	            ps.setString(1, toAccount);
	            ps.setString(2, "deposit");
	            ps.setString(3, amountStr);
	            ps.setString(4, String.valueOf(df.format(updatedToBalance)));
	            ps.executeUpdate();

	            // Commit transaction
	            con.commit();

	            request.setAttribute("message", "Fund transfer successful!");
	        } catch (NumberFormatException e) {
	            request.setAttribute("errorMessage", "Invalid amount entered.");
	        } catch (Exception e) {
	            if (con != null) {
	                try {
	                    con.rollback(); // Rollback on failure
	                } catch (Exception rollbackEx) {
	                    rollbackEx.printStackTrace();
	                }
	            }
	            request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
	        } finally {
	            if (rs != null) try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            if (ps != null) try { ps.close(); } catch (Exception e) { e.printStackTrace(); }
	            if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
	        }

	        // Forward to JSP
	        request.getRequestDispatcher("FundTransfer.jsp").forward(request, response);
	    }
	}


