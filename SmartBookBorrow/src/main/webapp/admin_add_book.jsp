<%@page import="com.MavenProject.SmartBookBorrow.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="user-scalable=0, width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Smart Book Borrow</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/mobile.css">
<script type='text/javascript' src='js/mobile.js'></script>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}
</style>
</head>
<body>
	<div id="header">
		<h1>
			<a href="index.jsp">Smart Book Borrow</a>
		</h1>
		<ul id="navigation">
			<li><a href="admin_home.jsp">Home</a></li>
			<li><a href="admin_view_books.jsp">View Books</a></li>
			<li><a href="admin_add_book.jsp">Add Books</a></li>
			<li><a href="index.jsp">Logout</a></li>
		</ul>
	</div>
	<div id="body">
		<div style="margin: 2cm 4cm; font-style: Sans-serif; font-size: 18px">
			<h2>Add Book</h2>
			<form method="post" action="UploadBook" enctype="multipart/form-data">
				<table>
					<tr>
						<td>Book Name:</td>
						<td><input type="text" name="bookName" /></td>
					</tr>
					<tr>
						<td>Book Description:</td>
						<td><input type="text" name="bookDesc" /></td>
					</tr>
					<tr>
						<td>Book Author:</td>
						<td><input type="text" name="bookAuthor" /></td>
					</tr>
					<tr>
						<td>Book Image:</td>
						<td><input type="file" name="bookImage" accept="images/*"></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="checkbox" name="canBuy" value="1" checked/> can
							buy <input type="checkbox" name="canBorrow" value="1"  />can
							Borrow</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="upload" value="upload" /></td>
					</tr>
				</table>
			</form>
		</div>

		<%
			if (request.getParameter("s") != null) {
				if (request.getParameter("s").equals("success")) {
					System.out.println("successfully file uploaded!!");
		%>
		<script type="text/javascript">
			alert("successfully file uploaded!!");
			window.location.href = "admin_add_book.jsp";
		</script>
		<%
			} else if (request.getParameter("s").equals("failure")) {
					System.out.println("file uploadin failed!!");
		%>
		<script type="text/javascript">
			alert("file uploadin failed!!");
			window.location.href = "admin_add_book.jsp";
		</script>
		<%
			} else if (request.getParameter("s").equals("error")) {
					System.out.println("error in uploading a file!!");
		%>
		<script type="text/javascript">
			alert("error in uploading a file!!");
			window.location.href = "admin_add_book.jsp";
		</script>
		<%
			} else if (request.getParameter("s").equals("invalidfile")) {
					System.out.println("Invalid file !!");
		%>
		<script type="text/javascript">
			alert("Invalid file !!");
			window.location.href = "admin_add_book.jsp";
		</script>
		<%
			} else {
					System.out.println("Something else went Wrong!!!!");
		%>
		<script type="text/javascript">
			alert("Something else went Wrong!!!!");
			window.location.href = "admin_add_book.jsp";
		</script>
		<%
			}
			}
		%>
	</div>
	</div>
	<div id="footer">
		<div>
			<span>Mysuru | 987654321</span>
			<p>&copy; 2023 by Belle &amp; Carrie Rehabilitation Yoga. All
				rights reserved.</p>
		</div>
		<div id="connect">
			<a href="https://freewebsitetemplates.com/go/facebook/" id="facebook"
				target="_blank">Facebook</a> <a
				href="https://freewebsitetemplates.com/go/twitter/" id="twitter"
				target="_blank">Twitter</a> <a
				href="https://freewebsitetemplates.com/go/googleplus/"
				id="googleplus" target="_blank">Google&#43;</a> <a
				href="https://freewebsitetemplates.com/go/pinterest/" id="pinterest"
				target="_blank">Pinterest</a>
		</div>
	</div>
</body>
</html>