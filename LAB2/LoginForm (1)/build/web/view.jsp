<%-- 
    Document   : view
    Created on : May 16, 2024, 5:01:13 PM
    Author     : ADMIN
--%>

<%@page import="sample.book.BookDTO"%>
<%@page import="sample.book.CartDTO"%>
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
            CartDTO cart = (CartDTO) session.getAttribute("CART");
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
                    for (BookDTO b : cart.getCart().values()) {
                        total += b.getPrice() * b.getQuantity();
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td> 
                        <input type="text" name="id" value="<%= b.getId()%>" readonly=""/>
                    </td>
                    <td><%= b.getName()%></td>
                    <td><%= b.getDescription()%></td>
                    <td><%= b.getPrice()%>$</td>
                    <td>
                        <input type="number" min="1" name="quantity" value="<%= b.getQuantity()%>" required=""/>
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
        }
    %>
    </br>
    <form action="MainController" method="POST">
        <input type="submit" name="action" value="Addmore"/>
    </form>
    
    </body>
</html>
