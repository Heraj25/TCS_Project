<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Page</title>
</head>

<body>
<form action="saveEmpDetailsServlet" method="post">


		<center>
			<h1>Please Register yourself as an Employee.</h1>
			<br>
			<br>
			<label for="EmployeeID">EmployeeID:</label>
			<br><input type="text" id="empid" name="empid" maxlength="7" pattern="[0-9]{7}" title="Enter 7 digits" required>
			<br>
			<br>
			<label for="First Name">First Name:</label><br><input type="text" id="fname" name="fname" maxlength="50" pattern="[A-Za-z]{3,}" title="Enter minimum 3 characters" required>
			<br>
			<br>
			<label for="Last Name">Last Name:</label><br><input type="text" id="lname" name="lname" maxlength="50" pattern="[A-Za-z]{3,}" title="Enter minimum 3 characters" required>
			<br>
			<br>
			<label for="Email">Email:</label><br><input type="email" id="email" name="email" required>
			<br>
			<br>
			<label for="Password">Password:</label><br><input type="password" id="password" name="password" maxlength="30" minlength="8" required>
			<br>
			<br>
			<label for="Confirm Password">Confirm Password:</label><br><input type="password" id="cpassword" name="cpassword" maxlength="30" required>
			<br>
			<span id="error"></span>
			<br>
			<label for="Address">Address:</label><br><input type="address" id="address" name="address" maxlength="100" pattern="[A-Za-z0-9]{3}[A-Za-z0-9 ]{1,}" title="Enter minimum 3 characters" required>
			<br>
			<br>
			<label for="Contact no">Contact no:</label><br><input type="text" id="mobile" name="mobile" maxlength="10" pattern="[6-9]{1}[0-9]{9}" required>
			<br>
			<br>
			<input type="submit" value="Register">
			<br>
			<br>
			OR <br>
			<br>
			
			<br>
			<input type="submit" value="Login as existing User">
		</center>

</form>

</body>

</html>