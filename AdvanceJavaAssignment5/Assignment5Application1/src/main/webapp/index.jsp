<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management System</title>
<%@ include file="components/commons.jsp"%>
</head>
<body style="background-color:#caf0f8">
	<%
		String uname = (String) session.getAttribute("username");
		if (uname != null) {
			response.sendRedirect("show");
		}
	%>
	<%
		//To show appropriate message after login
		String message = (String) session.getAttribute("msg");
		if (message != null) {
	%>
	<div class="alert alert-info alert-dismissible fade show"
		role="alert">
		<%=message%>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true"></span>
		</button>
	</div>
	<%
		session.removeAttribute("msg");
		}
	%>
	<!-- Login form -->
	<div class="container-fluid col-md-4 p-3" style="border:2px solid black; margin-top:12%;background-color:#0096c7">
	<h4 class="text-white">Login if existing user</h4>
	<form action="LogIn" method="post">
		<div class="mb-3">
			<label for="userid" class="form-label text-white">UserId</label> 
			<input type="text" class="form-control" name="userid"
				id="userid" minlength="5" maxlength="50">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label text-white">Password</label>
			<input type="password" class="form-control" name="pwd"
				id="pwd" minlength="5" maxlength="50">
		</div>
		<input type="submit" class="btn btn-secondary" value="LogIn" />
		<a href="register.jsp" class="mx-4 text-white">Create New User?</a>
	</form>
	</div>

</body>
</html>
