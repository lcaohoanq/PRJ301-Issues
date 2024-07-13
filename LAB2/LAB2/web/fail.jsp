<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String ms = (String)request.getAttribute("fail");
        %>
        <h1 style="color: red"><%= ms%></h1>
        <a href="http://localhost:8080/loginform/login.jsp">Click here to try again</a>
    </body>
</html>
