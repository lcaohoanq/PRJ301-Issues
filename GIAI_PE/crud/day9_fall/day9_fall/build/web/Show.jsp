<%-- 
    Document   : Show
    Created on : Oct 12, 2020, 8:15:41 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <table border="1px solid black">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Dob</th>
                </tr>
            <c:forEach begin="1" end="5" var="x">
                <tr>
                    <td>1</td>
                    <td>Fu hoa lac</td>
                    <td>Male</td>
                    <td>20-02-2020</td>
                    <td>
                        <a href="#">update</a>
                        <a href="#">delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
            <a href="Add.jsp">Create student</a>    
    </body>
</html>
