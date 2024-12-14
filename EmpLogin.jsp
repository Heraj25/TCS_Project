<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login Page</title>
</head>

<body>
	<center>
		<form action="EmpLoginServlet" method="post">
			<h1>Employee Login Page</h1>
			<label for="EmployeeID">EmployeeID:</label><br><input type="text" id="loginid" name="loginid" maxlength="7" required>
			<br>
			<br> 
			<label for="Password">Password:</label><br><input type="password" id="loginpassword" name="loginpassword" maxlength="30" required>
			<br>
			<br>
			<input type="submit" value="Login">

		</form>
	</center>
</body>

</html>