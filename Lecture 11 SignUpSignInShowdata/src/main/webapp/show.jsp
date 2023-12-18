<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>


<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>Customer List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>



	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: 	green">
			<div>
				<a href="http://www.fullstackjavadeveloper.in" class="navbar-brand"> User
					Customer Mgnt App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Customers</h3>
			<hr>
			<div class="container text-left">

				<a href="signup.jsp" class="btn btn-success">Add
					New Customer Data</a>
			</div>
			
			<div>
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="searchbyid">
			<input type="text" name="empid">
			<input type="submit" value="Search By Id"> 
			</form>
			
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="searchbyname">
			<input type="text" name="empname">
			<input type="submit" value="Search By Name"> 
			</form>
			
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="searchbyemail">
			<input type="text" name="empemailid">
			<input type="submit" value="Search By Email"> 
			</form>
			
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="searchbyuid">
			<input type="text" name="empuid">
			<input type="submit" value="Search By UID"> 
			</form>
			
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="searchbypancard">
			<input type="text" name="emppancard">
			<input type="submit" value="Search By PanCard"> 
			</form>
			
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="searchbycontactnumber">
			<input type="text" name="empcontactnumber">
			<input type="submit" value="Search By Contact Number"> 
			</form>
			
			
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="filterbysalary">
			<input type="text" name="empsalary">
			<input type="submit" value="Filter by Salary"> 
			</form>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th><a href="EmployeeController?action=sortbyid">Id</a></th>
						<th><a href="EmployeeController?action=sortbyname">Name</a></th>
						<th>Address</th>
						
						<th> <a href="EmployeeController?action=sortbysalary">Acc Balance</a></th>
						<th>Contact Number</a></th>
						
						
						
						<th> <a href="EmployeeController?action=sortbygender"> Gender</a></th>
						
						<th><a href="EmployeeController?action=sortbydob">DOB</a></th>
						
						<th>Email</th>
						<th>Password</th>
						
						
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="customer" items="${custList}">

						<tr>
							<td><c:out value="${customer.custId}" /></td>
							<td><c:out value="${customer.custName}" /></td>
							<td><c:out value="${customer.custAddress}" /></td>
							
							<td><c:out value="${customer.custAccountBalance}"/></td>
							<td><c:out value="${customer.custContactNumber}" /></td>
							
							
							
							<td><c:out value="${customer.custGender}"/></td>
							
							<td><fmt:formatDate value = "${customer.custDOB}"  type = "date"  pattern = "dd-MM-yyyy" /></td>
							
						
							
							<td><c:out value="${customer.custEmailId}" /></td>
							<td><c:out value="${customer.custPassword}" /></td>
							<td><a href="CustomerController?action=edit_form&custid=<c:out value='${customer.custId}' />" class="btn btn-success">Update</a>
								 <a
								href="CustomerController?action=deletebyid&custid=<c:out value='${customer.custId}' />" class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
			
			
			
			<a href="EmployeeController?action=deletealldata" class="btn btn-danger">Delete All Employee Data</a>
		</div>
	</div>
</body>
</html>
