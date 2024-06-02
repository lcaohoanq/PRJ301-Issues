<%@page import="model.UserDTO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.MobileDTO"%>
<%@page import="model.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
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
            <h1 class="text-primary">Cart for user: 
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
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                if (cart != null) {
            %>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        double total = 0;
                        for (MobileDTO p : cart.getCart().values()) {
                            total += p.getPrice() * p.getQuantity();
                    %>
                <form action="MainController" method="POST">
                    <tr>
                        <td><%= count++%></td>
                        <td> 
                            <%= p.getMobileId()%>
                            <input type="hidden" name="id" value="<%= p.getMobileId()%>"/>
                        </td>
                        <td><%= p.getMobileName()%></td>
                        <td><%= p.getPrice()%></td>
                        <td>
                            <input type="number" min="1" name="quantity" value="<%= p.getQuantity()%>" readonly=""/>
                        </td>
                        <td><%= p.getPrice() * p.getQuantity()%></td>
                        <td>
                            <button id="changeCart-btn" class="btn btn-outline-primary" type="submit" name="action" value="ChangeCart">Change quantity</button>
                        </td>
                        <td>
                            <button id="deleteCart-btn" class="btn btn-outline-danger" type="submit" name="action" value="DeleteFromCart">Delete from cart</button>
                        </td>
                    </tr>
                </form>
                <%
                    }
                %>
                </tbody>
            </table>  
            <h1 style="text-align: right; margin: 1vw">
                Total: <%= total = Double.valueOf(new DecimalFormat("#.##").format(total))%> VNĐ
            </h1>   
            <%
                }
            %>
        </div>

        <%
            String msgQuantity = (String) request.getAttribute("MESSAGE_CHANGE_QUANTITY");

            if (msgQuantity != null) {
        %>
        <script>
             alert('<%= msgQuantity%>');
        </script>
        <%
            }
        %>
        <footer class="bg-light py-3">
            <div class="container text-center">
                <form action="SubmitOrderController" method="GET">
                    <button style="margin: 1vw; text-decoration: none;" class="d-flex flex-row justify-content-center align-items-center btn btn-success" 
                            type="submit"
                            name="action"
                            value="SubmitOrder"> 
                        Submit Order
                    </button>
                </form>
                <a style="margin: 1vw; text-decoration: none;" class="d-flex flex-row justify-content-center align-items-center btn btn-primary" href="http://localhost:8080/mobile-crud/UserController">Click here to continue shopping</a>
            </div>
        </footer>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
