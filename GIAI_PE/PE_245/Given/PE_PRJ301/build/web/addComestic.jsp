<%-- 
    Document   : addComestic
    Created on : Aug 15, 2023, 10:33:54 AM
    Author     : leyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Comestic</title>
    </head>
    <body>
        <h1>Add new</h1>
        <form action="MainController">
            Id <input type="text" name="id" required><br>
            Name <input type="text" name="name" required><br>
            Description <input type="text" name="description" required><br>
            Price <input type="number" name="price" required><br>
            Size <input type="text" name="size" required><br>
            <input type="submit" name="action" value="Add"><br>
              <p>${requestScope.message}</p>
        </form>

    </body>
</html>
