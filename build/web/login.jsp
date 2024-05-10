<%-- 
    Document   : login
    Created on : May 10, 2024, 8:08:33 AM
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
        <h1>Login Page</h1>
        <form action="loginservlet" method="post">
            Username<input type="text" name="user"/><br/>
            Password<input type="password" name="pass"/><br/>
            <input type="submit" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
