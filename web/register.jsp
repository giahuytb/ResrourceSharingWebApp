<%-- 
    Document   : register
    Created on : May 17, 2021, 8:26:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" href="CSS/login.css">
    </head>
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->
            <h2><a href="login.jsp" class="inactive underlineHover">Sign In</a></h2>
            <h2><a href ="register.jsp" class="active">Sign Up</a></h2>

            <!-- Login Form -->
            <form action="MainController">
                <input type="text" name="userID" class="fadeIn first" value="${param.userID}" placeholder="user Id"/><br/>
                ${requestScope.ERROR.userIDError}<br/>
                <input type="password" name="password" class="fadeIn second" value="${param.password}" placeholder="password"/><br/>
                ${requestScope.ERROR.passwordError}<br/>
                <input type="password" name="confirm" class="fadeIn second" value="${param.confirm}" placeholder="confirm"/><br/>
                ${requestScope.ERROR.confirmError}<br/>
                <input type="text" name="phone" class="fadeIn third" value="${param.phone}" placeholder="phone number"/><br/>
                ${requestScope.ERROR.phoneError}<br/>
                <input type="text" name="userName" class="fadeIn third" value="${param.userName}" placeholder="Your full name"/><br/>
                ${requestScope.ERROR.userNameError}<br/>
                <input type="text" name="address" class="fadeIn fourth" value="${param.address}" placeholder="Address"/><br/>
                ${requestScope.ERROR.addressError}<br/>
                <input type="text" name="gmail" class="fadeIn fourth" value="${param.gmail}" placeholder="Gmail"/><br/>
                ${requestScope.ERROR.gmailError}<br/>
                <input type="submit" name="action" class="fadeIn fourth" value="Register"/><br/>
            </form>

            <!-- Remind Passowrd -->

        </div>
    </div>

</body>
</html>
