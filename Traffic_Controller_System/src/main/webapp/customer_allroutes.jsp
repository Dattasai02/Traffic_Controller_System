<%@ page language="java" 
import="com.src.dao.DaoService,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement,
	com.src.interfacess.CustomerServiceInterface,com.src.services.CustomerService,java.util.ArrayList,com.src.model.Routes "
contentType="text/html; charset=ISO-8859-1"
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
<title>Route List</title>
<link rel="stylesheet" href="CSS/customer_alldisplays.css">
</head>
<body>
<jsp:include page="customer_navbar.jsp"></jsp:include>
<table border="2">
    <tr>
        <td>Route Id</td>
        <td>Route Type</td>
        <td>Route Allowed Vehicle</td>
        <td>Route Start Place</td>
        <td>Route End Place</td>
        <td>Route Kms</td>
        <td>Route Status</td>
    </tr>

    <%
    CustomerServiceInterface csi = new CustomerService();
    ArrayList<Routes> routes = (ArrayList<Routes>) csi.customer_allRoutes();

    for (Routes r : routes) {
    %>
    <tr>
        <td><%=r.getRouteid()%></td>
        <td><%=r.getRoutetype()%></td>
        <td><%=r.getRoutevehicle()%></td>
        <td><%=r.getRoutestart()%></td>
        <td><%=r.getRouteend()%></td>
        <td><%=r.getRoutekms()%></td>
        <td><%=r.getRoutestatus()%></td>
    </tr>
    <%
    }
    %>
</table>
</body>
</html>
