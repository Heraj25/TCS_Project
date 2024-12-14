<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration Page</title>
</head>
<body>
<center>
<form action="saveCustDetailsServlet" method="post">

<h1>Customer Registration Page</h1>
Customer SSN ID:<br><input type="text" id="customer_ssn_id" name="customer_ssn_id" pattern="[1-9]{1}[0-9]{6}" required><br><br>
Customer Name:<br><input type="text" id="customer_name" name="customer_name" maxlength=50 pattern="[A-Za-z]{3,}" title="Enter minimum 3 characters" required><br><br>
Email:<br><input type="email" id="customer_email" name="customer_email" maxlength=30 required><br><br>
Address:<br><input type="text" id="customer_address" name="customer_address" maxlength=100 pattern="[A-Za-z0-9]{3}[A-Za-z0-9 ]{1,}" title="Enter minimum 3 characters" required><br><br>
Contact Number:<br><input type="text" id="contact_no" name="contact_no" maxlength=10 pattern="[6-9]{1}[0-9]{9}" required><br><br>

Aadhar Card No:<br><input type="text" id="aadhar_no" name="aadhar_no" maxlength=12 pattern="[1-9]{1}[0-9]{11}" required><br><br>
Pan Card No:<br><input type="text" id="pan_no" name="pan_no" maxlength=10 pattern="[A-Z]{5}[0-9]{4}[A-Z]{1}" required><br><br>
Account Number:<br><input type="text" id="account_no" name="account_no" maxlength=16 pattern="[1-9]{1}[0-9]{15}" title="Enter 16 digits" required><br><br>
Account Type: <br>
			<input type="radio" id="savings" name="account_type" value="savings" required>
				<label for="Savings Account">Savings Account</label>
				<input type="radio" id="current" name="account_type" value="current" required>
				<label for="current">Current Account</label>
				<br><br>
Account Balance:<br><input type="text" id="account_balance" name="account_balance" maxlength=15  pattern="[1-9]{1}[0-9]{2,}" required><br><br>


<input type="submit" value="Register Customer"><br><br>


</form>
</center>
</body>


<!--  
<script>
let cust_ssn_no = Math.floor(Math.random() * (9999999 - 1000000 + 1)) + 1000000;
console.log('success');
localStorage.setItem('customer_ssn_id', cust_ssn_no);


let a = localStorage.getItem('customer_ssn_id');
document.getElementById('customer_ssn_id').innerHTML = a;
</script>
-->

</html>