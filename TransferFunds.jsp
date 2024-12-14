<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Funds Transfer</title>
</head>
<body><center>
<form action="FundTransferServlet" method="post">
			<fieldset>
				<legend><h1>Enter the details</h1></legend>
			
			<label for="accountnumber">Sender's Account Number: </label><br>
			<input type="text" placeholder="Enter Account Number" pattern="[1-9]{1}[0-9]{9,}" id="accountnumber" name ="ac_no" required minlength="10" maxlength="20"><br>
			<br>
			
			
			<label for="pass">Enter Password: </label><br>
			<input type="password" placeholder="Enter Password" id="pswd" name ="pswd" minlength="8" required><br>
			<br>
			
			<label for="recipientaccountnumber" >Receiver's Account Number: </label><br>
			<input type="text" placeholder="Enter Recipient's Account Number" pattern="[1-9]{1}[0-9]{9,}" id="recipientaccountnumber" title="Enter Valid Account Number" name="rcv_ac"  required minlength="10" maxlength="20"><br>
			<br>


			<label for="amount">Amount: </label><br>
			<input type="text" placeholder="Enter Amount"  id="amount" pattern="[1-9]{1,}[.0-9]{0,}" name="amt" title="Should be greater than 0" required><br>
			<br>
			
			<input type="submit" value="Transfer" >
			</fieldset>
		</form></center>
</body>
</html>