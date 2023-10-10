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

<%
String routeid = request.getParameter("routeid");
String routetype = "";
String routevehicle = "";
String routestart = "";
String routeend = "";
int routekms = 0;
String routestatus = "";

ResultSet rs = null;
try {
    DaoService dao = new DaoService();
    Statement st = dao.getMyStatement();
    String query = "select * from routes where routeid='" + routeid + "'  ";
    rs = st.executeQuery(query);
    if (rs.next()) {
        routetype = rs.getString(2);
        routevehicle = rs.getString(3);
        routestart = rs.getString(4);
        routeend = rs.getString(5);
        routekms = rs.getInt(6);
        routestatus = rs.getString(7);
    }
} catch (SQLException e) {
    e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Route</title>
    <link rel="stylesheet" href="CSS/adminaddservices12.css">
</head>
<body>
<jsp:include page="admin_navbar.jsp"></jsp:include>

<div class="contains">
    <div class="container">
        <form class="contact-form" action="./admin?mode=editroute" method="post" autocomplete="off">
            <table class="table-form">
                <th>
                    <td></td>
                    <h3>ROUTE DETAILS</h3>
                </th>
                <tr>
                    <td><label for="routeid">Route Id</label></td>
                    <td><input type="text" class="form-control" name="routeid"
                            id="routeid" value=<%=routeid%> readonly ></td>
                </tr>
                <tr>
                    <td><label for="routetype">Route Type</label></td>
                    <td><input type="text" class="form-control" name="routetype"
                            id="routetype" value=<%=routetype%> readonly ></td>
                </tr>
                <tr>
                    <td><label for="routevehicle">Select Route Allowed
                            For Vehicles</label></td>
                    <td><select class="form-control" name="routevehicle"
                            id="routevehicle" required>
                            <option value="twowheeler">Two Wheeler</option>
                            <option value="fourwheeler">Four Wheeler</option>
                            <option value="four+wheeler">Four(+) Wheeler</option>
                    </select></td>
                </tr>
                <tr>
                    <td><label for="routestart">Route Starting Place</label></td>
                    <td><input type="text" class="form-control" name="routestart"
                            id="routestart" placeholder="<%=routestart%>" required ></td>
                </tr>
                <tr>
                    <td><label for="routeend">Route End Place</label></td>
                    <td><input type="text" class="form-control" name="routeend"
                            id="routeend" placeholder="<%=routeend%>"
                            required></td>
                </tr>
                <tr>
                    <td><label for="routekms">Total KM's</label></td>
                    <td><input type="text" class="form-control" name="routekms"
                            id="routekms" placeholder="<%=routekms%>"required></td>
                </tr>
                <tr>
                    <td><label for="routestatus">Route Status</label></td>
                    <td><select class="form-control" name="routestatus"
                            id="routestatus" required>
                            <option value="open">Open</option>
                            <option value="close">Close</option>
                    </select></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" class="btn btn-primary" name="editroute">Edit Route</button>
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
