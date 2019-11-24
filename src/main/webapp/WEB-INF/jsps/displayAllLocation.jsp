<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>All Locations</h2>

<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Code</th>
			<th>Name</th>
			<th>Type</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${locations}" var="loc">
			<tr>
				<td>${loc.id}</td>
				<td>${loc.code}</td>
				<td>${loc.name}</td>
				<td>${loc.type}</td>
				<td> <a href="editLocation?id=${loc.id}">Edit</a> </td>
				<td> <a href="deleteLocation?id=${loc.id}">Delete</a> </td>
			</tr>
		</c:forEach>
	
		<tr>
		</tr>
	</tbody>
	
</table>

<br/>
<a href="showCreate">Add Record</a>

</body>
</html>