<%@ page language="java"
    import="com.src.dao.DaoService,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement,com.src.interfacess.AdminServiceInterface,com.src.services.AdminService,java.util.ArrayList,com.src.model.Traffics"
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
    <title>All TRaffics</title>
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
        <td>Traffic Id</td>
        <td>Traffic Route Type</td>
        <td>Traffic Type</td>
        <td>Traffic Time</td>
        <td>Traffic Status</td>
        <td>Traffic Location</td>
        <td colspan="2" style="text-align:center;">Operations</td>
    </tr>

    <%
    AdminServiceInterface asi = new AdminService();
    ArrayList<Traffics> traffic = (ArrayList<Traffics>) asi.admin_allTraffics();

    for (Traffics t : traffic) {
    %>
    <tr>
        <td><%=t.getTrafficid()%></td>
        <td><%=t.getTrafficroutetype()%></td>
        <td><%=t.getTraffictype()%></td>
        <td><%=t.getTraffictime()%></td>
        <td><%=t.getTrafficstatus()%></td>
        <td><%=t.getTrafficlocation()%></td>
        <td><a href="./admin?mode=deletetraffic&trafficid=<%=t.getTrafficid()%>">Delete Traffic</a></td>
        <td><a href="admin_editTraffics.jsp?trafficid=<%=t.getTrafficid()%>">Update Traffic</a></td>
    </tr>
    <%
    }
    %>
</table>
</body>
</html>
