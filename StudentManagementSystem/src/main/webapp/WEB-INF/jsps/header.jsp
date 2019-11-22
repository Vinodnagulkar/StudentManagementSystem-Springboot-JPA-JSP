<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
.myclass {
	background-color: Cornflowerblue;
	color: white;
	padding: 12px;
}
.dropbtn {
  color: white;
  padding: 16px;
  font-size: 15px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: Cornflowerblue;
  min-width: 113px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: white;} 
</style>
</head>

<body>
	<form class="myclass">
		<div class="container register">
			<div class="row">
				<div class="col-md-1" align="left">
					<a href="home" style="font-size: 22px"><i style="color: black"
						class="fa fa-home"></i></a>

				</div>
				<b>
					<div class="col-md-1">
						<a href="/loginOpener" style="color: black">LOGIN</a>
					</div>
					<div class="col-md-2">
						<a href="/registerOpener" style="color: black">REGISTER</a>
					</div>
					<div class="col-md-2">
						<a href="/viewStudent" style="color: black">VIEW STUDENTS</a>
					</div>

					<div class="col-md-2">
						<div class="dropdown">
							<a class="dropbtn" href="#" style="color: black">COURCES</a>
							<div class="dropdown-content">
							
								<a href="/java">JAVA</a> <a href="/angular">Angular</a> 
								<a href="https://www.google.com">Link
									3</a>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<a href="/aboutus" style="color: black">ABOUT US</a>
					</div>
					<div class="col-md-2">
						<a href="/contactus" style="color: black">CONTACT US</a>
					</div>
				</b>
			</div>
		</div>
	</form>
</body>
</html>