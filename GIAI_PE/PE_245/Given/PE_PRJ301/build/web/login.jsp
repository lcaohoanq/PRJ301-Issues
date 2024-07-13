<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->       
        <form action="MainController" method="POST">
            User name: <input type="text" name="userID" value="" required><br>
            Password: <input type="text" name="password" value="" required><br>
            <input type="submit" name="action" value="Login"/>
            <a href="./register.jsp">Registration</a>
        </form>
        <p>${requestScope.message}</p>
    </body>
<!-- <td><input type="text" name="id" pattern="^C-\d{3}$" title="Format Id C-XXX"></td> -->
</html>

