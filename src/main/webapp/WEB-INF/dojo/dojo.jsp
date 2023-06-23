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
<title>Dojos</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>CREATE DOJO</h1>
		<form:form action="/dojos/process/create" method="post" modelAttribute="dojo">
			<div class="form-group">
				<label for="name">Dojo Name:</label>
				<form:input type="text" path="name" class="form-control" />
				<small class="form-text text-danger"> <form:errors
						path="name" />
				</small>
			</div>
			<input type="submit" value="Submit" class="mt-2 btn btn-success" />
		</form:form>
	</div>
</body>
</html>