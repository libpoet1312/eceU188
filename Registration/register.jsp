<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URI"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/my.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- HEADER -->
	<jsp:include page="_header.jsp"></jsp:include>


	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-xl-9 mx-auto">
				<div class="card card-signin flex-row my-5">
					<div class="card-img-left d-none d-md-flex">
						<!-- Background image for card set in CSS! -->
					</div>
					<div class="card-body">
						<h5 class="card-title text-center">Register</h5>
						<form class="form-signin" method="POST" action="<%= request.getContextPath() %>/Register">
							<div class="form-label-group">
								<input type="text" name="username" id="inputUserame" class="form-control"
									placeholder="Username" required autofocus> <label
									for="inputUserame">Username</label>
							</div>

							<div class="form-label-group">
								<input type="email" id="inputEmail" name="email" class="form-control"
									placeholder="Email address" required> <label
									for="inputEmail">Email address</label>
							</div>

							<hr>

							<div class="form-label-group">
								<input type="password" id="inputPassword" name="password" class="form-control"
									placeholder="Password" required> <label
									for="inputPassword">Password</label>
							</div>

							<div class="form-label-group">
								<input type="password" id="inputConfirmPassword"
									class="form-control" placeholder="Password" required> <label
									for="inputConfirmPassword">Confirm password</label>
							</div>

							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Register</button>
							<a class="d-block text-center mt-2 small" href="login">Sign In</a>
							<hr class="my-4">
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>