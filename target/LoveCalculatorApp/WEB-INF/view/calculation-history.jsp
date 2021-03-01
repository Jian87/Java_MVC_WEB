<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculation History</title>
<script src="/LoveCalculatorApp/UrlToJSFile/myapp.js"></script>
</head>
<body>

	<div align="center">

		<h2>Love Calculator</h2>

		<form:form action="logout" method="get">
			<input type="submit" value="Logout" />
		</form:form>

		<hr>
		<br>
		<table border="1">

			<tr>
				<th>USERNAME</th>
				<th>CRUSHNAME</th>
			</tr>

			<c:forEach items="${historyList}" var="history">

				<tr>
					<td>${history.username}</td>
					<td>${history.crushname}</td>
					<td><a href='<c:url value="deleteCalculationRecord?recordId=${history.id}"/>' onclick="return confirmDelete()">delete</a></td>
				</tr>

			</c:forEach>


		</table>


	</div>

</body>
</html>