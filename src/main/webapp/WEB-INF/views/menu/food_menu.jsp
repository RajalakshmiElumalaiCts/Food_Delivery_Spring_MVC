<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<style>
			.row {
				display: flex;
				flex-wrap: wrap;
				padding: 0 4px;
			}
			/* Create two equal columns that sits next to each other */
			.column {
				flex: 50%;
				padding: 0 4px;
			}
			
			.column img {
				margin-top: 8px;
				vertical-align: middle;
			}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form:form id="loginForm" modelAttribute="login" action="viewFoodItem" method="get">
			<table align="center">
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/burger.jpg"></td>
					<td align="left"><form:button value="burgerView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/cake.jpg"></td>
					<td align="left"><form:button value="cakeView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/cheese-cake.jpg"></td>
					<td align="left"><form:button value="cheeseCakeView" name="view">View</form:button></td>					
				</tr>
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/chicken.jpg"></td>
					<td align="left"><form:button value="chickenView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/choco-cake.png"></td>
					<td align="left"><form:button value="chocoCakeView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/combo1.jpg"></td>
					<td align="left"><form:button value="combo1View" name="view">View</form:button></td>					
				</tr>
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/combo2.jpg"></td>
					<td align="left"><form:button value="combo2View" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/pizza.jpg"></td>
					<td align="left"><form:button value="pizzaView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/noodle2.jpg"></td>
					<td align="left"><form:button value="noodle2View" name="view">View</form:button></td>					
				</tr>
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/small-cake.jpg"></td>
					<td align="left"><form:button value="smallCakeView" name="view">View</form:button></td>
					<td>  <img src="${pageContext.request.contextPath}/resources/images/rice.jpg"></td>
					<td align="left"><form:button value="riceView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/vegroll.jpg"></td>
					<td align="left"><form:button value="vegrollView" name="view">View</form:button></td>					
				</tr>
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/noodle.jpg"></td>
					<td align="left"><form:button value="noodleView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/veggies.jpg"></td>
					<td align="left"><form:button value="veggiesView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/salad.jpg"></td>
					<td align="left"><form:button value="saladView" name="view" >View</form:button></td>					
				</tr>		
				 
			</table>
		</form:form>
	</body>
</html>