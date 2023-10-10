<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.service.impl.AuthorServiceImp"%>
<%@page import="com.nagarro.dto.Author"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<%@ include file="components/commons.jsp"%>
</head>
<body>
	<%
		String uname = (String) session.getAttribute("username");
		if (uname == null) {
			response.sendRedirect("LogIn");
		}
	%>
	<nav class="navbar">
			<div class="container-fluid justify-content-center">
                <h2 style="text-decoration:underline">Library Management System</h2>
            </div >
            <div class="container-fluid justify-content-end" style="margin-top:-35px;">
            	<span class="m-2"><b>Hi <%=uname %></b></span> 
                <span><a href="Logout"><button class="btn btn-outline-dark">Logout</button></a></span>
           </div>
    </nav>
    <hr>
    <div class="row mt-5">
		<div class="col-11"
			style="text-align: center; margin: 0 auto;">
			<h2>Add book details</h2>
		</div>
	</div>
	<div class="container-fluid col-md-5 p-3" style="border:2px solid black; border-radius:14px">
	<form action="add" method="post">
		<div class="mb-3">
			<label for="bookcode" class="form-label">Book Code</label> 
			<input type="text" class="form-control" name="bookcode"
				id="bookcode" required>
		</div>
		<div class="mb-3">
			<label for="bookname" class="form-label">Book Name</label>
			<input type="text" class="form-control" name="bookname"
				id="bookname" required>
		</div>
		<div class="mb-3">
			<label for="author" class="col-12 col-md-2 form-label">Author</label> 
			  <select class="col-12 col-md-5 form-control" name="author" id="author" required>
				<%
					Author[] listAuthor = (Author[]) new AuthorServiceImp().getAuthors();
					for (Author author : listAuthor) {
				%>
				<option><%=author.getName()%></option>
				<%
					}
				%>
				<option value="JK Rowling">JK Rowling</option>
				<option value="Jaun Elia">Jaun Elia</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="added" class="form-label">Added On</label> 
			<input id="added" readonly="readonly" name="added" class="form-control"
				value=<%long millis = System.currentTimeMillis();
				String date = new java.sql.Date(millis) + "";%>
				<%=date%> />
		</div>
		<input type="submit" class="btn btn-secondary" value="Submit" />
		<input type="reset" class=" mx-4 btn btn-warning" value="Cancel" />
	</form>
	</div>
</body>
</html>