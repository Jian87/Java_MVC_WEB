<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
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
		<hr>
		<br>
		
		
		
		<form:form action="calculate" method="post" modelAttribute="loginInfo">
			<p>${dismatch}</p>
			<label>Email: </label>
			<form:input path="email"/>
			<form:errors path="email" cssClass="error"/>
			<br>
			<br>
			
			<label>Password: </label>
			<form:input path="password" />
			<form:errors path="password" cssClass="error"/>
			<br>
			<br>
			
			<input type="submit" value="Login">
			
			
		
		</form:form>
		
		<form:form action="signin-page" method="post">
				<input type="submit" value="Sign In" />
			</form:form>
	
	</div>
	

</body>
</html>