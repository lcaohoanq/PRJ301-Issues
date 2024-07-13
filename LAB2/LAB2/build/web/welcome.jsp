<%@page import="java.util.List"%>
<%@page import="models.BookDTO"%>
<%@page import="DAO.BookDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Shop</title>
    </head>
    <body>
        <%
            String ms = (String) request.getAttribute("success");

            // Setting a default value if null
            if (ms == null) {
                ms = "Anonymous User";
            }
        %>

        <c:choose>
            <c:when test="${empty ms}">
                <h1>
                    <%= ms%>
                </h1>
            </c:when>
            <c:otherwise>
                <h1>
                    <%= ms%>
                </h1>
            </c:otherwise>
        </c:choose>

        <form>

            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>ADDToCart</th>
                    </tr>
                </thead>
                <tbody>
                    <jsp:useBean id="db" class="DAO.BookDAO"/>
                    <c:forEach items="${db.listBook}" var="i">
                    <form action="MainController" method="POST" >
                        <tr>
                            <td>${i.id}</td>
                            <td>${i.name}</td>  
                            <td>${i.price}</td> 
                            <td>${i.description}</td> 

                            <td><select name="Quantity">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="10">10</option>
                                    <option value="50">50</option>
                                </select></td>
                            <td>

                                <input type="hidden" name="id" value="${i.id}" />
                                <input type="submit" value="Add to cart" name="action"/>
                    </form>   
                    </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
            <input type="submit" value="ViewYourCart" name="action"/>
            <form action="MainController" method="POST">
                <input type="submit" name="action" value="Logout"/>
            </form>
        </form>
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <%= message%>
    </body>
</html>
