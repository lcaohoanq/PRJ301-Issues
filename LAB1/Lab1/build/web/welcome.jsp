<%-- 
    Document   : welcome
    Created on : May 11, 2024, 3:32:44 PM
    Author     : lcaohoanq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login success</title>
    </head>
    <body>
        <h1>Login success</h1>
        <%
            String userID = (String) request.getAttribute("userID");
        %>
        <h1 style="color: blue">Hello <%= userID%>  </h1>

        <h1>Welcome to Servlet Course</h1>

        <form action="product" method="post">
            <button>
                Click here to move to the ProductServlet
            </button>
        </form>
    </body>
</html>
