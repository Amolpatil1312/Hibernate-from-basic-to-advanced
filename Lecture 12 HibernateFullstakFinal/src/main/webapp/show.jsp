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
					class="nav-link">Customer</a></li>
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
			<form action="CustomerController" method="get">
			<input type="hidden" name="action" value="findbyid">
			<input type="text" name="custid">
			<input type="submit" value="Search By Id"> 
			</form>
			
			<form action="CustomerController" method="get">
			<input type="hidden" name="action" value="findbyname">
			<input type="text" name="custname">
			<input type="submit" value="Search By Name"> 
			</form>
			
			<form action="CustomerController" method="get">
			<input type="hidden" name="action" value="findbyemailid">
			<input type="text" name="custemailid">
			<input type="submit" value="Search By Email"> 
			</form>
			
		<form action="CustomerController" method="get">
			<input type="hidden" name="action" value="findbydob">
			<input type="text" name="custdob">
			<input type="submit" value="Search By DOB"> 
			</form> 
			
			<form action="CustomerController" method="get">
			<input type="hidden" name="action" value="findbyanyinput">
			<input type="text" name="anyinput">
			<input type="submit" value="Search By Any Input"> 
			</form>
			
			<form action="CustomerController" method="get">
			<input type="hidden" name="action" value="findbycontactnumber">
			<input type="text" name="custcontactnumber">
			<input type="submit" value="Search By Contact Number"> 
			</form>
			
			
			<form action="CustomerController" method="get">
			<input type="hidden" name="action" value="filterbyaccbalance">
			<input type="text" name="custaccbalance">
			<input type="submit" value="Filter by Acc Balance"> 
			</form>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th><a href="CustomerController?action=sortbyid">Id</a></th>
						<th><a href="CustomerController?action=sortbyname">Name</a></th>
						<th>Address</th>
						
						<th> <a href="CustomerController?action=sortbyaccbalance">Acc Balance</a></th>
						<th>Contact Number</th>
						<th>Department</th>
						<th>State</th>
						<th> <a href="CustomerController?action=sortbygender"> Gender</a></th>
						
						<th><a href="CustomerController?action=sortbydob">DOB</a></th>
						
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
							
							<td><c:out value="${customer.custAccBalance}"/></td>
							<td><c:out value="${customer.custContactNumber}" /></td>
							
							<td><c:out value="${customer.custDepartment}"/></td>
							<td><c:out value="${customer.custState}"/></td>
							
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
			
			
			
			<a href="CustomerController?action=deleteall" class="btn btn-danger">Delete All Customer Data</a>
		</div>
	</div>
</body>
</html>
