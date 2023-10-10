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
String trafficid = request.getParameter("trafficid");
String routetype = "";
String traffictype = "";
String traffictime = "";
String status = "";
String location = "";

ResultSet rs = null;
try {
    DaoService dao = new DaoService();
    Statement st = dao.getMyStatement();
    String query = "select * from traffics where trafficid='" + trafficid + "'  ";
    rs = st.executeQuery(query);
    if (rs.next()) {
        routetype = rs.getString(2);
        traffictype = rs.getString(3);
        traffictime = rs.getString(4);
        status = rs.getString(5);
        location = rs.getString(6);
    }
} catch (SQLException e) {
    e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Traffic</title>
    <link rel="stylesheet" href="CSS/adminaddservices12.css">
</head>
<body>
<jsp:include page="admin_navbar.jsp"></jsp:include>
<div class="contains">
    <div class="container">
        <form class="contact-form" id="trafficadd" action="./admin?mode=edittraffic" method="post" autocomplete="off">
            <table class="table-form">
                <th>
                    <td></td>
                    <h3>TRAFFIC DETAILS</h3>
                </th>
                <tr>
                    <td>Traffic Id</td>
                    <td><input type="text" class="form-control" name="trafficid" value="<%=trafficid%>" readonly/></td>
                </tr>
                <tr>
                    <td>Traffic Route Type</td>
                    <td><input type="text" class="form-control" name="routetype" value="<%=routetype%>" readonly/></td>
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
                    <td><input type="text" class="form-control" name="traffictime" placeholder="<%=traffictime%>" required/></td>
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
                    <td><input type="text" class="form-control" name="trafficlocation" value="<%=location%>" readonly/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" class="btn btn-primary" name="edittraffic">Edit Traffic</button>
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
