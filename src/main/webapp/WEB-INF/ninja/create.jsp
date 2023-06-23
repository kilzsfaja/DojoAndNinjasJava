<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninjas</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>CREATE NINJA</h1>
		<form:form action="/ninjas/process/create" method="post"
			modelAttribute="ninja">
			<div class="form-group">
				<label for="dojo">Select Dojo</label>
				<form:select path="dojo">
					<c:forEach var="dojo" items="${allDojos }">
					<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
					</c:forEach> 
				</form:select>
			</div>
			<div class="form-group">
				<label for="firstName">First Name:</label>
				<form:input type="text" path="firstName" class="form-control" />
				<small class="form-text text-danger"> <form:errors
						path="firstName" />
				</small>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name:</label>
				<form:input type="text" path="lastName" class="form-control" />
				<small class="form-text text-danger"> <form:errors
						path="lastName" />
				</small>
			</div>
			<div class="form-group">
				<label for="age">Age:</label>
				<form:input type="number" path="age" class="form-control" />
				<small class="form-text text-danger"> <form:errors
						path="age" />
				</small>
			</div>
			<input type="submit" value="Create Ninja" class="mt-2 btn btn-success" />
		</form:form>
	</div>
</body>
</html>