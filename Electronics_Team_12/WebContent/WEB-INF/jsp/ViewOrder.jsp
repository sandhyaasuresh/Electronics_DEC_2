<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "HeaderJSP.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div>
<form:form method="post" action="confirmOrder">
<h2>Order Information</h2>
<table class="table">
	<tr>
		<td>Name</td>
		<td>Price</td>
		<td>Quantity</td>
	</tr>
	<c:forEach items="${order.getItems()}" var="item" varStatus="loop">
		<tr>
			<td>${item.name}</td>
			<td>${item.price}</td>
			<td>${item.quantity}</td>
		</tr>
	</c:forEach>
</table>
<h2>Payment Information</h2>
<table class="table">
	<tr>
		<td>Credit Card Number:</td>
		<td>${order.paymentInfo.creditCardNumber}</td>
	</tr>
	<tr>
		<td>Expiration Date:</td>
		<td>${order.paymentInfo.exprDate}</td>
	</tr>
	<tr>
		<td>CVV Code:</td>
		<td>${order.paymentInfo.cvvCode}</td>
	</tr>
	<tr>
		<td>Card Holder Name:</td>
		<td>${order.paymentInfo.cardholderName}</td>
	 </tr>
</table>
<h2>Shipping Information</h2>
<table class="table">
	 <tr>
		<td>Name:</td>
		<td>${order.shippingInfo.name}</td>
	</tr>
	<tr>
		<td>Address Line 1:</td>
		<td>${order.shippingInfo.addressLine1}</td>
	</tr>
	<tr>
		<td>Address Line 2:</td>
		<td>${order.shippingInfo.addressLine2}</td>
	</tr>
	<tr>
		<td>City:</td>
		<td>${order.shippingInfo.city}</td>
	</tr>
	<tr>
		<td>State:</td>
		<td>${order.shippingInfo.state}</td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td>${order.shippingInfo.zip}</td>
	 </tr>
	 <tr>
	 	<td colspan="2"><input type="submit" value="Confirm"></td>
	 </tr>
   </table>
 </form:form>
</div>
</body>
<%@ include file = "FooterJSP.jsp" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>