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
	var name = myForm["name"].value;
	var city = myForm["city"].value;
	var state = myForm["state"].value;
	var zip = myForm["zip"].value;
	
	if(name.length <= 1) {
		alert("Name should have length more than 1. Please enter again.");
		return false;
	}
	
	if(city.length <= 1) {
		alert("City should have length more than 1. Please enter again.");
		return false;
	}
	
	if(state.length <= 1) {
		alert("State should have length more than 1. Please enter again.");
		return false;
	}
	
	return true;
}

</script>
</head>
<body>
<div style="height:70vh;">
<form:form id="myForm" modelAttribute="shipping" method="post" action="submitShipping" onsubmit="return validate()">    
     <table class="table">
		<tr>
			<td>Name:</td>
			<td><form:input id="name" path="name" placeholder="Name" required="required"/></td>
		</tr>
		<tr>
			<td>Address Line 1:</td>
			<td><form:input id="add1" path="addressLine1" placeholder="Address Line 1" required="required"/></td>
		</tr>
		<tr>
			<td>Address Line 2:</td>
			<td><form:input id="add2" path="addressLine2" placeholder="Address Line 2 (Optional)" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><form:input id="city" path="city" placeholder="City" required="required" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><form:input id="state" path="state" placeholder="State" required="required"/></td>
		</tr>
		<tr>
			<td>Zip Code:</td>
			<td><form:input id="zip" path="zip" placeholder="Zip" required="required"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit Shipping Details"></td>
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