<%-- 
    Document   : ComesticList
    Created on : Aug 15, 2023, 9:29:42 AM
    Author     : leyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comestic List</title>
    </head>
    <body>
        <form action="MainController">
            <div>
                <h1 style="display: inline">Welcome ${sessionScope.LOGIN_USER.getFullname()}</h1>
                <input type="submit" name="action" value="Logout"/>
            </div>

            <input type="type" name="search"> <input type="submit" name="action" value="Search"/>
            Price From: <input type="type" name="from"> 
            Price To: <input type="type" name="to"> <input type="submit" name="action" value="Search"/>
            <table border="1">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>description</th>
                        <th>price</th>
                        <th>size</th>
                        <th>delete</th>
                        <th>update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${requestScope.list}">
                    <form action="MainController">
                        <tr>
                            <td>${c.getId()}</td>
                            <td> <input type="text" name="name" value="${c.getName()}"/></td>
                            <td><input type="text" name="description" value="${c.getDescription()}"/></td>
                            <td><input type="text" name="price" value="${c.getPrice()}"/></td>
                            <td><input type="text" name="size" value="${c.getSize()}"/></td>
                            <td><button type="submit" name="action" value="Delete">Delete</button></td>
                            <td><button type="submit" name="action" value="Update">Update</button></td>
                        <input type="hidden" name="id" value="${c.getId()}">
                        </tr>
                    </form>

                </c:forEach>
                </tbody>
            </table>
            
            <input type="hidden" name="userId" value="${sessionScope.LOGIN_USER.getUserID()}">
            <button type="submit" name="action" value="ShowAdd">Add new comestic</button>
            <p>${requestScope.message}</p>
        </form>
    </body>
</html>
