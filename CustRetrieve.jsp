<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.database.Customer" %>
<%@ page import="com.database.C_Database" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
	<center>
	<h1>Customer Details</h1>
	<%
		
		Customer customer = (Customer) request.getAttribute("customer");
		if(customer != null) {
	%>
	
		<p><strong>SSN ID: </strong><%=customer.getC_ssn() %></p>
		<p><strong>Name: </strong><%=customer.getC_name() %></p>
		<p><strong>Email: </strong><%=customer.getC_email() %></p>
		<p><strong>Address: </strong><%=customer.getC_address() %></p>
		<p><strong>Contact No: </strong><%=customer.getC_number() %></p>
		<p><strong>Aadhar No: </strong><%=customer.getC_aadhar() %></p>
		<p><strong>Pan No: </strong><%=customer.getC_pan() %></p>
		<p><strong>Account No: </strong><%=customer.getC_acno() %></p>
		<p><strong>Account Type: </strong><%=customer.getC_actyp() %></p>
		<p><strong>Balance Amount: </strong><%=customer.getC_bal() %></p>
		<a href='EmpHome.jsp'>Go back to Home Page</a><br><br>
		<form action="CustDeleteServlet" method="post">
			<input type="hidden" name="customer_ssn_id" value="<%= customer.getC_ssn() %>">
			<input type="submit" value="Remove Customer">
		
		</form>
	<%
		} else {
	%>
	
		<p>No Customer found with the provided SSN ID.</p><br>
		<a href='ViewCustDetail.jsp'>Please try again.</a>
	
	<%
		}
	%>
	
	</center>
</body>
</html>