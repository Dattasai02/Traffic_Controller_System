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
    <title>Add New Route</title>
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
    <% } %>
    </script>
    <div class="contains">
        <div class="container">
            <form class="contact-form" action="./admin?mode=addroute" method="post" autocomplete="off">
                <table class="table-form">
                    <th>
                        <td></td>
                        <h3>ROUTE DETAILS</h3>
                    </th>
                    <tr>
                        <td><label for="routeid">Enter Route Id</label></td>
                        <td><input type="text" class="form-control" name="routeid" id="routeid" required></td>
                    </tr>
                    <tr>
                        <td><label for="routetype">Select Route Type</label></td>
                        <td>
                            <select class="form-control" name="routetype" id="routetype" required>
                                <option value="nationalhighway">National Highway</option>
                                <option value="statehighway">State Highway</option>
                                <option value="districtroads">District Roads</option>
                                <option value="otherroads">Other Roads</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="routevehicle">Select Route Allowed For Vehicles</label></td>
                        <td>
                            <select class="form-control" name="routevehicle" id="routevehicle" required>
                                <option value="twowheeler">Two Wheeler</option>
                                <option value="fourwheeler">Four Wheeler</option>
                                <option value="four+wheeler">Four(+) Wheeler</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="routestart">Route Starting Place</label></td>
                        <td><input type="text" class="form-control" name="routestart" id="routestart" required></td>
                    </tr>
                    <tr>
                        <td><label for="routeend">Route End Place</label></td>
                        <td><input type="text" class="form-control" name="routeend" id="routeend" required></td>
                    </tr>
                    <tr>
                        <td><label for="routekms">Total KM's</label></td>
                        <td><input type="text" class="form-control" name="routekms" id="routekms" required></td>
                    </tr>
                    <tr>
                        <td><label for="routestatus">Route Status</label></td>
                        <td>
                            <select class="form-control" name="routestatus" id="routestatus" required>
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
                            <button type="submit" class="btn btn-primary" name="addroute">Add Route</button>
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
