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
<script>
function validate() {
	var myForm = document.getElementById("myForm");
	var ccNumber = myForm["ccNumber"].value;
	var exprDate = myForm["exprDate"].value;
	var cvv = myForm["cvv"].value;
	var name = myForm["name"].value;
	
	if(ccNumber.length < 16) {
		alert("Credit Card Number invalid. Please enter again.");
		return false;
	} else if (ccNumber.length > 16) {
		alert("Credit Card Number should be 16 digits. Please enter again.");
		return false;
	}
	
	var year = exprDate.charAt(3) + exprDate.charAt(4);
	if((exprDate.charAt(2) != "/") || (exprDate.length != 5)) {
		alert("Please enter in the format mm/yy");
		return false;
	} else if (parseInt(year) < 20) {
		alert("Invalid year. Please enter again.");
		return false;
	}
	
	if(cvv.length != 3) {
		alert("CVV Code should be 3 digits. Please enter again.");
		return false;
	}
	
	if(name.length <= 1) {
		alert("Name should have length more than 1. Please enter again.");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div style="height:70vh;">
<form:form id="myForm" modelAttribute="payment" method="post" action="submitPayment" onsubmit="return validate()">
    <table class="table">
		<tr>
			<td>Credit Card Number:</td>
			<td><form:input id="ccNumber" path="creditCardNumber" placeholder="Credit Card Number" required="required" /></td>
		<tr />
		<tr>
			<td>Expiration Date:</td>
			<td><form:input id="exprDate" path= "exprDate" placeholder="mm/yy" required="required"/></td>
		<tr />
		<tr>
			<td>CVV Code:</td>
			<td><form:input id="cvv" path="cvvCode" placeholder="CVV Code" required="required"/></td>
		<tr />
		<tr>
			<td>Card Holder Name:</td>
			<td><form:input id="name" path="cardholderName" placeholder="Card Holder Name" required="required"/></td>
		<tr />
		<tr>
			<td colspan="2"><input type="submit" value="Pay"></td>
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