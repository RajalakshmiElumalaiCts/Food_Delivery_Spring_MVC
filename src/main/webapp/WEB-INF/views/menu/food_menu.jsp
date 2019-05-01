<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<link rel="stylesheet"
			href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
			integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
			crossorigin="anonymous">
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
		<title>Food Menu</title>
	</head>
	<body background="${pageContext.request.contextPath}/resources/images/home_background.jpg">
		<jsp:include page="../home/user_welcome.jsp" />
		<form:form id="cart_form" modelAttribute="foodMenu" action="openCart" method="get">
			<table>
					<tr>
						<td>
							<form:button id="viewCart" name="viewCart"><i class="fa fa-cart-plus" aria-hidden="true"></i></form:button>
						</td>
					</tr>
					<!-- <table align="center"> -->
						<tr>
							<td style="font-style: italic; color: red;">${emptyCart}</td>
						</tr>
					<!-- </table> -->
				</table>
		</form:form>
	
		<form:form id="food_menu" modelAttribute="foodMenu" action="viewFoodItem" method="get">
			
			<table align="center">
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/burger.jpg" height="250" width="250" ></td>
					<td align="left"><form:button id="burgerView" value="burgerView" name="burgerView">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/cake.jpg" height="250" width="250"></td>
					<td align="left"><form:button id="cakeView" value="cakeView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/cheese-cake.jpg" height="250" width="250"></td>
					<td align="left"><form:button id="cheeseCakeView" value="cheeseCakeView" name="view">View</form:button></td>					
				</tr>
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/chicken.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="chickenView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/choco-cake.png" height="250" width="250"></td>
					<td align="left"><form:button value="chocoCakeView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/combo1.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="combo1View" name="view">View</form:button></td>					
				</tr>
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/combo2.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="combo2View" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/pizza.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="pizzaView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/noodle2.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="noodle2View" name="view">View</form:button></td>					
				</tr>
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/small-cake.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="smallCakeView" name="view">View</form:button></td>
					<td>  <img src="${pageContext.request.contextPath}/resources/images/rice.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="riceView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/vegroll.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="vegrollView" name="view">View</form:button></td>					
				</tr>
				<tr>
					<td><img src="${pageContext.request.contextPath}/resources/images/noodle.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="noodleView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/veggies.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="veggiesView" name="view">View</form:button></td>
					<td><img src="${pageContext.request.contextPath}/resources/images/salad.jpg" height="250" width="250"></td>
					<td align="left"><form:button value="saladView" name="view" >View</form:button></td>					
				</tr>		
				 
			</table>
		</form:form>
	</body>
</html>