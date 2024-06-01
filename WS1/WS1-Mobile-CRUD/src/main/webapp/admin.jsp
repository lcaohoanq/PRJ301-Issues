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
        <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !(loginUser.getRoleID() == 1)) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <header>
            <nav class="navbar bg-body-tertiary">
              <div class="container-fluid d-flex flex-row-reverse">
                <form action="MainController" method="POST">
                    <input type="submit" name="action" value="Logout"/>
                </form>
                <a class="navbar-brand"> Admin: <%= loginUser.getName()%></a>
                <form
                  class="d-flex"
                  role="search"
                  method="GET"
                  action="MobileController"
                >
                  <input
                    class="form-control me-2"
                    type="search"
                    placeholder="Search"
                    aria-label="Search"
                    name="action"
                  />
                  <button class="btn btn-outline-success" type="submit">
                    Search
                  </button>
                </form>
              </div>
            </nav>
          </header>

        <form action="MainController" id="search-form" method="GET">
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
    <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"
  ></script>
</body>
</html>
