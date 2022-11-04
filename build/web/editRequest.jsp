<%-- 
    Document   : editRequest
    Created on : May 23, 2021, 5:37:23 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Request Form</title>
        <link rel="stylesheet" href="CSS/login.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <form action="MainController">
                    <h5>Name of Resource: </h5>
                    <input type="text" name ="resourceName" value="${param.resourceName}" class="fadeIn first" readonly="true" /> <br/>
                    <h5>Category Name:</h5>
                    <input type="text" name="categoryName" value="${param.categoryName}" class="fadeIn first" readonly="true" /> <br/>
                    <h5>Status: </h5>
                    <input type="text" name="requestStatus" value="${param.requestStatus}" class="fadeIn first" readonly="true"/> <br/>
                    <h5>User Booking:</h5>
                    <input type="text" value="${param.userName}" readonly="true"/><br/>
                    <input type="hidden" name="requestID" value="${param.requestID}" /> <br/>
                    <input type="hidden" name="SearchByName" value="${param.SearchByName}" /> <br/>
                    <input type="hidden" name="StatusByStatus" value="${param.StatusByStatus}" /> <br/>
                    <input type="hidden" name="index" value="${param.index}" /> <br/>
                    <br/>
                    <input type="submit" name="action" value="Approve" class="fadeIn first"/>
                    <input type="submit" name="action" value="Reject" class="fadeIn first"/>
                </form>
            </div>
        </div>

    </body>
</html>
