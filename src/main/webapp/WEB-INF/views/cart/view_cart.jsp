<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<jsp:include page="../menu/app_background.jsp" />
	<body>
		<form:form id="view_cart_form" modelAttribute="foodCart" action="placeOrder" method="get">
		 <table align="center">
		  <tr></tr>
		  <tr></tr>
		  <tr></tr>
		  <tr></tr>
			 <tr>
			 	<td><h2>Food</h2></td><td></td><td></td>
			 	<td><h2>Price</h2></td><td></td><td></td>
			 	<td><h2>Quantity</h2></td>
			 </tr>
			 <tr></tr>
			 <c:set var="totalPrice" value="${0}" />
			 <c:forEach var="selectedFood" items="${foodCart.selectedFood}">		     
					<tr>
						<td>${selectedFood.name}</td><td></td><td></td>
						<td>$ ${selectedFood.price}</td><td></td><td></td>
						<c:set var="totalPrice" value="${totalPrice + selectedFood.price}" />						
						<td>
							    <input id="prodQuantity" type="text" name="quantity" value="1" size="2" />
						</td>
		      		 <tr>		       
		   	</c:forEach> 
		   	<tr>
			 	<td></td><td></td><td></td>
			 	<td><h3>Total</h3></td><td></td><td></td>
			 	<td><h3>${totalPrice}</h3></td>
			 </tr>
		   	</table>
				<table align="center">
					<tr>
						<td></td>
						<td align="left"><form:button id="placeOrder" name="placeOrder">Place Order</form:button></td>
					</tr>
	
				</table>
		</form:form>
	</body>
</html>