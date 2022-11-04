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
        <title>Resource Page</title>
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
            <input type="submit" name="action" value="Logout"/><br/>>
            <br/>
        </form>

        <form action="MainController">              
            Name:<input type="text" name="rsNameSearch" value="${param.rsNameSearch}"/>
            Category :<select name="cateNameSearch" selected = "Room">
                <option value="All"> ALL</option>
                <option value="Electronic device">Electronic device</option>
                <option value="Room" >Room</option>
                <option value="Item" >Item</option>                
            </select>
            Minimum use date:<input type="text" name="usingDateSearch" value="${param.usingDateSearch}"/>
            <input type="submit" name="action" value="Search"/><br/>
        </form>  
  
            
        <c:if test="${requestScope.LIST_RESOURCES != null}">
            <div class="container">
                <div class="row col-md-6 col-md-offset-2 custyle">
                    <table class="table table-striped custab">
                        <thead>
                            <tr>
                                <th>Resource ID</th>
                                <th>Resource Name</th>
                                <th>Resource Color</th>
                                <th>Category Name</th>
                                <th>Quantity</th>
                                <th>Using Date</th>
                                <th class="text-center">Request To Use</th>
                            </tr>
                        </thead>
                        <c:forEach var="resource" items="${requestScope.LIST_RESOURCES}">
                            <form action="MainController">
                                <tbody>
                                    <tr>
                                        <td>${resource.id}</td>
                                        <td>${resource.resourceName}</td>
                                        <td>${resource.color}</td>
                                        <td>${resource.categoryName}</td>
                                        <td>∞</td>
                                        <td>${resource.usingDate}</td>                             
                                        <td>
                                            <c:url var="resource" value="MainController">
                                                <c:param name="action" value="Request" ></c:param>
                                                <c:param name="rsNameSearch" value="${param.rsNameSearch}" ></c:param>
                                                <c:param name="cateNameSearch" value="${param.cateNameSearch}" ></c:param>
                                                <c:param name="usingDateSearch" value="${param.usingDateSearch}" ></c:param>
                                                <c:param name="index" value="${requestScope.INDEX}"></c:param>
                                                <c:param name="resourceName" value="${resource.resourceName}"></c:param>
                                                <c:param name="categoryName" value="${resource.categoryName}"></c:param>
                                                <c:param name="usingDate" value="${resource.usingDate}"></c:param>
                                                <c:param name="id" value="${resource.id}"></c:param>
                                                <c:param name="categoryID" value="${resource.categoryID}"></c:param>
                                            </c:url>
                                            <a href="${resource}">Request</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </form>
                        </c:forEach>
                    </table>
                    <c:forEach begin="1" end="${requestScope.END_PAGE}" var="i">         
                        <c:url var="page" value="MainController">
                            <c:param name="action" value="Search"></c:param>
                            <c:param name="index" value="${i}"></c:param>
                            <c:param name="rsNameSearch" value="${param.rsNameSearch}"></c:param>
                            <c:param name="cateNameSearch" value="${param.cateNameSearch}"></c:param>
                            <c:param name="usingDateSearch" value="${param.usingDateSearch}"></c:param>
                        </c:url>
                        <a class="${requestScope.INDEX == i?"active":""}" href="${page}">${i}</a>    
                    </c:forEach>
                    <h4>${requestScope.MSG}</h4><br/>
                </div>                             
            </div>
        </c:if>

            <c:url var="history" value="MainController">
                <c:param name="action" value="History"></c:param>
                <c:param name="userName" value="${sessionScope.USER_LOGIN.userName}"></c:param>
            </c:url>
            <h4><a href="${history}">History</a></h4>
            
    </body>
</html>
