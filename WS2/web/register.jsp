<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./style.css"/>
    </head>
    <body>
        <form action="UserServlet?action=register" method="post">
            <div class="mb-3">
                <label for="inp-username" class="form-label">Username</label>
                <input type="text" id="inp-username" name="username" required><br>
            </div>
            <div class="mb-3">
                <label for="inp-password" class="form-label">Password</label>
                <input type="password" id="inp-password" name="password" required><br>
            </div>
            <div class="mb-3">     
                <label for="inp-email" class="form-label">Email</label>       
                <input type="email" id="inp-email" name="email" required><br>
            </div>
            <div class="mb-3 form-check"> 
                <input type="checkbox" class="form-check-input" id="exampleCheck1" required="true">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>

            <input class="btn btn-primary" type="submit" value="Register">

        </form>

        <a class="btn btn-success mt-3" href="login.jsp">Login here</a>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
