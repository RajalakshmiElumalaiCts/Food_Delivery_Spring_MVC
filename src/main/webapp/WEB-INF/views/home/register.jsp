<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>

<jsp:include page="../menu/app_background.jsp" />

<body>
	<form:form id="regForm" modelAttribute="user" action="register"	method="post">

		<table align="center">
			<tr>
				<td><form:label path="username"><h3>Username</h3></form:label></td>
				<td><form:input path="username" name="username" id="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password"><h3>Password</h3></form:label></td>
				<td><form:password path="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname"><h3>FirstName</h3></form:label></td>
				<td><form:input path="firstname" name="firstname" id="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname"><h3>LastName</h3></form:label></td>
				<td><form:input path="lastname" name="lastname" id="lastname" /></td>
			</tr>
			<tr>
				<td><form:label path="email"><h3>Email</h3></form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="address"><h3>Address</h3></form:label></td>
				<td><form:input path="address" name="address" id="address" /></td>
			</tr>
			<tr>
				<td><form:label path="phone"><h3>Phone</h3></form:label></td>
				<td><form:input path="phone" name="phone" id="phone" /></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="register" name="register"><h3>Register</h3></form:button></td>
			</tr>
			<tr></tr>
			
		</table>
	</form:form>

</body>
</html>