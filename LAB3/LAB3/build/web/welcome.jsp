<%@page import="java.util.List"%>
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

        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <%= message%>
    </body>
</html>
