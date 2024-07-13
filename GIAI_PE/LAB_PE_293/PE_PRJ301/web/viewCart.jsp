<%@page import="pe.prj301.shopping.Products"%>
<%@page import="pe.prj301.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Cart:</h1>
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Book ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (Products b : cart.getCart().values()) {
                        total += b.getPrice() * b.getQuantity();
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td> 
                        <input type="text" name="id" value="<%= b.getProductID()%>" readonly=""/>
                    </td>
                    <td><%= b.getProductName()%></td>
                    <td><%= b.getDescription()%></td>
                    <td><%= b.getPrice()%>$</td>
                    <td>
                        <input type="number" min="1" name="quantity" value="<%= b.getQuantity()%>" required="" readonly=""/>
                    </td>                    
                    <td><%= b.getPrice() * b.getQuantity()%>$</td>
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                </tr>
            </form>

            <%
                }
            %>

        </tbody>
    </table>

    <h1>Total:<%= total%> $  </h1>      
    <%
        } else {
    %>
        Nothing in cart
    <%
        }
    %>
    
    </br>
    <form action="MainController" method="POST">
        <button type="submit" name="action" value="AddMore">Add more</button>
    </form>
    
    </body>
</html>
