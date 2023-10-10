<%@ page language="java"
    import="com.src.dao.DaoService,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement"
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
    <title>Add n=New Traffic</title>
    <link rel="stylesheet" href="CSS/adminaddservices12.css">
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
<div class="contains">
    <div class="container">
        <form class="contact-form" id="trafficadd" action="./admin?mode=addtraffic" method="post" autocomplete="off">
            <table class="table-form">
                <th>
                    <td></td>
                    <h3>TRAFFIC DETAILS</h3>
                </th>
                <tr>
                    <td>Traffic Id</td>
                    <td><input type="text" class="form-control" name="trafficid" required/></td>
                </tr>
                <tr>
                    <td>Select Route Type</td>
                    <td>
                        <select class="form-control" name="trafficroutetype" required>
                            <option value="nationalhighway">National Highway</option>
                            <option value="statehighway">State Highway</option>
                            <option value="districtroads">District Roads</option>
                            <option value="otherroads">Other Roads</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Traffic Type/Reason</td>
                    <td>
                        <select class="form-control" name="traffictype" required>
                            <option value="signals">Signals</option>
                            <option value="diversion">Diversion</option>
                            <option value="accident">Accident</option>
                            <option value="other">Other</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Traffic Start Time</td>
                    <td><input type="text" class="form-control" name="traffictime" required/></td>
                </tr>
                <tr>
                    <td>Traffic Status</td>
                    <td>
                        <select class="form-control" name="trafficstatus" required>
                            <option value="high">High</option>
                            <option value="medium">Medium</option>
                            <option value="low">Low</option>
                            <option value="none">None</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Traffic Location</td>
                    <td><input type="text" class="form-control" name="trafficlocation" required/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" class="btn btn-primary" name="addtraffic">Add Traffic</button>
                    </td>
                    <td>
                        <button type="reset" class="btn btn-secondary">Reset</button>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
