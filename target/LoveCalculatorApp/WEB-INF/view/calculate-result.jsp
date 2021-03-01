<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate Result Page</title>
</head>
<body>

	<h2 align="center">Love Calculator</h2>
	<form:form action="logout" method="get">
			<input type="submit" value="Logout"/>
	</form:form>
	<hr>

	<div>


		<h3>The calculate Result</h3>
		<p>${calculationInfo.username } and ${calculationInfo.crushname } are </p> 
		<p>${calculationResult}</p>
		
		<br><br>
		
		<a href='<c:url value="email-process"/>'> Send the result to email </a><br>
		<a href='<c:url value="calculate" />'>Try with other people</a><br>
		<a href='<c:url value="calculate-history"/>'>Check the calculate history</a><br>

	</div>

</body>
</html>