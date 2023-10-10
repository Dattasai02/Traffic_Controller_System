<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Home</title>
    <link rel="stylesheet" href="CSS/adminhome2.css">
    <link href="https://fonts.googleapis.com/css?family=QuickSand:500" rel="stylesheet">
</head>
<body>
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <%
            String message = (String) request.getAttribute("message");
            %>
            <script>
                <% if (message != null && !message.isEmpty()) { %>
                    alert("<%= message %>");
                <% } %>
            </script>

            <form action="./admin?mode=adminregister" method="POST" id="registrationForm" autocomplete="off">
                <h1>Create Account</h1>
                <label for="adminid">Enter Admin ID:</label>
                <input type="text" id="adminid" name="adminid" required>
                <label for="adminname">Enter Admin Name:</label>
                <input type="text" id="adminname" name="adminname" required>
                <label for="adminpswd">Enter Admin Password:</label>
                <input type="password" id="adminpswd" name="adminpswd" required>
                <label for="adminmobnum">Enter Admin Mobile Number:</label>
                <input type="text" id="adminmobnum" name="adminmobnum" required>
                <label for="adminemail">Enter Admin Email:</label>
                <input type="email" id="adminemail" name="adminemail">
                <input class="btn" type="submit" value="Register" onclick="return validate()">
                <input class="btn" type="reset" value="Reset">
            </form>
        </div>
        <div class="form-container sign-in-container">
            <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            %>
            <script>
                <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
                    alert("<%= errorMessage %>");
                <% } %>
            </script>
            <form action="./admin?mode=adminlogin" method="POST" autocomplete="off">
                <h1>Sign in</h1>
                <br> <br> <br>
                <label>enter admin id :</label>
                <input type="text" id="admid" name="adminid" required="required">
                <label>enter admin password :</label>
                <input type="password" id="admpswd" name="adminpswd" required="required">
                <input class="btn" type="submit" value="Login" name="adminlogin">
                <input class="btn" type="reset" value="reset">
                <br>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back Admin!</h1>
                    <p>To keep connected with us, please login with your personal info</p>
                    <button class="btn ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Mr. Admin!</h1>
                    <p>Enter your personal details and start your journey with us for traffic management</p>
                    <button class="btn ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
    <script src="JS/adminhome.js"></script>
</body>
</html>
