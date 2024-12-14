<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Customer Details</title>
</head>
<body>
<center>
<form action="CustDeleteServlet" method="post">

<h1>Remove Customer Details</h1>
<h4>Enter the customer ssn id</h4>
<label for="customer_ssn_id">Customer SSN ID:</label><br>
<input type="text" id="customer_ssn_id" name="customer_ssn_id" maxlength=7 pattern="[1-9]{1}[0-9]{6}" required ><br><br>



<input type="submit" value="Click here to remove Customer"><br><br>



</form>
</center>
</body>
</html>