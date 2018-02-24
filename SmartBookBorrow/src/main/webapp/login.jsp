<%@page import="com.MavenProject.SmartBookBorrow.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Website template by freewebsitetemplates.com -->
<html>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="user-scalable=0, width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Smart Book Borrow</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/mobile.css">
<script type='text/javascript' src='js/mobile.js'></script>
</head>
<body>
	<div id="header">
		<h1>
			<a href="index.jsp">Smart Book Borrow</a>
		</h1>
		<ul id="navigation">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="login.jsp">Login</a></li>
		</ul>
	</div>
	<div id="body">
		<div
			style="margin: 1cm 1cm; color: black; font-style: Sans-serif; font-size: 18px">

			<h2>Login Here</h2>
			<form action="">
				<table>
					<tr>
						<th>Email:</th>
						<td><input type="email" placeholder="Enter Username"
							name="email" required></td>
					</tr>
					<tr>
						<th>Password:</th>
						<td><input type="password" placeholder="Enter Password"
							name="password" required></td>
					</tr>
					<tr>
						<th></th>
						<th><input type="submit" value="login" name="login"></th>
					</tr>
				</table>
			</form>
		</div>
		<%
			LoginDAO dao = LoginDAO.getInstance();
			if (request.getParameter("login") != null) {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				int a = dao.adminLogin(email, password);
				System.out.println(a);
				if (a==1) {
		%>
		<script type="text/javascript">
			window.location.href = "admin_home.jsp";
		</script>
		<%
			} else {
		%>
		<script type="text/javascript">
			alert("invlid email/password!!!!!!");
			window.location.href = "login.jsp";
		</script>
		<%
			}
			}
		%>

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