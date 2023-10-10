<%@ page language="java"
    import="com.src.dao.DaoService,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement "
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
    <title>Add New Diversion</title>
    <link rel="stylesheet" href="CSS/adminaddservices12.css">
</head>
<body>
<jsp:include page="admin_navbar.jsp"></jsp:include>
<%
    String message = (String) request.getAttribute("message");
%>
<script>
<% if (message != null && !message.isEmpty()) { %>
    alert("<%= message %>");
<% } %>
</script>
<div class="contains">
    <div class="container">
        <form class="contact-form" action="./admin?mode=adddiversion" method="post" autocomplete="off">
            <table class="table-form">
                <th>
                    <td></td>
                    <h3>DIVERSION DETAILS</h3>
                </th>
                <tr>
                    <td><label for="diversionid">Enter Diversion Id</label></td>
                    <td><input type="text" class="form-control" name="divid" id="divid" required></td>
                </tr>
                <tr>
                    <td><label for="routetype">Select Route Type</label></td>
                    <td>
                        <select class="form-control" name="divroutetype" id="divroutetype" required>
                            <option value="nationalhighway">National Highway</option>
                            <option value="statehighway">State Highway</option>
                            <option value="districtroads">District Roads</option>
                            <option value="otherroads">Other Roads</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Diversion Starting Place</td>
                    <td><input type="text" class="form-control" name="divstart" required /></td>
                </tr>
                <tr>
                    <td>Diversion End Place</td>
                    <td><input type="text" class="form-control" name="divend" required/></td>
                </tr>
                <tr>
                    <td>Diversion Start Date</td>
                    <td><input type="text" class="form-control" name="divstartdate" required/></td>
                </tr>
                <tr>
                    <td>Diversion End Date</td>
                    <td><input type="text" class="form-control" name="divenddate" required/></td>
                </tr>
                <tr>
                    <td>Total KM's</td>
                    <td><input type="text" class="form-control" name="divkms" required/></td>
                </tr>
                <tr>
                    <td>Route Status</td>
                    <td>
                        <select name="divstatus" required>
                            <option value="open">Open</option>
                            <option value="close">Close</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr> 
                    <td>
                        <button type="submit" class="btn btn-primary" name="adddiversion">Add Diversion</button>
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
