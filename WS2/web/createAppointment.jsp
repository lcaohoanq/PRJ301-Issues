<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./style.css"/>
    </head>
    <body>
        <%
            if (session == null || session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <form action="MainController" method="POST">
            Date: <input type="date" name="appointmentDate" required><br>
            Time: <input type="time" name="appointmentTime" required><br>
            Purpose: <input type="text" name="purpose" required><br>
            <button class="btn btn-primary" type="submit" name="action" value="createNew">Create Appointment</button>
        </form>
        <a class="text text-danger" href="dashboard.jsp">Back to Dashboard</a>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
