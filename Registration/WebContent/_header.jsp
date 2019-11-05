<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- LOGGED IN USER HEADER -->
<c:if test="${not empty user}">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"> <img
				src="images/UTH-logo-greek.jpg" class="logo_UTH" alt="">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="index.jsp">Home<span class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>

					<li class="nav-item " ><a class="nav-link btn btn-outline-success" href="Logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
</c:if>


<!-- NOT LOGGED IN USER HEADER -->
<c:if test="${empty user}">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"> <img
				src="images/UTH-logo-greek.jpg" class="logo_UTH" alt="">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="index.jsp">Home<span class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
					<li class="nav-item"><a class="nav-link active nav-link btn btn-outline-success" href="login.jsp">Login</a></li>
					<li class="nav-item"><a class="nav-link active nav-link btn btn-outline-success" href="register.jsp">Register</a></li>
				</ul>
			</div>
		</div>
	</nav>
</c:if>


