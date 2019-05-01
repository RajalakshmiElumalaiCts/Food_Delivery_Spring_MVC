<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choco cake</title>
</head>

<jsp:include page="../menu/app_background.jsp" />

<body>
		<form:form id="chocoCakeForm" modelAttribute="chocoCake" action="addChocoCakeToCart" method="get">
				<table align="center">
					<tr><td></td><td></td><td></td><td align="right"><h2>$5</h2></td></tr>
					<tr> </tr>
					<tr>
						<td align="center"><img src="${pageContext.request.contextPath}/resources/images/choco-cake.png"></td>
					</tr>
					<tr><td align="left"><h3>Chocolate Cake</h3></td></tr>
					<tr><td><h4>Chocolate cake is a cake flavored with melted chocolate or cocoa powder or both !!!</h4></td></tr>					
					<tr>
					 <td align="center"><form:button id="addToCart" name="addToCart">ADD TO CART</form:button></td> 
					</tr>
				</table>
		</form:form>
			
	
	</body>
</html>