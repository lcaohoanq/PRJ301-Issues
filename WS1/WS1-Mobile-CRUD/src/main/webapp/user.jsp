<%@ page import="model.MobileDTO" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.UserDTO" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>User Page</title>
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
            if (loginUser == null || loginUser.getRoleID() != 0) {
                response.sendRedirect("LoginController");
                return;
            }
        %>

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
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="searchQuery" />
                        </div>
                        <button class="btn btn-outline-success ms-2" name="action" value="SearchProductUser">Search</button>
                        <a class="navbar-brand ms-5">ID: <%= loginUser.getUserID()%></a>
                        <button class="btn btn-outline-danger" name="action" value="Logout">Logout</button>
                    </form>
                </div>
            </nav>
        </header>

        <main>
            <%
                List<MobileDTO> mobilesList = (List<MobileDTO>) request.getAttribute("LIST_MOBILE");
                if (mobilesList != null && !mobilesList.isEmpty()) {
            %>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Image</th>
                        <th scope="col">Price</th>
                        <th scope="col">Description</th>
                        <th scope="col">Release</th>
                        <th scope="col">Quantity available</th>
                        <th scope="col">Sale</th>
                        <th scope="col">Add to cart</th>
                        <th scope="col">Wishlist</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        for (MobileDTO mobile : mobilesList) {
                    %>
                <form action="MainController" method="POST">
                    <tr>
                        <th scope="row"><%= count++%></th>
                        <td>
                            <%= mobile.getMobileId()%>
                            <input type="hidden" name="mobileId" value="<%= mobile.getMobileId()%>" />
                        </td>
                        <td>
                            <%= mobile.getMobileName()%>
                            <input type="hidden" name="mobileName" value="<%= mobile.getMobileName()%>" />
                        </td>
                        <td>
                            <img src="<%= mobile.getUrl() %>" width="200" height="100" alt="phone"/>
                        </td>
                        <td class="text-primary">
                            <%= mobile.getPrice()%>
                            <input type="hidden" name="mobilePrice" value="<%= mobile.getPrice()%>" />
                        </td>
                        <td>
                            <%= mobile.getDescription()%>
                            <input type="hidden" name="mobileDescription" value="<%= mobile.getDescription()%>" />
                        </td>
                        <td>
                            <%= mobile.getYearOfProduction()%>
                            <input type="hidden" name="mobileYear" value="<%= mobile.getYearOfProduction()%>" />
                        </td>
                        <td>
                            <%= mobile.getQuantity()%>
                            <input type="hidden" name="mobileQuantity" value="<%= mobile.getQuantity()%>" />
                        </td>
                        <c:set var="notSale" value="<%= mobile.getNotSale()%>" />
                        <td>
                            <c:choose>
                                <c:when test="${notSale == 0}">
                                    No
                                </c:when>
                                <c:when test="${notSale == 1}">
                                    Yes
                                </c:when>
                                <c:otherwise>
                                    Unknown
                                </c:otherwise>
                            </c:choose>
                            <input type="hidden" name="notSale" value="<%= mobile.getNotSale()%>" />
                        </td>
                        <td>
                            <button id="addToCart-btn" class="btn btn-outline-primary" type="submit" name="action" value="AddToCart">Add to cart</button>
                        </td>
                        <td>
                            <button id="<%= count--%>" class="btn btn-outline-danger addToWishList" type="submit" name="action" value="SaveItem">❤️</button>
                        </td>
                    </tr>
                </form>
                <%
                    }
                %>
                </tbody>
            </table>
            <%
            } else {
            %>
            <p>No products found.</p>
            <%
                }
            %>
        </main>

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

        <div class="d-flex justify-content-end">
            <div class="d-flex flex-row justify-content-end align-items-center me-3">
                <a class="btn btn-primary" href="ViewCartController">Show your cart</a>
            </div>

            <div class="d-flex flex-row justify-content-end align-items-center me-3">
                <a class="btn btn-danger" href="ViewWishListController">Show Wishlist</a><br><br>
            </div>
        </div>

        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <h3 class="text ms-2">
            <%= message%>
        </h3>
        <!--
                <script>
                    document.addEventListener("DOMContentLoaded", function () {
                        document.querySelectorAll("button[type='button'][value='SaveItem']").forEach((btn) => {
                            btn.addEventListener("click", function (e) {
                                e.preventDefault();
                                console.log(`button: ${e.target.id}`);
                                btn.classList.toggle('btn-outline-danger');
                                btn.classList.toggle('btn-danger');
                            });
                        });
                    });
                </script>
        -->
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
