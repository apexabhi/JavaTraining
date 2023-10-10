<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library-HomePage</title>
<%@ include file="components/commons.jsp"%>
</head>
<body style="background-color:#f1faee">
	<%
		String uname = (String) session.getAttribute("username");
		if (uname == null) {
			response.sendRedirect("LogIn");
		}
	%>
	<%
		//To show appropriate message after book operations
		String message = (String) session.getAttribute("msg1");
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
		session.removeAttribute("msg1");
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
    <div class="row my-5">
		<div class="col-11"
			style="text-align: center; margin: 0 auto;">
			<h2>Book Listing</h2>
		</div>
		<div class="col-1">
			<a href="addBook.jsp"><button type="submit"
					class="btn btn-primary btn-sm ">Add a Book</button></a>
		</div>
	</div>
	
	<table class="table table-striped table-bordered mt-5" style="border:2px solid black;">
				<tr>
					<th>Book Code</th>
					<th>Book Name</th>
					<th>Author</th>
					<th>Date Added</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="p" items="${books}">
					<tr>
						<td>${p.getBookCode() }</td>
						<td>${p.getBookName()}</td>
						<td>${p.getAuthor()}</td>
						<td>${p.getDate()}</td>
						<td><a href="edit.jsp?id=${p.getBookCode()}&name=${p.getBookName()}&author=${p.getAuthor()}"><button
									type="button" class="btn btn-outline-secondary">Edit</button></a> <a
							href="delete?code=${p.getBookCode()}"><button
									type="button" class="btn btn-outline-danger">Delete</button></a>
					</tr>
				</c:forEach>
		</table>
</body>
</html>