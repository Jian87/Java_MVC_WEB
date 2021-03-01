<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

.container{
	width:50%;
}

</style>
</head>
<body>

	<div class="container">

		<h2>Love Calculator</h2>
		<hr>
		<br>

		<form:form action="signin-success" method="post"
			modelAttribute="signinInfo" class="row g-3">
			
			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">First Name</label> 
				<form:input path="firstName" class="form-control" id="inputEmail4" />
				<form:errors path="firstName" cssClass="error" />
			</div>
			<div class="col-md-6">
				<label for="inputPassword4" class="form-label">Last Name</label> 
				<form:input path="lastName" class="form-control" id="inputPassword4" />
				<form:errors path="lastName" cssClass="error" />
			</div>
			
			<br>
			<br>
		
			<div class="col-12">
				<label for="inputAddress" class="form-label">Email</label> 
				<form:input path="email" class="form-control" id="inputAddress"/>
				<form:errors path="email" cssClass="error" />
			</div>
			<br>
			<br>
			
			<div class="col-12">
				<label for="inputAddress2" class="form-label">Password</label> 
				<form:input path="password" class="form-control" id="inputAddress2" />
				<form:errors path="password" cssClass="error" />
			</div>
			
			<br>
			<br>
						
			<fieldset class="row mb-3" style="margin-top:20px;">
			    <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
			    <form:errors path="gender" cssClass="error" />
			    <div class="col-sm-10">
			      <div class="form-check">
			        <form:radiobutton class="form-check-input" path="gender" name="gridRadios" id="gridRadios1" value="male" />
			        <label class="form-check-label" for="gridRadios1">
			          Male
			        </label>
			      </div>
			      <div class="form-check">
			        <form:radiobutton class="form-check-input" path="gender" name="gridRadios" id="gridRadios2" value="female" />
			        <label class="form-check-label" for="gridRadios2">
			          Female
			        </label>
			      </div>
			      <div class="form-check disabled">
			        <form:radiobutton class="form-check-input" path="gender" name="gridRadios" id="gridRadios3" value="other" />
			        <label class="form-check-label" for="gridRadios3">
			          Other
			        </label>
			      </div>
			    </div>
			  </fieldset>
			
			
			<br>
			<br>
			
			<div class="col-12">
				<div class="form-check">
					<form:checkbox class="form-check-input" path="termAndCondition" id="gridCheck" />
					<label class="form-check-label" for="gridCheck"> Please agree to use this app for fun</label>
					<form:errors path="termAndCondition" cssClass="error" />
				</div>
			</div>
			<br>
			<br>

			<input type="submit" value="Login" class="btn btn-primary">

		</form:form>
	</div>

</body>
</html>