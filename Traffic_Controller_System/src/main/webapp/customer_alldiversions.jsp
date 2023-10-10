<%@ page language="java"
	import="com.src.dao.DaoService,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement,
	com.src.interfacess.CustomerServiceInterface,com.src.services.CustomerService,java.util.ArrayList,com.src.model.Diversions "
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>Diversion List</title>
<link rel="stylesheet" href="CSS/customer_alldisplays.css">
</head>
<body>
	<jsp:include page="customer_navbar.jsp"></jsp:include>
	<table border="2">
		<tr>
			<td>Diversion Id</td>
			<td>Diversion Route Type</td>
			<td>Diversion Starting Place</td>
			<td>Diversion End Place</td>
			<td>Diversion Start Date</td>
			<td>Diversion End Date</td>
			<td>Diversion Kms</td>
			<td>Diversion Status</td>
		</tr>

		<%
		CustomerServiceInterface csi = new CustomerService();
		ArrayList<Diversions> div = (ArrayList<Diversions>) csi.customer_allDiversions();

		for (Diversions d : div) {
		%>
		<tr>
			<td><%=d.getDivid()%></td>
			<td><%=d.getDivroutetype()%></td>
			<td><%=d.getDivstart()%></td>
			<td><%=d.getDivend()%></td>
			<td><%=d.getDivstartdate()%></td>
			<td><%=d.getDivenddate()%></td>
			<td><%=d.getDivkms()%></td>
			<td><%=d.getDivstatus()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
