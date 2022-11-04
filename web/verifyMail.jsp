<%-- 
    Document   : verifyMail
    Created on : May 19, 2021, 8:54:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Mail Page</title>
    </head>
    <body>
        <h4>We already send a verification code to your Gmail.</h4>
        <h4>Please go to your Gmail and enter code here to active your account .</h4>
        
        <form action="MainController" method="post">
            <input type="hidden" name="userID" value="${param.userID}"/>
            <input type="text" name="authCode" ><br/>
            ${requestScope.MSG}<br/>
            <input type="submit" name="action" value="Verify">
        </form>
        
    </body>
</html>
