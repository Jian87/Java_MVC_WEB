<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email Send Result</title>
</head>
<body>

	<h2 align="center">Love Calculator</h2>
	<form:form action="logout" method="get">
		<input type="submit" value="Logout" />
	</form:form>
	<hr>

	<div>

		Your Email has been sent successfully. <br> <a
			href='<c:url value="calculate"/>'> Go back and try with other
			people</a>
	</div>
</body>
</html>