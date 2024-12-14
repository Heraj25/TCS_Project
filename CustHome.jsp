<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Home Page</title>

    
</head>
<body>
    <div class="header">
        <span>Welcome, <%= request.getAttribute("cust_name") != null ? request.getAttribute("customerName") : "Customer" %></span>
        <a href="index.jsp">Logout</a>
    </div>
    <div class="container">
        <h2>Customer Home Page</h2>
        <button class="btn btn-view" onclick="window.location.href='BalanceEnquiry.jsp'">View Balance</button>
        <button class="btn btn-transfer" onclick="window.location.href='FundTransfer.jsp'">Transfer Funds</button>
        <button class="btn btn-transfer" onclick="window.location.href='Transaction.jsp'">Transaction</button>
        <div id="balance-section" class="balance-section"></div>
    </div>
</body>
</html>
