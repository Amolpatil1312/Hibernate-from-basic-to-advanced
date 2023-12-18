<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNIN</title>
</head>
<body style="background-color: orange;">

<%
	if(request.getAttribute("message")!=null){
		out.println(request.getAttribute("message"));
	}
%>

<form action="CustomerController" method="get">
<input type="hidden" name="action" value="signin">

Customer Email<input type="email" name="custemailid"><br>
Customer Password<input type="password" name="custpassword"><br>
<input type="submit" value="SignIn"><br>
</form>

</body>
</html>