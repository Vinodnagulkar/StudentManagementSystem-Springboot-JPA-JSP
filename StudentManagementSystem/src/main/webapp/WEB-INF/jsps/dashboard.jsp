<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>

</style>
</head>
<body style="background-color: Yellowgreen">
<c:import url="/WEB-INF/jsps/header.jsp" />
	<form class=""><div align="right"><b><a href="/home" style="color: black">LOGOUT</a></b></div>
	<div class="container register">
	
		<div class="row">
			<div class="col-md-6">
			
				<h3 style="color: BLUE">My Dashboard</h3>
				<div class="col-md-6" align="right">
					

				</div>
				<h2 style="color: blue">
					Welcome to Yash Technologies
					<c:out value="${studlogininfo.firstName}!" />
				
				</h2>
			</div>
		</div>
	</div>
</form>
</body>
</html>