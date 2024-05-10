<%-- 
    Document   : welcome
    Created on : May 10, 2024, 8:19:30 AM
    Author     : Luu Minh Quan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String ms = (String)request.getAttribute("success");
        %>
        <h1><%= ms%></h1>
        <form>
            Name <input type="text" name="name"/><br/>
            <input type="submit" value="Search"/>
        </form>
    </body>
</html>
