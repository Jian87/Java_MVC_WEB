<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<style>
.error {
	color: red;
	position: fixed;
	margin-left: 30px;
	text-align: left;
}

.inout {
	align: left;
}
</style>
</head>
<body>

	<div align="center" class="container">

		<h2>Love Calculator</h2>
		<hr>
		<br>

		<form:form action="calculate" method="post" modelAttribute="loginInfo">
			<p id="passwordHelpBlock" class="form-text">${dismatch}</p>

			<div class="row mb-3">
				<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" id="inputEmail3" />
					<form:errors path="email" cssClass="error" />
				</div>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<form:input path="password" class="form-control"
						id="inputPassword3" />
					<form:errors path="password" cssClass="error" />
				</div>
			</div>



			<input type="submit" value="Login" class="btn btn-primary">
			<a href='<c:url value="signin-page"/>'>Sign In</a>


		</form:form>



	</div>


</body>
</html>