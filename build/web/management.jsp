<%-- 
    Document   : ManagementPage
    Created on : May 14, 2021, 6:23:58 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management Page</title>
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
        </form>

        <form action="MainController">        
            Resource Name: <input type="text" name="SearchByName" value="${param.SearchByName}"/>
            Status: <select name="StatusByStatus" >
                <option value="">All</option>
                <option value="New">New</option>
                <option value="Approve">Approve</option>
                <option value="Reject">Reject</option>  
                <option value="Delete">Delete</option>
            </select>
            <input type="submit" name="action" value="Search Request"/>
        </form>

        <c:if test="${requestScope.LIST_REQUEST != null}">

            <div class="container">
                <div class="row col-md-6 col-md-offset-2 custyle">
                    <table class="table table-striped custab">

                        <thead>
                            <tr>
                                <th>Count</th>
                                <th>Resource Name</th>
                                <th>Category</th>
                                <th>Booking Date</th>
                                <th>Status</th>
                                <th>Edit Status</th>                                
                            </tr>
                        </thead>

                        <c:forEach var="request" items="${requestScope.LIST_REQUEST}" varStatus="counter">
                            <form action="MainController">
                                <tbody>
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${request.resourceName}</td>
                                        <td>${request.categoryName}</td>
                                        <td>${request.bookingDate}</td>
                                        <td>${request.requestStatus}</td>
                                        <td>
                                            <c:if test="${request.requestStatus == 'New'}">
                                                <c:url var="Edit" value="MainController">
                                                    <c:param name="action" value="Edit" ></c:param>
                                                    <c:param name="SearchByName"  value="${param.SearchByName}" ></c:param>
                                                    <c:param name="StatusByStatus" value="${param.StatusByStatus}" ></c:param>
                                                    <c:param name="index" value="${requestScope.INDEX}"></c:param>
                                                    <c:param name="userName" value="${request.userName}"></c:param>
                                                    <c:param name="resourceName" value="${request.resourceName}"></c:param>
                                                    <c:param name="categoryName" value="${request.categoryName}"></c:param>
                                                    <c:param name="requestStatus" value="${request.requestStatus}"></c:param>
                                                    <c:param name="requestID" value="${request.requestID}"></c:param>
                                                </c:url>
                                                <a href="${Edit}">Edit</a>
                                            </c:if>
                                        </td>
                                    </tr>
                                </tbody>
                            </form>
                        </c:forEach>
                    </table>
                    <c:forEach begin="1" end="${requestScope.END_PAGE}" var="i">
                        <c:url var="page" value="MainController">
                            <c:param name="action" value="Search Request"></c:param>
                            <c:param name="index" value="${i}"></c:param>
                            <c:param name="SearchByName" value="${param.SearchByName}"></c:param>
                            <c:param name="StatusByStatus" value="${param.StatusByStatus}"></c:param>
                        </c:url>
                        <a class="${requestScope.INDEX == i?"active":""}" href="${page}">${i}</a>
                    </c:forEach>
                </div>                             
            </div>
        </c:if>
    </body>
</html>
