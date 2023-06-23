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
<title>Dojo and Ninjas</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="text-center my-5">
	<h1>HOME</h1>
	<a href="/dojos/create" class="btn btn-info">Create Dojo</a>
	<a href="/ninjas/create" class="btn btn-secondary">Create Ninja</a>
</div>
	<div class="mt-5">
	<h3>All Ninjas</h3>
	<table class="table">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Dojo</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${allNinjas}" var="ninja">
			<tr>
				<td>${ninja.firstName}</td>
				<td>${ninja.lastName}</td>
				<td>${ninja.dojo.name}</td>
				<td>${ninja.age}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="mt-5">
	<h3>All Dojos</h3>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Number of Ninjas</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${allDojos}" var="dojo">
			<tr>
				<td>${dojo.id}</td>
				<td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
				<td>${dojo.ninjas.size()}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>
</body>
</html>