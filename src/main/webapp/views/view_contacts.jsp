<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script >

$(document).ready(function() {
	$('#table').DataTable({
		"pagingType" : "full_numbers"
	});
});

</script>
</head>
<body style="background-color: skyblue">
	<a href="addContact">+Add Contacts</a>
	<table border="1" id="table">
		<thead>
			<tr>
				<th>SNO</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>NUMBER</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td><a href="editContact?cid=${c.contactId}"><img src="views/edit.png" width="48" height="48" ></a></td>
					<td><a href="deleteContact?cid=${c.contactId}" onclick="if (!confirm('Do you want to delete this Contact?')) { return false }"><img src="views/delete.png" width="48" height="48"></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>