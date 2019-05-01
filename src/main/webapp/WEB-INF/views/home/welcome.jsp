<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<jsp:include page="../menu/app_background.jsp" />
<body>
	<table>
		<tr>
			<td>Registration successful, ${firstname} !!!</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td>
			<a href="loadLogin"><h3>Login</h3></a>
			<td>
			<%-- <a href="${pageContext.request.contextPath}/views/home/login.jsp">Login</a> --%>
			</td>
		</tr>
	</table>
</body>
</html>