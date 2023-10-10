<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management System</title>
<%@ include file="components/commons.jsp"%>
</head>
<body style="background-color:#caf0f8">
	<!-- Create new user form -->
	<div class="container-fluid col-md-4 p-3"style="border:2px solid black; margin-top:12%;background-color:#0096c7">
	<h4 class="text-white">Register to create new user</h4>
	<form action="SignUp" method="post">
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
		<input type="submit" class="btn btn-secondary" value="Register" />
		<a href="index.jsp" class="mx-4 text-white">Existing User? Login Here</a>
	</form>
	</div>


</body>
</html>

