<%@ page language="java"
    import="com.src.interfacess.AdminServiceInterface,com.src.services.AdminService,com.src.model.Admin"
    contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
String adminid = "";
String adminname = "";
String adminpassword = "";
long adminmobnum = 0;
String adminemailid = "";

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if (session.getAttribute("id") == null) {
    response.sendRedirect("index.jsp");
} else {
    HttpSession id = request.getSession(false);
    adminid = (String) id.getAttribute("id");
    AdminServiceInterface adminserviceinterface = new AdminService();
    Admin admin = adminserviceinterface.getAdminDetails(adminid);
    adminname = admin.getAdminName();
    adminpassword = admin.getAdminPassword();
    adminmobnum = admin.getAdminmobnum();
    adminemailid = admin.getAdminemail();
}
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/adminprofileee.css">
    <script src="https://kit.fontawesome.com/b42148c4b8.js" crossorigin="anonymous"></script>
    <meta charset="ISO-8859-1">
    <title>Admin Profile</title>
</head>
<body>
<jsp:include page="admin_navbar.jsp"></jsp:include>

<main>
    <section class="user-details">
        <h2>User Information</h2>
        <div id="user-info">
            <p><strong>Admin Id:</strong> <span id="user-name"><%= adminid %></span></p>
            <p><strong>Admin Name:</strong> <span id="user-email"><%= adminname %></span></p>
            <p><strong>Mobile No.:</strong> <span id="user-email"><%= adminmobnum %></span></p>
            <p><strong>Email:</strong> <span id="user-email"><%= adminemailid %></span></p>
            <a id="registerBtn" class="btn">Update details</a>
            <div id="registerModal" class="modal animated fadeIn">
                <div class="modal-content">
                    <a id="registerBtn2"><i class="fa-solid fa-circle-xmark close"></i></a>
                    <div class="modal-form">
                        <form action="./admin?mode=adminprofileupdate" method="post" autocomplete="off">
                            <label for="adminid">Admin ID:</label>
                            <input type="text" id="adminid" name="adminid" value=<%= adminid %> readonly>
                            <label for="adminname">Enter Admin Name:</label>
                            <input type="text" id="adminname" name="adminname" placeholder=<%= adminname %> required>
                            <label for="adminpswd">Enter Admin Password:</label>
                            <input type="password" id="adminpswd" name="adminpswd" placeholder=<%= adminpassword %> required>
                            <label for="adminpswdr">Re-enter Admin Password:</label>
                            <input type="password" id="adminpswdr" name="adminpswdr" required>
                            <label for="adminmobnum">Enter Admin Mobile Number:</label>
                            <input type="text" id="adminmobnum" name="adminmobnum" placeholder=<%= adminmobnum %> required>
                            <label for="adminemail">Enter Admin Email:</label>
                            <input type="email" id="adminemail" name="adminemail" placeholder=<%= adminemailid %> required>
                            <input class="btn" type="submit" value="Update">
                            <input class="btn" type="reset" value="Reset">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<script src="JS/profile.js" crossorigin="anonymous"></script>
</body>
</html>
