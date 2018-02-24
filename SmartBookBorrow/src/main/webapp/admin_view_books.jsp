<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.util.Base64"%>
<%@page import="com.MavenProject.SmartBookBorrow.model.Book"%>
<%@page import="java.util.List"%>
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
</head>
<style>
table, th, td {
    border: 1px solid black;
   border-collapse: collapse;

}
th, td {
    padding: 5px;
}
</style>
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
		<div
			style="margin: 1cm 2cm; font-style: Sans-serif; font-size: 18px">
			Books List
			<br>
			<br>
			<%
			BookDAO dao = BookDAO.getInstance();
			List<Book> list = dao.getAllBooks();
			if (!list.isEmpty()) {
		%>
			<table border=1>
				<tr>
					<td>Book Id</td>
					<td>Book Name</td>
					<td>Book Description</td>
					<td>Book Author</td>
					<td>Book Image </td>
				</tr>
				<%
					for (Book book : list) {
				%>
				<tr>	
					<td><%=book.getBookId()%></td>
					<td><%=book.getBookName()%></td>
					<td><%=book.getBookDesc()%></td>
					<td><%=book.getBookAuthor()%></td>
					<td><img src="data:image/;base64, <%=new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get(book.getBookImagePath())))) %>" alt="img" height="70" width="120"></img></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
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