<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Balance Enquiry</title>
</head>
<body>
    <h1>Balance Enquiry</h1>
    <form action="BalanceEnquiryServlet" method="post">
        <label for="account_no">Enter Account Number:</label>
        <input type="text" id="account_no" name="account_no" required><br><br>
        <button type="submit">Check Balance</button>
    </form>

    <%
        // Display balance if it's passed as a request attribute
        String balance = (String) request.getAttribute("balance");
        String errorMessage = (String) request.getAttribute("errorMessage");

        if (balance != null) {
    %>
    <h2>Your Current Balance: &#8377; <%= balance %></h2>
    <%
        } else if (errorMessage != null) {
    %>
    <h3 style="color: red;"><%= errorMessage %></h3>
    <%
        }
    %>
	<a href="CustHome.jsp"><input type="button" value="Go back to Customer Home"></a>
</body>
</html>




