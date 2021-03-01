<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate Page</title>

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

	<div align="center">
	
		<h2>Love Calculator</h2>
		
		<form:form action="logout" method="get">
			<input type="submit" value="Logout"/>
		</form:form>
		
		<hr>
		<br>
		
		<form:form action="calculate-result" method="get" modelAttribute="calculationInfo">
			
			<label>User Name: </label>
			<form:input path="username"/>
			<form:errors path="username" cssClass="error"/>
			<br>
			<br>
			
			<label>Crush Name: </label>
			<form:input path="crushname"/>
			<form:errors path="crushname" cssClass="error"/>
			<br>
			<br>
			
			<input type="submit" value="Calculate">
		
		</form:form>
	
	</div>
</body>
</html>