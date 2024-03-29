<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URI"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/my.css" rel="stylesheet" type="text/css">

</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>


  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
          <c:if test="${errorString != NULL}">
          	<h4 style="color:red;text-align:center"><b><c:out value="${errorString}"/></b> </h4>
          </c:if>
          
          
            <h5 class="card-title text-center">Sign In</h5>
            
            <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/login">
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" name="email" value= "${user.email}" placeholder="email" required autofocus>
                <label for="inputEmail">email</label>
              </div>
              <div class="form-label-group" >
                <input type="password" id="inputPassword" value="${user.password}" name="password" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>


              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1" name="rememberMe">
                <label class="custom-control-label" for="customCheck1">Remember me</label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" value= "Submit">Sign in</button>
              <hr class="my-4">
              <a href="register.jsp" class="btn btn-lg btn-dark btn-block text-uppercase" type="submit" role="button"><i class="fab mr-2"></i> Register</a>
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