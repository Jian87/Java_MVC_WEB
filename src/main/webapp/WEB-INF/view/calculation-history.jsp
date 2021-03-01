<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculation History</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="/LoveCalculatorApp/UrlToJSFile/myapp.js"></script>
</head>
<body>


	<div align="center" class="container">
		<div>
		<a href='<c:url value="logout"/>' class="btn float-right"
			style="float: right">Logout</a>
		</div>
			
		<h2>Love Calculator</h2>

		<hr>
		<br>
		<table class="table table-striped">

			<tr>
				<th>USERNAME</th>
				<th>CRUSHNAME</th>
				<th>DELETE</th>
			</tr>

			<c:forEach items="${historyList}" var="history">

				<tr>
					<td>${history.username}</td>
					<td>${history.crushname}</td>
					<td><a href='<c:url value="deleteCalculationRecord?recordId=${history.id}"/>' onclick="return confirmDelete()">delete</a></td>
				</tr>

			</c:forEach>


		</table>
		
		<br>
		<br>
		
		<a href='<c:url value="calculate"/>'> Go back and try with other
			people</a>

	</div>

</body>
</html>