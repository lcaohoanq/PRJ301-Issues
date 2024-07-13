<%@page import="pe.dtos.UserDTO"%>
<%@page import="pe.daos.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Comestic</title>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");

            if (user == null || !new UserDAO().getRoleByID(user.getUserID()).equals("AD")) {
                response.sendRedirect("./authentication.jsp");
            } else {
        %>

        <h1>Add new</h1>
        <form action="MainController" method="POST">
            Id <input type="text" name="id" required><br>
            Name <input type="text" name="name" required><br>
            Description <input type="text" name="description" required><br>
            Price <input type="number" name="price" required><br>
            Size <input type="text" name="size" required><br>
            <input type="submit" name="action" value="Add"><br>
            <p>${requestScope.message}</p>
        </form>

        <%
            }
        %>

    </body>
</html>
