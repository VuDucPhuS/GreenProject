<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Create New Book</title>
	<link rel="stylesheet" href="../css/style.css">
	
	<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div align="center">
		<h2 class="pageheading">
			<c:if test="${customer != null}">
				Edit Customer
			</c:if>
			<c:if test="${customer == null}">
				Create New Customer
			</c:if>
		</h2>
	</div>
	
	<div align="center">
		<c:if test="${customer != null}">
			<form action="update_customer" method="post" id="customerForm" enctype="multipart/form-data">
			<input type="hidden" name="customerId" value="${customer.customerId}">
		</c:if>
		<c:if test="${book == null}">
			<form action="create_customer" method="post" id="customerForm" enctype="multipart/form-data">
		</c:if>
		
		<table class="form">
			<tr>
				<td align="right">E-mail:</td>
				<td align="left"><input type="text" id="email" name="email" size="45" value="${customer.email}"></td>
			</tr>
			<tr>
				<td align="right">Full Name:</td>
				<td align="left"><input type="text" id="fullName" name="fullName" size="45" value="${customer.fullName}"></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="text" id="password" name="password" size="45" value="${customer.password}"></td>
			</tr>
			<tr>
				<td align="right">Confirm Password:</td>
				<td align="left"><input type="text" id="confirmPassword" name="confirmPassword" size="45" value="${customer.password}"></td>
			</tr>
			<tr>
				<td align="right">Phone Number:</td>
				<td align="left"><input type="text" id="phone" name="phone" size="45" value="${customer.phone}"></td>
			</tr>
			<tr>
				<td align="right">Address:</td>
				<td align="left"><input type="text" id="address" name="address" size="45" value="${customer.address}"></td>
			</tr>
			<tr>
				<td align="right">City:</td>
				<td align="left"><input type="text" id="city" name="city" size="45" value="${customer.city}"></td>
			</tr>
			<tr>
				<td align="right">Zip Code:</td>
				<td align="left"><input type="text" id="zipcode" name="zipcode" size="45" value="${customer.zipCode}"></td>
			</tr>
			<tr>
				<td align="right">Country:</td>
				<td align="left"><input type="text" id="country" name="country" size="45" value="${customer.country}"></td>
			</tr>
			
			
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
					<button id="buttonCancel">Cancel</button>
				</td>
			</tr>
		</table>
		</form>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">

	$(document).ready(function() {
		
		$("#customerForm").validate({
			rules: {
				email: "required",
				fullName: "required",
				password: "required",
				confirmPassword: "required",
				phone: "required",
				address: "required",
				city: "required",
				zipCode: "required",
				country: "required",
			},
			
			messages: {
				category: "Please select a category for the book",
				title: "Please enter title of the book",
				author: "Please enter author of the book",
				isbn: "Please enter isbn of the book",
				publishDate: "Please enter publish date of the book",
				bookImage: "Please choose an image of the book",
				price: "Please enter price of the book",
				description: "Please enter description of the book"
			}
		});
		
		$("#buttonCancel").click(function(){
			history.go(-1);
		});
	});
	
</script>
</html>