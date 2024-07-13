<%@page import="error.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserError userError= (UserError)request.getAttribute("USER_ERROR");
            if(userError== null){
                userError= new UserError();
            }
        %>
        <h1>Input your information</h1>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" required=""/>
            <%= userError.getUserID() %></br>
            Full Name<input type="text" name="fullName" required=""/>
            <%= userError.getFullName()%></br>
            Role ID<input type="text" name="roleID" value="US" readonly=""/></br>
            Password<input type="password" name="password" required=""/></br>
            Confirm<input type="password" name="confirm" required=""/>
            <%= userError.getConfirm()%></br>
            <input type="submit" name="action" value="Create"/>
            <input type="reset"  value="Reset"/>
        </form>
            <a href="login.jsp">Back to login</a>
    </body>
</html>
