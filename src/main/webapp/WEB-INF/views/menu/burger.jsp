
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BURGER</title>
	</head>
	<body>
		<form:form id="burgerForm" modelAttribute="burger" action="addBurgerToCart" method="get">
				<table align="center">
					<tr><td></td><td></td><td></td><td align="right"><h2>$10</h2></td></tr>
					<tr> </tr>
					<tr>
						<td align="center"><img src="${pageContext.request.contextPath}/resources/images/burger.jpg"></td>
					</tr>
					<tr><td align="left"><h3>Chicken Burger</h3></td></tr>
					<tr><td><h4>Bleu Cheese,chicken,lettuce,tomato,pickles,onions,special sauce and catsup top this spectacular burger!!!</h4></td></tr>					
					<tr>
					 <td align="center"><form:button id="addToCart" name="addToCart">ADD TO CART</form:button></td> 
					</tr>
				</table>
		</form:form>
			
	
	</body>
</html>

