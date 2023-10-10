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
<title>Admin Navbar</title>
<link rel="stylesheet" href="CSS/index_style4.css">

<link href="https://fonts.googleapis.com/css?family=QuickSand:500" rel="stylesheet">
</head>
<body>
<header>
		<div class="wrapper">
			<nav>
				<div class="logo">
					<a href="adminloginhome.jsp">Traffic Controller System</a>
				</div>
				<ul class="nav-links">
					<li><a href="adminloginhome.jsp">Home</a></li>
					<li><a href="admindashboard.jsp">Dashboard</a></li>
					<li><a href="adminprofile.jsp">Profile</a></li>
					<li><a href="./admin?mode=adminlogout">Logout</a></li>
					</ul>
			</nav>
		</div>
	</header>

</body>
</html>