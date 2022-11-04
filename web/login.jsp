<%-- 
    Document   : login2
    Created on : May 19, 2021, 4:57:05 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
        <link rel="stylesheet" href="CSS/login.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        
        <script type="text/javascript">
            var onloadCallback = function () {
                grecaptcha.render('html_element', {
                    'sitekey': '6Lelds4aAAAAAIR6ZZWKhkXPZ0U6rRIDmxymK33O'
                });
            };
        </script>       
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->
                <h2><a href="login2.jsp" class="active">Sign In</a></h2>
                <h2><a href ="register.jsp" class="inactive underlineHover">Sign Up</a></h2>

                <form action="MainController" method="POST">
                    <input type="text" id="login" class="fadeIn second" name="userID" placeholder="userID">
                    <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
                    <br>
                    <div id="html_element"></div>
                    <br>
                    <h4>${requestScope.MSG}</h4><br/>
                    <input type="submit" name="action" class="fadeIn fourth" value="Login">                    
                </form>
            </div>
        </div>
        <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
                async defer>
        </script>

    </body>
</html>
