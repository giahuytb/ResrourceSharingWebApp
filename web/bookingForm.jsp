<%-- 
    Document   : bookingForm
    Created on : May 17, 2021, 7:34:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Form</title>
        <link rel="stylesheet" href="CSS/login.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <form action="MainController">
                    Name of request booking: <br/>
                    <input type="text" name ="resourceName" value="${param.resourceName}" class="fadeIn first" readonly="true" /> <br/>
                    Category Name: <br/>
                    <input type="text" name="categoryName" value="${param.categoryName}" class="fadeIn first" readonly="true" /> <br/>
                    Using date: <br/>
                    <input type="text" name="usingDate" value="${param.usingDate}" class="fadeIn first" readonly="true"/> <br/>
                    <input type="hidden" name="id" value="${param.id}" /> <br/>
                    <input type="hidden" name="categoryID" value="${param.categoryID}" /> <br/>
                    <input type="hidden" name="rsNameSearch" value="${param.rsNameSearch}" /> <br/>
                    <input type="hidden" name="cateNameSearch" value="${param.cateNameSearch}" /> <br/>
                    <input type="hidden" name="usingDateSearch" value="${param.usingDateSearch}" /> <br/>
                    <input type="hidden" name="index" value="${param.index}" /> <br/>
                    <br/>
                    <input type="submit" name="action" value="Booking" class="fadeIn first"/><br/>
                    <input type="submit" name="action" value="Cancel" class="fadeIn first"/>
                </form>
            </div>
        </div>

    </body>
</html>
