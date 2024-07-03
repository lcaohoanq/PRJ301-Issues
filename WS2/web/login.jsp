<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./style.css"/>
    </head>
    <body>
        <form action="UserServlet?action=login" method="post">
            <div class="mb-3">
                <label for="inp-username" class="form-label">Username</label>
                <input type="text" class="form-control" id="inp-username" name="username" required><br>
                <div id="emailHelp" class="form-text">We'll never share your data with anyone else.</div>
            </div>
            <div class="mb-3">
                <label for="inp-password" class="form-label">Password</label>
                <input type="password" class="form-control" id="inp-password" name="password" required><br>
            </div>

            <input class="btn btn-primary" type="submit" value="Login">
        </form>
        <a class="btn btn-success mt-3" href="register.jsp">Register here</a>
        <%
            String error = request.getParameter("error");
            if ("invalid".equals(error)) {
        %>
        <p style="color:red">Invalid username or password</p>
        <%
            }
        %>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
