<%-- 
    Document   : Add
    Created on : Oct 12, 2020, 9:17:52 PM
    Author     : trinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="post">
            <table>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <input type="radio" name="gender" value="1">Male
                        <input type="radio" name="gender" value="0">Female
                    </td>
                </tr>
                <tr>
                    <td>Dob</td>
                    <td><input type="text" name="dob"</td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Add student</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
