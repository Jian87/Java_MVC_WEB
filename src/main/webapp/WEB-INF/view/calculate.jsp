<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate Page</title>
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
</style>

</head>
<body>

	<div align="center" class="container">
		<a href='<c:url value="logout"/>' class="btn float-right"
			style="float: right">Logout</a>
		<h2>Love Calculator</h2>
		<hr>
		<br>

		<form:form action="calculate-result" method="get"
			modelAttribute="calculationInfo">

			<div class="row mb-3">
				<label for="inputEmail3" class="col-sm-2 col-form-label">User
					Name: </label>
				<div class="col-sm-10">
					<form:input path="username" class="form-control" id="inputEmail3" />
					<form:errors path="username" cssClass="error" />
				</div>
			</div>

			<br>
			<br>

			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-2 col-form-label">Crush
					Name: </label>
				<div class="col-sm-10">
					<form:input path="crushname" class="form-control"
						id="inputPassword3" />
					<form:errors path="crushname" cssClass="error" />
				</div>
			</div>

			<br>
			<br>

			<input type="submit" value="Calculate" class="btn btn-primary">


		</form:form>

	</div>
</body>
</html>