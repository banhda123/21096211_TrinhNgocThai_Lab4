<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Users</title>
<style type="text/css">
	th{
		padding: 20px
	}
	
	td{
		padding: 10px
	}
	

</style>
</head>
<body>
	<h2>List Of Users</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Birthday</th>
			<th>Gender</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.birthday}</td>
				<td>${user.gender}</td>
			</tr>
		</c:forEach>
		
	
	</table>
</body>
</html>