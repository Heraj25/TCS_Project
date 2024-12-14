<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@ page import="com.database.Database" %>
<%@ page import="com.database.transact" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Operations</title>
</head>
<%
    

    transact transactions =(transact) request.getAttribute("transactions");
    String errorMessage = (String) request.getAttribute("errorMessage");
%>


<body>
    <h1>Account Operations</h1>
    <form action="TransactionServlet" method="post">
        <label for="account_no">Account Number:</label>
        <input type="text" id="account_no" name="account_no" minlength="16" required><br><br>
        
        <label for="operation_type">Operation Type:</label>
        <select id="operation_type" name="operation_type" required>
            <option value="deposit">Deposit</option>
            <option value="withdrawal">Withdrawal</option>
        </select><br><br>
        
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" pattern="[0-9]{3,}[.0-9]{0,}" title="Enter amount >=100" required><br><br>
        
        <button type="submit">Submit</button>
    </form>
    <br>
    
	<a href="CustHome.jsp"><input type="button" value="Home Page"></a>
    <!-- Display transaction history -->
    <h2>Transaction History</h2>
    <%
        /* String accountNo = request.getParameter("account_no"); */
        String accountNo = (String)request.getAttribute("account_no");;
        if (accountNo != null && !accountNo.isEmpty()) {
            try (Connection con = Database.connect()) {
                String sql = "SELECT * FROM BankDatabase.TransactionHistory WHERE account_no = ? ORDER BY transaction_date DESC";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, accountNo);
                ResultSet rs = ps.executeQuery();
    %>
    <table border="1">
        <tr>
            <th>Transaction ID</th>
            <th>Account Number</th>
            <th>Transaction Type</th>
            <th>Amount</th>
            <th>Balance After Transaction</th>
            <th>Transaction Date</th>
        </tr>
        <%
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("transaction_id") %></td>
            <td><%= rs.getString("account_no") %></td>
            <td><%= rs.getString("transaction_type") %></td>
            <td><%= rs.getString("amount") %></td>
            <td><%= rs.getString("balance_after_transaction") %></td>
            <td><%= rs.getTimestamp("transaction_date") %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
            } catch (Exception e) {
                e.printStackTrace();
    %>
    <p>Error: <%= e.getMessage() %></p>
    <%
            }
        } else {
    %>
    <p>Enter an account number to view transaction history.</p>
    <%
        }
    %>
</body>
</html>












<%-- 


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions Page</title>
</head>
<body>
<form action="TransactionServlet" method="post">
			<fieldset>
				<legend><h1>Enter following Details </h1></legend>
			<label for="accountnumber">Account Number: </label><br>
			<input type="text" placeholder="Enter Account Number"  id="accountnumber" name="accountnumber" pattern="[1-9]{1}[0-9]{9,}" title ="Enter Valid Account Number" required><br>
			<br>

			<p> Account Operation: </p><br>
			<div id="acc_action">
				<input type="radio" id="deposit" name="acc_action" value="deposit" checked>
				<label for="deposit">Deposit</label>
				<input type="radio" id="withdrawal" name="acc_action" value="withdrawal">
				<label for="withdrawal">Withdraw</label>
			</div>
			<br> <br>
			
			<label for="transactionamount">Amount: </label><br>
			<input type="text" placeholder="Enter Amount" pattern="[1-9]{1,}[.0-9]{0,}" title="Should be greater than 0" id="transactionamount" name="transactionamount" required><br>
			<br>
			
			
			
			<input type="submit" >
			</fieldset>
		</form>
</body>
</html> --%>