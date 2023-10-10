<%@ page language="java" import="com.src.interfacess.CustomerServiceInterface, com.src.services.CustomerService, com.src.model.Customer" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
String customerid = "";
String customername = "";
String customerpassword = "";
long customermobnum = 0;
String customeremailid = "";

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if (session.getAttribute("id") == null) {
    response.sendRedirect("index.jsp");
} else {
    HttpSession id = request.getSession(false);
    customerid = (String) id.getAttribute("id");
    CustomerServiceInterface customerserviceinterface = new CustomerService();
    Customer customer = customerserviceinterface.getCustomerDetails(customerid);
    customername = customer.getCustomerName();
    customerpassword = customer.getCustomerPassword();
    customermobnum = customer.getCustomerMobNum();
    customeremailid = customer.getCustomerEmail();
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Profile</title>
    <link rel="stylesheet" href="CSS/customerprofile.css">
    <script src="https://kit.fontawesome.com/b42148c4b8.js" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="customer_navbar.jsp"></jsp:include>
<main>
    <section class="user-details">
        <h2>User Information</h2>
        <div id="user-info">
            <p><strong>Customer Id:</strong> <span id="user-name"><%=customerid%></span></p>
            <p><strong>Customer Name:</strong> <span id="user-email"><%=customername%></span></p>
            <p><strong>Mobile No.:</strong> <span id="user-email"><%=customermobnum%></span></p>
            <p><strong>Email:</strong> <span id="user-email"><%=customeremailid%></span></p>
            <a id="registerBtn" class="btn">Update details</a>
            <div id="registerModal" class="modal animated fadeIn">
                <div class="modal-content">
                    <a id="registerBtn2"><i class="fa-solid fa-circle-xmark close"></i></a>
                    <div class="modal-form">
                        <form action="./customer?mode=customerprofileupdate" method="post" autocomplete="off">
                            <label for="customerid">Customer ID:</label> 
                            <input type="text" id="customerid" name="customerid" value=<%=customerid %> readonly>
                            <label for="customername">Enter Customer Name:</label> 
                            <input type="text" id="customername" name="customername" placeholder=<%=customername %> required>
                            <label for="customerpswd">Enter Customer Password:</label> 
                            <input type="password" id="customerpswd" name="customerpswd" placeholder=<%=customerpassword %> required>
                            <label for="customerpswdr">Re-enter Customer Password:</label> 
                            <input type="password" id="customerpswdr" name="customerpswdr" required>
                            <label for="customermobnum">Enter Customer Mobile Number:</label> 
                            <input type="text" id="customermobnum" name="customermobnum" placeholder=<%=customermobnum %> required>
                            <label for="customeremail">Enter Customer Email:</label> 
                            <input type="email" id="customeremail" name="customeremail" placeholder=<%=customeremailid %> required>
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
