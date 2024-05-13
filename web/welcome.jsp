<%-- 
    Document   : welcome
    Created on : May 11, 2024, 3:32:44 PM
    Author     : lcaohoanq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login success</title>
    </head>
    <body>
        <h1>Login success</h1>
        <%
            String username = (String) request.getAttribute("username");
        %>
        <h1>Hello <%= username%>  </h1>
    </body>
</html>
