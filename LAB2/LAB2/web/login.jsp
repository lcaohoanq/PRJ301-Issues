<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="MainController" method="post">
            Username<input type="text" name="user"/><br/>
            Password<input type="password" name="pass"/><br/>
            <input type="submit" name="action" value="Login"/>
            <input type="reset"  value="Reset"/>
        </form>
        <a href="create.jsp">Create new User</a></br>

        <form action="MainController" method="GET">
            <label for="showBook">Click here to buy books</label>
            <input id="showBook" type="submit" name="action" value="Show Book">
        </form>

    </body>
</html>
