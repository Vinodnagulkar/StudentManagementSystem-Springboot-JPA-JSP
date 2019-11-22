<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsps/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.myclass {
	color: white;
	padding: 15px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: Yellowgreen">
	<form class="" action="">
		<c:if test="${!empty getAllStudents}">
			<h3 style="color: black">STUDENTS INFORMATION:</h3>
			<hr>
			<table class="table">
				<thead>
					<tr style="color: black">
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Mobile</th>
						<th>Address</th>
						<th>Pincode</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${getAllStudents}" var="stud">
						<tr>
							<td><c:out value="${stud.firstName}" /></td>
							<td><c:out value="${stud.lastName}" /></td>
							<td><c:out value="${stud.mobile}" /></td>
							<td><c:out value="${stud.address}" /></td>
							<td><c:out value="${stud.pincode}" /></td>
							<td><c:out value="${stud.email}" /></td>
							<td><a href="updateStudent?id=${stud.id}"
								class="btn btn-info btn-sm"><span
								class="glyphicon glyphicon-edit"></span> Edit</a></td>
							<td><a href="deleteStudent?id=${stud.id}"
								class="btn btn-info btn-sm"><span
									class="glyphicon glyphicon-remove"></span> Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</form>
</body>
</html>