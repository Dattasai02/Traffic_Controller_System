<%@ page language="java"
    import="com.src.dao.DaoService,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement,com.src.interfacess.AdminServiceInterface,com.src.services.AdminService,java.util.ArrayList,com.src.model.Routes"
    contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    isELIgnored="false"%>

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
    <title>All routes</title>
    <link rel="stylesheet" href="CSS/admin_alldisplays.css">
</head>
<body>
<jsp:include page="admin_navbar.jsp"></jsp:include>
<%
String message = (String) request.getAttribute("message");
%>
<script>
    <% if (message != null && !message.isEmpty()) { %>
    alert("<%=message%>");
    <%}%>
</script>
<table border="2">
    <tr>
        <td>Route Id</td>
        <td>Route Type</td>
        <td>Route Allowed Vehicle</td>
        <td>Route Start Place</td>
        <td>Route End Place</td>
        <td>Route Kms</td>
        <td>Route Status</td>
        <td colspan="2" style="text-align:center;">Operations</td>
    </tr>

    <%
    AdminServiceInterface asi = new AdminService();
    ArrayList<Routes> routes = (ArrayList<Routes>) asi.admin_allRoutes();

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
        <td><a href="./admin?mode=deleteroute&routeid=<%=r.getRouteid()%>">Delete Route</a></td>
        <td><a href="admin_editRoutes.jsp?routeid=<%=r.getRouteid()%>">Update Route</a></td>
    </tr>
    <%
    }
    %>
</table>
</body>
</html>
