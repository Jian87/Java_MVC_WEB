<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email Process Page</title>

<style>
	
	.error{
		color:red;
		position:fixed;
		margin-left:30px;
		text-align:left;
	}

</style>

</head>
<body>

	<h2 align="center">Love Calculator</h2>
	<form:form action="logout" method="get">
			<input type="submit" value="Logout" />
		</form:form>
	<hr>

	<div>
		
		<h3>Send The Calculation Result To Email</h3>
		<p>${calculationInfo.username } and ${calculationInfo.crushname } are </p> 
		<p>${calculationResult}</p>
		
		<br>

		<form:form action="email-send" method="post" modelAttribute="emailInfo">

			<label>Enter the email: </label>
			<form:input path="emailId" />
			<input type="submit" value="Send">
			<form:errors path="emailId" cssClass="error"/>
			
		</form:form>
		
		<br>
		
		<a href='<c:url value="calculate" />'>Go Back Try With Other people</a>
	</div>

</body>
</html>