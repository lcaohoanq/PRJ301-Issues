<%-- 
    Document   : registration.jsp
    Created on : Aug 15, 2023, 8:54:33 AM
    Author     : leyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="MainController" method="POST">
            Full name: <input type="text" name="fullname" value="" required><br>
            User ID: <input type="text" name="userID" value="" required><br>          
            Password: <input type="text" name="password" value="" required><br>
            <input type="submit" name="action" value="Register"/><br>
            <p>${requestScope.message}</p>
        </form>

    </body>
</html>
