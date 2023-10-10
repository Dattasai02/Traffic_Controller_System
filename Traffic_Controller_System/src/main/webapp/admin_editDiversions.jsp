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
String divid = request.getParameter("divid");
String routetype = "";
String startplace = "";
String endplace = "";
String startdate = "";
String enddate = "";
int divkms = 0;
String divstatus = "";

ResultSet rs = null;
try {
    DaoService dao = new DaoService();
    Statement st = dao.getMyStatement();
    String query = "select * from diversions where divid='" + divid + "'  ";
    rs = st.executeQuery(query);
    if (rs.next()) {
        routetype = rs.getString(2);
        startplace = rs.getString(3);
        endplace = rs.getString(4);
        startdate = rs.getString(5);
        enddate = rs.getString(6);
        divkms = rs.getInt(7);
        divstatus = rs.getString(8);

    }
} catch (SQLException e) {
    e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Diversion</title>
    <link rel="stylesheet" href="CSS/adminaddservices12.css">
</head>
<body>
<jsp:include page="admin_navbar.jsp"></jsp:include>

<div class="contains">
    <div class="container">
        <form class="contact-form" action="./admin?mode=editdiversion" method="post" autocomplete="off">
            <table class="table-form">
                <th><td></td><h3>DIVERSION DETAILS</h3></th>
                <tr>
                    <td><label for="diversionid">Diversion Id</label></td>
                    <td><input type="text" class="form-control" name="divid" id="divid" value=<%=divid%> readonly></td>
                </tr>

                <tr>
                    <td><label for="diversionroutetype">Diversion Route Type</label></td>
                    <td><input type="text" class="form-control" name="routetype" id="routetype" value=<%=routetype%> readonly></td>
                </tr>

                <tr>
                    <td>Diversion Starting Place</td>
                    <td><input type="text" class="form-control"  name="divstart" placeholder="<%=startplace%>" required /></td>
                </tr>

                <tr>
                    <td>Diversion End Place</td>
                    <td><input type="text" class="form-control" name="divend" placeholder="<%=endplace%>" required/></td>
                </tr>

                <tr>
                    <td>Diversion Start Date</td>
                    <td><input type="text" class="form-control" name="divstartdate" placeholder="<%=startdate%>" required/></td>
                </tr>

                <tr>
                    <td>Diversion End Date</td>
                    <td><input type="text" class="form-control" name="divenddate"  placeholder="<%=enddate%>" required/></td>
                </tr>

                <tr>
                    <td>Total KM's</td>
                    <td><input type="text" class="form-control" name="divkms" placeholder="<%=divkms%>" required/></td>
                </tr>

                <tr>
                    <td>Route Status</td>
                    <td><select name="divstatus" required>
                            <option value="open">Open</option>
                            <option value="close">Close</option>
                    </select></td>
                </tr>

                <tr><td>&nbsp;</td></tr>
                <tr> 
                    <td>
                        <button type="submit" class="btn btn-primary" name="editdiversion" >Edit Diversion</button>
                    </td>
                    <td>   
                        <button type="reset" class="btn btn-secondary" >Reset</button>
                    </td>
                </tr>

                <tr><td>&nbsp;</td></tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
