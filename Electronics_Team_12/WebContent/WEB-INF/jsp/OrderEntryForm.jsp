<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "HeaderJSP.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Entry Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div style="height:70vh;">
	<form:form modelAttribute="order" method="post" action="purchase/submitItems">
		<table class="table">
			<thead>
			<tr>
				<th scope = "col">Name</th>
				<th scope = "col">Price</th>
				<th scope = "col">Quantity</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${order.getItems()}"  var="item" varStatus="loop">
				<tr>
					<td><form:input path="items[${loop.index}].name" readonly="true" /></td>
					<td><form:input path="items[${loop.index}].price" readonly="true" /></td>
					<td><form:input path="items[${loop.index}].quantity" /></td>
				<tr>
			</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="Purchase" />
			</tr>
			</tbody>
		</table>
	</form:form>
	</div>
</body>
<%@ include file = "FooterJSP.jsp" %>
<c:if test="${isValid}">
	<script>
	  alert('The order quantity you have selected is unavailable. Please try again.');
	</script>
</c:if>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>