<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if (session.getAttribute("id") == null) {
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Navbar</title>
<link rel="stylesheet" href="CSS/customer_navbar.css">
<link href="https://fonts.googleapis.com/css?family=QuickSand:500" rel="stylesheet">
</head>
<body>
<header>
		<div class="wrapper">
			<nav>
				<div class="logo">
					<a href="customerloginhome.jsp">Traffic Controller System</a>
				</div>
				<ul class="nav-links">
					<li><a href="customerloginhome.jsp">Home</a></li>
					<li><a href="customerviewstatus.jsp">View Status</a></li>
					<li><a href="customerprofile.jsp">Profile</a></li>
					<li><a href="./customer?mode=customerlogout">Logout</a></li>
					</ul>
			</nav>
		</div>
	</header>

</body>
</html>