<%@page import="model.MobileDTO"%>
<%@page import="model.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1>Your cart</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>SKU</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Change</th>
                    <th>Remove item(s)</th>
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
                        <input type="text" name="id" value="<%= p.getMobileId()%>" readonly=""/>
                    </td>
                    <td><%= p.getMobileName()%></td>
                    <td>
                        <input type="number" min="1" name="quantity" value="<%= p.getQuantity()%>" required=""/>
                    </td>
                    <td><%= p.getPrice()%></td>
                    <td><%= p.getPrice() * p.getQuantity()%></td>
                    <td>
                        <input type="submit" 
                               placeholder="Change"
                               aria-label="Change" 
                               name="action" 
                               value="DeleteFromCart"/>
                    </td>
                    <td>
                        <input 
                            type="submit" 
                            placeholder="Remove"
                            aria-label="Remove" 
                            name="action" 
                            value="ChangeProductQuantity"/>
                    </td>
                </tr>
            </form>

            <%
                }
            %>

        </tbody>
    </table>

    <h1>Total: <%= total%></h1>      
    <%
        }
    %>
    </br>
    <a href="./user.jsp">Click here to continue shopping</a>
</body>
</html>
