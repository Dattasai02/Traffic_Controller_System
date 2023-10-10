<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Home</title>
    <link rel="stylesheet" href="CSS/customerhome.css">
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
                    alert("<%=message%>");
                <% } %>
            </script>
            <form action="./customer?mode=customerregister" method="POST" autocomplete="off">
                <br>
                <h1>Create Account</h1>
                <br>
                <label>Enter Customer ID:</label>
                <input type="text" name="customerid" id="customerid" required>
                <label>Enter Customer Name:</label>
                <input type="text" name="customername" id="customername" required>
                <label>Enter Customer Password:</label>
                <input type="password" name="customerpswd" id="customerpswd" required>
                <label>Enter Customer Mobile Number:</label>
                <input type="text" name="customermobnum" id="customermobnum" required>
                <label>Enter Customer Email ID:</label>
                <input type="text" name="customeremail" id="customeremail" required>
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
                    alert("<%=errorMessage%>");
                <% } %>
            </script>
            <form action="./customer?mode=customerlogin" method="POST" autocomplete="off">
                <h1>Sign In</h1>
                <br> <br> <br>
                <label>Enter Customer ID:</label>
                <input type="text" name="customerid" id="customerid" required>
                <label>Enter Customer Password:</label>
                <input type="password" name="customerpswd" id="customerpswd" required>
                <input class="btn ghost" type="submit" value="Login">
                <input class="btn ghost" type="reset" value="Reset"> <br>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back Customer!</h1>
                    <p>To stay connected with us, please login with your personal information.</p>
                    <button class="btn ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Mr. Customer!</h1>
                    <p>Enter your personal details and start your journey with us for traffic management.</p>
                    <button class="btn ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
    <script src="JS/customerhome.js"></script>
</body>
</html>
