<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Login</title>
   
</head>
<body>
	<center>
    <div class="login-container">
        <h2>Customer Login</h2>
        <form action="CustLoginServlet" method="post">
            <div class="form-group">
                <label for="custssnid">Customer SSNID:</label><br>
                <input type="text" id="custssnid" name="custssnid" placeholder="Enter your SSNID" pattern="[1-9]{1}[0-9]{6}" title="Enter 7 digits" required>
            </div>
            <br><br>
            <div class="form-group">
                <label for="custpassword">Password:</label><br>
                <input type="password" id="custpassword" name="custpassword" placeholder="Enter your password"  minlength=8 title="Name 1st 4-char [xxxx] and Acc No last 4-digits [xxxx]" required>
            </div><br>
            <input type="submit" value="Login">
        </form>
    </div>
    </center>
</body>
</html>