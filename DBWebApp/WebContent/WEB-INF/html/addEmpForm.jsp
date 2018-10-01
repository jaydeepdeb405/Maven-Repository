<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="employee" action="view">
		<pre>
			Employee ID : <form:input path="id"/><br>
			Name: <form:input path="name"/><br>
			Salary : <form:input path="salary"/><br>
			<input type="submit" value="Add"/><br>
		</pre>
	</form:form>
</body>
</html>