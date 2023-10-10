<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
    <title>Status </title>
    <link rel="stylesheet" href="CSS/customer_viewstatus.css">
</head>
<body>
    <jsp:include page="customer_navbar.jsp"></jsp:include>
    <div class="content">
        <br>
        <div class="table">
            <table>
                <thead>
                    <tr>
                        <th scope="col" style="text-align:center;"><h2>SERVICES</h2></th>
                    </tr>
                </thead>
                <tbody>
                    <tr><td></td></tr>
                    <tr>
                        <td><a class="btn" href="customer_allroutes.jsp">All Routes</a></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td><a class="btn" href="customer_alldiversions.jsp">All Diversions</a></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td colspan="2"><a class="btn" href="customer_alltraffics.jsp">All Traffics</a></td>
                    </tr>
                    <tr><td></td></tr>
                </tbody>
            </table>
            <br><br>
        </div>
        <div class="images">
            <div class="image1">
                <img src="https://i.makeagif.com/media/9-24-2015/EstoOp.gif" alt="Image 1" class="image-adjust1">
            </div>
            <br>
        </div>
    </div>
</body>
</html>
