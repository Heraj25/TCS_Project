<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Fund Transfer</h1>
    <form action="FundTransferServlet" method="post">
        <label for="from_account">Your Account Number:</label>
        <input type="text" id="from_account" name="from_account" minlength=16 required><br><br>

        <label for="password">Enter Your Account Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="to_account">Recipient Account Number:</label>
        <input type="text" id="to_account" name="to_account" minlength=16 required><br><br>

        <label for="amount">Amount to Transfer:</label>
        <input type="text" id="amount" name="amount" pattern="[1-9]{1}[0-9]{2,}[.0-9]{0,}" maxlength=16 title="Enter amount >=100" required><br><br>

        <button type="submit">Transfer Funds</button>
    </form>
    <br>
    <a href="CustHome.jsp"><input type="button" value="Go back to Customer Home"></a>

    <%
        String message = (String) request.getAttribute("message");
        String errorMessage = (String) request.getAttribute("errorMessage");

        if (message != null) {
    %>
        <h3 style="color: green;"><%= message %></h3>
    <%
        } else if (errorMessage != null) {
    %>
        <h3 style="color: red;"><%= errorMessage %></h3>
    <%
        }
    %>


</body>
</html>