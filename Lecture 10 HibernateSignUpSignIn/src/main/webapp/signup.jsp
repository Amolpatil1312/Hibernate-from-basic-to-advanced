<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP</title>
</head>
<body style="background-color: tomato">

<form action="CustomerController" method="get">
<input type="hidden" name="action" value="signup">

Name<input type="text" name="custname"><br>
Address<input type="text" name="custaddress"><br>
Acc Balance<input type="text" name="custaccountbalance"><br>
Contact Number<input type="text" name="custcontactnumber"><br>
Gender<br>
Male<input type="radio" name="custgender" value="Male">
Female<input type="radio" name="custgender" value="Female"><br>
DOB<input type="date" name="custdob"><br>
Email<input type="email" name="custemailid"><br>
Password<input type="password" name="custpassword"><br>
<input type="submit" value="Register"><br>
</form>
</body>
</html>