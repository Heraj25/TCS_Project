package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String transType=respo
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accountNo = request.getParameter("account_no");
        String operationType = request.getParameter("operation_type");
        String amountStr = request.getParameter("amount");
        PrintWriter out = response.getWriter();
  
        try (Connection con = Database.connect()) {
            // Get current balance from CustDetails table
            String sql = "SELECT cust_balance FROM BankDatabase.CustDetails WHERE cust_acc_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accountNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String currentBalanceStr = rs.getString("cust_balance");
                double currentBalance = Double.parseDouble(currentBalanceStr);
                double amount = Double.parseDouble(amountStr);
                double newBalance = 0.0;
                
//                transact transactions = new transact();
//                transactions.setTransactionId(rs.getInt("transaction_id"));
//                transactions.setTransactionType(rs.getString("transaction_type"));
//                transactions.setAmount(rs.getString("amount"));
//                transactions.setTransactionDate(rs.getTimestamp("transaction_date").toString());
//                transactions.setBalanceAfterTransaction(rs.getString("balance_after_transaction"));

                

                if ("deposit".equalsIgnoreCase(operationType)) {
                    newBalance = currentBalance + amount;

                    // Update balance in CustDetails table
                    sql = "UPDATE BankDatabase.CustDetails SET cust_balance = ? WHERE cust_acc_no = ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, String.valueOf(newBalance));
                    ps.setString(2, accountNo);
                    ps.executeUpdate();

                    // Insert transaction into TransactionHistory table
                    sql = "INSERT INTO BankDatabase.TransactionHistory (account_no, transaction_type, amount, balance_after_transaction) VALUES (?, ?, ?, ?)";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, accountNo);
                    ps.setString(2, "deposit");
                    ps.setString(3, amountStr);
                    ps.setString(4, String.valueOf(newBalance));
                    ps.executeUpdate();

                    out.println("<h3>Deposit successful! New balance: " + newBalance + "</h3>");
                    out.println("<a href='CustHome.jsp'><input type='button' value='Return to Customer Home'>");
                } else if ("withdrawal".equalsIgnoreCase(operationType)) {
                    if (currentBalance >= amount) {
                        newBalance = currentBalance - amount;

                        // Update balance in CustDetails table
                        sql = "UPDATE BankDatabase.CustDetails SET cust_balance = ? WHERE cust_acc_no = ?";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, String.valueOf(newBalance));
                        ps.setString(2, accountNo);
                        ps.executeUpdate();

                        // Insert transaction into TransactionHistory table
                        sql = "INSERT INTO BankDatabase.TransactionHistory (account_no, transaction_type, amount, balance_after_transaction) VALUES (?, ?, ?, ?)";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, accountNo);
                        ps.setString(2, "withdrawal");
                        ps.setString(3, amountStr);
                        ps.setString(4, String.valueOf(newBalance));
                        ps.executeUpdate();

                        out.println("<h3>Withdrawal successful! New balance: " + newBalance + "</h3>");
                        out.println("<a href='CustHome.jsp'><input type='button' value='Return to Customer Home'>");
                    } else {
                        out.println("<h3>Insufficient funds! Withdrawal failed.</h3>");
                        out.println("<a href='CustHome.jsp'><input type='button' value='Redirect to Customer Home. Please try again.'>");
                    }
                }
            } else {
                out.println("<center><h3>Account does not exist!</h3></center>");
                out.println("<a href='CustHome.jsp'><input type='button' value='Redirect to Customer Home. Please try again.'>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
        
        request.setAttribute("account_no", accountNo);
        request.getRequestDispatcher("Transaction.jsp").forward(request, response);
    }
}		

		
		


