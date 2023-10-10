<%@ page language="java" 
import="com.src.dao.DaoService,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement,
com.src.interfacess.CustomerServiceInterface,com.src.services.CustomerService,java.util.ArrayList,com.src.model.Traffics "
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
<title>Traffic List</title>
<link rel="stylesheet" href="CSS/customer_alldisplays.css">
</head>
<body>
<jsp:include page="customer_navbar.jsp"></jsp:include>
<table border="2">
    <tr>
        <td>Traffic Id</td>
        <td>Traffic Route Type</td>
        <td>Traffic Type</td>
        <td>Traffic Time</td>
        <td>Traffic Status</td>
        <td>Traffic Location</td>
    </tr>

    <%
    CustomerServiceInterface csi = new CustomerService();
    ArrayList<Traffics> traffic = (ArrayList<Traffics>) csi.customer_allTraffics();

    for (Traffics t : traffic) {
    %>
    <tr>
        <td><%=t.getTrafficid()%></td>
        <td><%=t.getTrafficroutetype()%></td>
        <td><%=t.getTraffictype()%></td>
        <td><%=t.getTraffictime()%></td>
        <td><%=t.getTrafficstatus()%></td>
        <td><%=t.getTrafficlocation()%></td>
    </tr>
    <%
    }
    %>
</table>
</body>
</html>
