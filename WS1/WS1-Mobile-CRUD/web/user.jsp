<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="icon" type="image/png" href="./resources/favicon.ico" />
        <link rel="stylesheet" href="./style/util/reset.css" />
        <link rel="stylesheet" href="./style/util/commons.css" />
        <link rel="stylesheet" href="./style/component/user/user.css" />
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"US".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <div class="container">
            <div class="data">
                <h1>User ID:</h1>
                    <p><%= loginUser.getUserID()%></p>
                <h1>Full Name:</h1>
                    <p><%= loginUser.getName()%></p>
                <h1>Role ID:</h1>
                    <p><%= loginUser.getRoleID()%></p>
                <h1>Password:</h1>
                    <p><%= loginUser.getPassword()%></p>
            </div>
        </div>
    </body>
</html>
