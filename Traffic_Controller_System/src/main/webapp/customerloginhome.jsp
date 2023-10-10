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
<title>Login Page</title>
<link rel="stylesheet" href="CSS/customerloginhome.css">
</head>
<body>
	<jsp:include page="customer_navbar.jsp"></jsp:include>
	<div class="wrapper">
		<div class="content">
			<p class="description">A Traffic Controller System is a
				cutting-edge solution that revolutionizes the way individuals and
				businesses approach their daily commutes and transportation needs.
				For customers, it represents a game-changer in navigating the
				challenges of modern traffic. This comprehensive system offers an
				array of benefits, starting with real-time traffic updates that keep
				you in the know about accidents, road closures, construction zones,
				and other potential roadblocks. Armed with this information, you can
				make informed decisions about your routes, minimizing the stress and
				uncertainty often associated with commuting. Additionally, the
				Traffic Controller System's ability to provide optimized routes is a
				game-changer. Whether you're heading to work, a meeting, or a family
				gathering, this system suggests the fastest, most efficient paths,
				helping you reach your destination more quickly and reliably. It's
				like having a personal traffic expert in your pocket, ensuring you
				always take the smartest route. Furthermore, by promoting the use of
				alternative transportation modes such as public transit, carpooling,
				and biking, it contributes to reducing traffic congestion and
				environmental impact, creating a more sustainable and livable
				community for all. In essence, a Traffic Controller System is your
				trusted partner in conquering the challenges of modern urban
				mobility, making your daily commute more convenient, predictable,
				and eco-friendly..</p>
		</div>
		<img
			src="roadworkaheadimage.jpg" alt="Traffic Image">
	</div>


</body>


</html>