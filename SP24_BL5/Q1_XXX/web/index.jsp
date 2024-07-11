<%-- 
    Document   : index
    Created on : Jul 6, 2024, 10:10:58 AM
    Author     : lcaohoanq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <form action="SumServlet" method="POST">
                <table border="1">
                    <!--                <thead>
                                        <tr>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>-->

                    <tbody>
                        <tr>
                            <td rowspan="2"><p style="display: inline">
                                    Enter an integer number n:  
                                </p>
                                <input type="text" name="data" /></td>
                            <td>
                                <input id="odd" type="radio" name="action" value="odd"/>
                                <label for="odd">Sum odd</label>
                            </td>
                            <td rowspan="2"><input type="submit" value="Execute"></td>
                        </tr>
                        <tr>
                            <td>
                                <input id="even" type="radio" name="action" value="even"/>
                                <label for="even">Sum even</label>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>

            <%
                String errorData = (String) request.getAttribute("errorData");
                String errorOption = (String) request.getAttribute("errorOption");
                String result = (String) request.getAttribute("result");
                if (errorData != null) {
            %>

            <p style="color: red"> <%= errorData%> </p>

            <%
            } else if (errorOption != null) {
            %>

            <p style="color: red"><%= errorOption%></p>

            <%
            } else if(result != null) {
            %>
            <p style="color: black">Result <%= result%></p>
            <%
                }
            %>
        </div>
    </body>
</html>

