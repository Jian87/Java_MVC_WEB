<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		
		<form:form action="signin-success" method="post" modelAttribute="signinInfo">
			
			<label>First Name: </label>
			<form:input path="firstName"/>
			<form:errors path="firstName" cssClass="error"/>
			
			<label>Last Name: </label>
			<form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
			<br>
			<br>
			
			<label>Email: </label>
			<form:input path="email"/>
			<form:errors path="email" cssClass="error"/>
			<br>
			<br>
			
			<label>Password: </label>
			<form:input path="password"/>
			<form:errors path="password" cssClass="error"/>
			<br>
			<br>
			
			<label>Gender: </label>
			<form:radiobutton path="gender" value="male" /><label for="g_m">Male</label>
			<form:radiobutton path="gender" value="female" /><label for="g_f">Female</label>
			<form:errors path="gender" cssClass="error"/>
			<br>
			<br>
			
			<form:checkbox path="termAndCondition"/>
			<label>Please agree to use this app for fun</label>
			<form:errors path="termAndCondition" cssClass="error"/>
			<br>
			<br>
			
			<input type="submit" value="Login">
		
		</form:form>
	
	</div>

</body>
</html>