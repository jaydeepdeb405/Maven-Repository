<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Employee ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	
		<c:forEach var="employee" items="${list}">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.salary}</td>
				<td><a href="edit/${employee.id}">Edit</a></td>
				<td><a href="delete/${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>