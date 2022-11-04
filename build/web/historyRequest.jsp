<%-- 
    Document   : resourcePage
    Created on : May 12, 2021, 3:45:51 PM
    Author     : Admin
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="CSS/table.css">
    </head>

    <body>
        <c:if test="${sessionScope.USER_LOGIN != null}">
            <h3> Welcome: ${sessionScope.USER_LOGIN.userName}</h3>            
        </c:if>  

        <form action="MainController">
            <input type="submit" name="action" value="Logout"/><br/>
            <br/>
        </form>

        <form action="MainController">              
            Name:<input type="text" name="rsNameSearch" value="${param.rsNameSearch}"/>
            Date Request: <input type="text" name="dateSearch" value="${param.dateSearch}" placeholder="yyyy-mm-dd"/>
            <input type="hidden" name="userName" value="${sessionScope.USER_LOGIN.userName}"/>
            <input type="submit" name="action" value="Find"/><br/>
        </form>  

        <c:if test="${requestScope.HISTORY_LIST != null}">
            <div class="container">
                <div class="row col-md-6 col-md-offset-2 custyle">
                    <table class="table table-striped custab">
                        <thead>
                            <tr>
                                <th>count</th>
                                <th>Resource Name</th>
                                <th>Category Name</th>
                                <th>Booking Date</th>
                                <th>Status</th>
                                <th class="text-center">Delete</th>
                            </tr>
                        </thead>
                        <c:forEach var="history" items="${requestScope.HISTORY_LIST}" varStatus="counter">
                            <form action="MainController">
                                <tbody>
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${history.resourceName}</td>
                                        <td>${history.categoryName}</td>
                                        <td>${history.bookingDate}</td>
                                        <td>${history.requestStatus}</td>
                                        <td>
                                            <c:url var="delete" value="MainController">
                                                <c:param name="action" value="Delete" ></c:param>
                                                <c:param name="rsNameSearch"  value="${param.rsNameSearch}" ></c:param>
                                                <c:param name="dateSearch" value="${param.dateSearch}" ></c:param>
                                                <c:param name="index" value="${requestScope.INDEX}"></c:param>
                                                <c:param name="userName" value="${sessionScope.USER_LOGIN.userName}"></c:param>
                                                <c:param name="resourceName" value="${history.resourceName}"></c:param>
                                                <c:param name="categoryName" value="${history.categoryName}"></c:param>
                                                <c:param name="requestStatus" value="${history.requestStatus}"></c:param>
                                                <c:param name="requestID" value="${history.requestID}"></c:param>
                                            </c:url>
                                            <a href="${delete}">Delete</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </form>
                        </c:forEach>
                    </table>
                    <c:forEach begin="1" end="${requestScope.END_PAGE}" var="i">         
                        <c:url var="page" value="MainController">
                            <c:param name="action" value="Find"></c:param>
                            <c:param name="index" value="${i}"></c:param>
                            <c:param name="userName" value="${sessionScope.USER_LOGIN.userName}"></c:param>
                            <c:param name="rsNameSearch" value="${param.rsNameSearch}"></c:param>
                            <c:param name="dateSearch" value="${param.dateSearch}"></c:param>
                        </c:url>
                        <a class="${requestScope.INDEX == i?"active":""}" href="${page}">${i}</a>    
                    </c:forEach>
                    <h4>${requestScope.MSG}</h4><br/>
                    <h4> <a href="SearchController">Back</a> </h4><br/>
                </div>                             
            </div>
        </c:if>

    </body>
</html>

