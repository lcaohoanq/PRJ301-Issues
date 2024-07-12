<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.ProductDAO" %>
<%@ page import="models.ProductDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
    </head>
    <body>
        <h1>Product List</h1>
        <%
            ProductDAO productDAO = new ProductDAO();
            List<ProductDTO> productList = null;
            try {
                productList = productDAO.getAllProduct();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <% if (productList != null) {
                    for (ProductDTO product : productList) { %>
                        <tr>
                            <td><%= product.getProductID() %></td>
                            <td><%= product.getProductName() %></td>
                            <td><%= product.getDescription() %></td>
                            <td><%= product.getPrice() %></td>
                            <td><%= product.getStatus() %></td>
                        </tr>
                    <% }
                } else { %>
                    <tr>
                        <td colspan="5">No products found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
