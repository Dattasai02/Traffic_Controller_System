<%@ page language="java"
    import="com.src.dao.DaoService,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement,com.src.interfacess.AdminServiceInterface,com.src.services.AdminService,java.util.ArrayList,com.src.model.Diversions"
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
    <title>All Diversions</title>
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
        <td>Diversion Id</td>
        <td>Diversion Route Type</td>
        <td>Diversion Start Place</td>
        <td>Diversion End Place</td>
        <td>Diversion Start Date</td>
        <td>Diversion End Date</td>
        <td>Diversion Route Kms</td>
        <td>Diversion Route Status</td>
        <td colspan="2" style="text-align:center;">Operations</td>
    </tr>

    <%
    AdminServiceInterface asi = new AdminService();
    ArrayList<Diversions> div = (ArrayList<Diversions>) asi.admin_allDiversions();

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
        <td><a href="./admin?mode=deletediversion&divid=<%=d.getDivid()%>">Delete Diversion</a></td>
        <td><a href="admin_editDiversions.jsp?divid=<%=d.getDivid()%>">Update Diversion</a></td>
    </tr>
    <%
    }
    %>
</table>

</body>
</html>
