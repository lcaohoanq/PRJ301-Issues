<%@page import="model.UserDTO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.MobileDTO"%>
<%@page import="model.WishListDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
        <style>
            html, body {
                height: 100%;
                margin: 0;
                display: flex;
                flex-direction: column;
            }
            .content {
                flex: 1;
            }
            footer {
                flex-shrink: 0;
            }
        </style>
    </head>
    <body>

        <header class="text-center mb-3">
            <h1 class="text-primary">Wishlist User:
                <%
                    UserDTO user = (UserDTO) request.getAttribute("LOGIN_USER");
                    if (user != null) {
                %>
                <%= user.getUserID()%>
                <%
                    }
                %>
            </h1>
        </header>



        <div class="content">
            <%
                WishListDTO wishList = (WishListDTO) session.getAttribute("WISHLIST");
                if (wishList != null) {
            %>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col" class="text-primary">No</th>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        double total = 0;
                        for (MobileDTO p : wishList.getWishList().values()) {
                            total += p.getPrice() * p.getQuantity();
                    %>
                <form action="MainController" method="POST">
                    <tr>
                        <td class="text-primary"><%= count++%></td>
                        <td>
                            <%= p.getMobileId()%>
                            <input type="hidden" name="id" value="<%= p.getMobileId()%>"/>
                        </td>
                        <td><%= p.getMobileName()%></td>
                        <td><%= p.getPrice()%></td>
                        <td>
                            <button id="deleteWishList-btn" class="btn btn-outline-danger" type="submit" name="action" value="DeleteFromWishList">Delete from wish list</button>
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
            %>
        </div>
        </br>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
