<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate Result Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		
		<div>
		<a href='<c:url value="logout"/>' class="btn float-right"
			style="float: right">Logout</a>
		</div>
		
		<h2 align="center">Love Calculator</h2>
		<hr>

		<div>


			<h3>The calculate Result</h3>
			<p>${calculationInfo.username }and ${calculationInfo.crushname }
				are</p>
			<p>${calculationResult}</p>

			<br>
			<br> <a href='<c:url value="email-process"/>'> Send the
				result to email </a><br> <a href='<c:url value="calculate" />'>Try
				with other people</a><br> <a
				href='<c:url value="calculate-history"/>'>Check the calculate
				history</a><br>

		</div>

	</div>

</body>
</html>