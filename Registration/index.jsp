<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URI"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



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
	<c:if test="${not empty user}">
		<div class="container">
			<div class="row">
				<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h2 class="card-title text-center">
								Welcome
								<br>
								<b><c:out value="${sessionScope.user.getUserName()}"/></b>
								
							</h2>
							
						</div>
					</div>
				</div>
			</div>
		</div>

	</c:if>



	<jsp:include page="_footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>