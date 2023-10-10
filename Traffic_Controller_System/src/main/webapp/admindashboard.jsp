<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
    <title>DashBoard</title>
    <link rel="stylesheet" href="CSS/admindashboarddd.css">
</head>
<body>
<jsp:include page="admin_navbar.jsp"></jsp:include>
<div class="content">
    <br>
    <div class="table">
        <table>
            <thead>
                <tr>
                    <!-- <th scope="col">#</th> -->
                    <th scope="col" style="text-align:center;"><h2>ADD SERVICES</h2></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <!-- <th scope="row">1</th> -->
                    <td><a class="btn" href="admin_addNewRoute.jsp">Add Route</a></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <!-- <th scope="row">2</th> -->
                    <td><a class="btn" href="admin_addNewDiversion.jsp">Add Diversion</a></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <!-- <th scope="row">3</th> -->
                    <td colspan="2"><a class="btn" href="admin_addNewTraffic.jsp">Add Traffic</a></td>
                </tr>
            </tbody>
        </table>
        <br><br>
        <table>
            <thead>
                <tr>
                    <!-- <th scope="col">#</th> -->
                    <th scope="col" style="text-align:center;"><h2>REPORT SERVICES</h2></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <!-- <th scope="row">1</th> -->
                    <td><a class="btn" href="admin_allroutes.jsp">All Routes</a></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <!-- <th scope="row">2</th> -->
                    <td><a class="btn" href="admin_alldiversions.jsp">All Diversion</a></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <!-- <th scope="row">3</th> -->
                    <td colspan="2"><a class="btn" href="admin_alltraffics.jsp">All Traffics</a></td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="images">
        <div class="image1">
            <img src="dashboard1.jpg" alt="Image 1" class="image-adjust1">
        </div>
        <br>
        <div class="image2">
            <img src="dashboard2.jpg" alt="Image 2" class="image-adjust1">
        </div>
    </div>
</div>
</body>
</html>
