<%@page import="model.MobileDTO"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@page
    import="model.UserDTO"%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Staff Page</title>
            <link rel="icon" type="image/png" href="./resources/favicon.ico" />
            <link
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous"
                />
            <link rel="stylesheet" href="./style/staff.css">
        </head>
        <body>
            <% UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if (loginUser == null || !(loginUser.getRoleID() == 2)) {
                    response.sendRedirect("login.jsp");
                    return;
                }%>
            <!-- <div class="container">
              <nav>
                <ul>
                  <li><%= loginUser.getUserID()%></li>
                  <li><%= loginUser.getName()%></li>
                  <li><%= loginUser.getRoleID()%></li>
                  <li><%= loginUser.getPassword()%></li>
                </ul>
              </nav>
            </div> -->
            <header>
                <nav class="navbar bg-body-tertiary">
                    <div class="container-fluid">
                        <form
                            class="d-flex flex-row justify-content-between align-items-center"
                            role="search"
                            method="GET"
                            action="MainController"
                        >
                            <div class="col-12">
                                <input
                                    class="form-control me-2"
                                    type="search"
                                    placeholder="Search"
                                    aria-label="Search"
                                    name="searchQuery"
                                />
                            </div>
                            <button class="btn btn-outline-success ms-2" type="submit" name="action" value="SearchProductStaff">
                                Search
                            </button>
                            <a class="navbar-brand ms-5">UserID:<%= loginUser.getUserID()%></a>
                            <button class="btn btn-outline-warning me-5" type="submit" name="action" value="InsertProductStaff">
                                Insert
                            </button>
                            <button class="btn btn-outline-danger" type="submit" name="action" value="Logout">
                                Logout
                            </button>
                        </form>

                    </div>
                </nav>
            </header>

            <!-- receive the list of mobile -->
            <%
                List<MobileDTO> mobilesList = (List) request.getAttribute("LIST_MOBILE");
                if (mobilesList != null) {
                    if (mobilesList.size() > 0) {
            %>

            <main>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">No</th>
                            <th scope="col">Id</th>
                            <th scope="col">Name</th>
                            <th scope="col-md-6">Price</th>
                            <th scope="col">Description</th>
                            <th scope="col">Release</th>
                            <th scope="col">Quantity available</th>
                            <th scope="col">Sale</th>
                            <th scope="col">Update</th>
                            <th scope="col">Delete</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int count = 1;
                            for (MobileDTO mobile : mobilesList) {
                        %>

                        <tr>
                            <th scope="row"><%= count++%></th>
                            <td><%= mobile.getMobileId()%></td>
                            <td><%= mobile.getMobileName()%></td>
                            <td>
                                <input class="text-primary" value="<%= mobile.getPrice()%>" />
                            </td>
                            <td>
                                <textarea><%= mobile.getDescription()%></textarea>
                            </td>
                            <td><%= mobile.getYearOfProduction()%></td>
                            <td>
                                <input value="<%= mobile.getQuantity()%>"/>
                            </td>
                            <c:set var="notSale" value="<%= mobile.getNotSale()%>" />
                            <td>
                                <c:choose>
                                    <c:when test="${notSale == 0}">
                                        <input value="No"/>
                                    </c:when>
                                    <c:when test="${notSale == 1}">
                                        <input value="Yes"/>
                                    </c:when>
                                    <c:otherwise>
                                        Unknown
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <form action="MainController" method="GET">
                                <td>
                                    <button id="update-btn" class="btn btn-outline-primary" type="submit" name="action" value="UpdateProductStaff">Update</button>
                                </td>
                                <td>
                                    <button id="delete-btn" class="btn btn-outline-danger" type="submit" name="action" value="DeleteProductStaff">Delete</button>
                                </td>
                            </form>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>

                <%
                        }
                    }
                %>
            </main>

            <!-- Error message -->
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
            <script>
                [document.getElementById('update-btn'), document.getElementById('delete-btn')].forEach(button => {
                    button.addEventListener('click', (e) => {
                        const confirm = window.confirm('Are you sure?');
                        if (!confirm) {
                            e.preventDefault();
                        }
                    });
                });
            </script>
        </body>
    </html>
