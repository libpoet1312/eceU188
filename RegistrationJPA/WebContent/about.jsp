<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URI"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/my.css" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>


	<div id="page-content">
		<div class="container text-center">
			<div class="row justify-content-center">
				<div class="col-md-7">
					<h1 class="font-weight-light mt-4 text-white">Java App using
						Servlets</h1>
					<p class="lead text-white">for login and registration</p>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body" style="text-align: justify; font-size: 120%">
						<p>This is a java Servlet project for department of Electrical
							and Software Enginneering of University of Thessaly.</p>
						<p>The project is implemented in Java programming language
							with the use of Mysql Database to store users. Connection with
							the database is done using Hibernate framework.</p>
						<p></p>
						<p>User passwords are not stored in the database as plain-text
							but salted with Argon.</p>
						<p style="text-align: center">
							<b>Project is served in <a href="https://okeanos.grnet.gr/"
								target="_blank">Okeanos Universe</a></b><br>using an Ubuntu Desktop Virtual Machine.
						</p>
						
						<p style="text-align: center; font-weight: bold;">
							Course Repository on <a href="https://github.com/libpoet1312/eceU188"
								target="_blank">Github</a>
						</p>
						<p style="text-align: center; font-weight: bold;">
							Project page on <a href="https://github.com/libpoet1312/eceU188"
								target="_blank">Github</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>





	<jsp:include page="_footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>