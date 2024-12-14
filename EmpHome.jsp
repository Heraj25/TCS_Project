<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*" %>
<%
    if (session == null || session.getAttribute("employeeID") == null) {
        response.sendRedirect("EmpLogin.jsp");
        return;
    }

    String employeeID = (String) session.getAttribute("employeeID");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home Page</title>

<!--  
<script type="text/javascript">
	function showCustomerCount() {
		var customerCount = <%= request.getAttribute("customerCount") != null ? request.getAttribute("customerCount") : 0 %>;
		alert("Total Number of Customers: "+customerCount);
	}

</script>
-->

</head>
<body>
	<center>

		<h1>Employee Home Page</h1>
		<div>
			<a href="CustReg.jsp"><input type="button"
				value="Customer Registration" name="Customer Registration"></a>
			<br> <br> <a href="ManageCustomer.jsp"><input
				type="button" value="Manage Existing Customer Details"
				name="Manage Existing Customer Details"></a> <br> <br>

			<form action="CustRecallServlet" method="get">
				<input type="submit" value="Recall"> 
				<span> <%= request.getAttribute("customerCount") != null? "Total Customers:"  +request.getAttribute("customerCount") : "" %> </span> <br><br> 	
				
			</form>

			<a href="ViewAllCustomersServlet"><input type="submit"
				value="View all Customers" name="View all Customers"></a>
			<br>
			<br>
			

			<a href="index.jsp"><input type="button" value="Go back to Index Page" ></a>

		</div>

	</center>
</body>

</html>