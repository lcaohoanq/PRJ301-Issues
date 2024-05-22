<%@page import="model.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.UserDTO"%>
<%@page import="model.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="icon" type="image/png" href="./resources/favicon.ico" />
        <link rel="stylesheet" href="./style/util/reset.css" />
        <link rel="stylesheet" href="./style/component/admin/admin.css" />
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <div class="greeting">
            <p>Welcome</p>
            <h1> Admin: <%= loginUser.getName()%></h1>
        </div>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <form action="MainController" id="search-form">
            Search<input type="text" name="search" value="<%= search%>"/>
            <input type="submit" name="action" value="Search"/>

        </form>
        <%
            List<UserDTO> listUser = (List) request.getAttribute("LIST_USER");
            if (listUser != null) {
                if (listUser.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th id="no">No</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : listUser) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td id="no"><%= count++%></td>
                    <td >
                        <input class="custom-input-common" id=" custom-input" type="text" name="userID" value="<%= user.getUserID()%>"/>
                    </td>
                    <td>
                        <input class="custom-input-common" id=" custom-input" type="text" name="name" value="<%= user.getName()%>"/>
                    </td>
                    <td>
                        <input class="custom-input-common" id="custom-input-role" type="text" name="roleID" value="<%= user.getRoleID()%>" readonly/>
                    </td>
                    <td class="center-element"><%= user.getPassword()%></td>
                    <!--detele o day ne-->
                    <td>
                        <a id="delete-btn" href="MainController?userID=<%= user.getUserID()%>&action=Delete&search=<%= search%>">Delete</a>
                    </td>
                    <!--update i day ne-->  
                    <td>
                        <input class="center-element" id="update-btn" type="submit" name="action" value="Update"/>
                        <input type="hidden" name="search" value="<%= search%>"/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>

        </tbody>
    </table>
    <%
            }
        }
    %>
    
    <%
        String msg = (String) request.getAttribute("ERROR");
        if (msg != null) {
    %>
    <script>
        alert('<%= msg%>');
    </script>
    <%
        }
    %>
</body>
</html>
