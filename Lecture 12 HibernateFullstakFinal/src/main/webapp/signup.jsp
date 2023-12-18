<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: gray;">

<form action="CustomerController" method="get">

<input type="hidden" name="action" value="signup">

Customer Name<input type="text" name="custname"><br>
Customer Address<input type="text" name="custaddress"><br>
Customer Acc Balance<input type="text" name="custaccbalance"><br>
Customer Conatct Number<input type="text" name="custcontactnumber"><br>
Customer Department
IT<input type="checkbox" name="custdepartment" value="IT">
HR<input type="checkbox" name="custdepartment" value="HR">
QA<input type="checkbox" name="custdepartment" value="QA"><br>
Customer State
<select name="custstate">
<option value="MH">MH</option>
<option value="GJ">GJ</option>
<option value="MP">MP</option>
</select><br>
Customer Gender
Male<input type="radio" name="custgender" value="Male">
Female<input type="radio" name="custgender" value="Female"><br>
Customer DOB<input type="date" name="custdob"><br>
Customer Email<input type="email" name="custemailid"><br>
Customer Password<input type="password" name="custpassword"><br>
<input type="submit" value="SignUp"><br>

</form>

</body>
</html>