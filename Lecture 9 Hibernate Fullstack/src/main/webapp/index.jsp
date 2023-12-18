<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body style="background-color: lime;">

<form action="CustomerController" method="get">
<label>Customer Name</label>
<input type="text" name="custname"><br>

<label>Customer Address</label>
<input type="text" name="custaddress"><br>

<label>Customer Contact Number</label>
<input type="number" name="custcontactnumber"><br>

<label>Customer Account Balance</label>
<input type="text" name="custaccountbalance"><br>

<label>Customer DOB</label>
<input type="date" name="custdob"><br>

<label>Customer Email</label>
<input type="email" name="custemailid"><br>

<label>Customer Password</label>
<input type="password" name="custpassword"><br>

<input type="submit" value="SignUp">
</form>
</body>
</html>