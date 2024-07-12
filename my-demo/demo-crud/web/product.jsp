<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.ProductDAO" %>
<%@ page import="models.ProductDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <style>
            button{
                cursor: pointer;
            }
            button:hover{
                background: green;
                color: white;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h1>Product List</h1>
        <form method="POST" action="main">
            <div>
                <input type="search" placeholder="Enter name...." aria-label="Enter name...." name="searchQuery" />
                <button type="submit" name="action" value="searchProduct">Search</button>
            </div>
        </form>
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
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% if (productList != null) {
                        for (ProductDTO product : productList) {%>
                <tr>
            <form method="POST" action="main">
                <input type="hidden" name="productId" value="<%= product.getProductID()%>">
                <td><%= product.getProductID()%></td>
                <td><%= product.getProductName()%></td>
                <td><%= product.getDescription()%></td>
                <td><%= product.getPrice()%></td>
                <td><%= product.getStatus()%></td>
                <td>
                    <button type="submit" name="action" value="viewUpdate">Update</button>
                    <button type="submit" name="action" value="delete" onclick="return confirmDelete()">Delete</button>
                </td>
            </form>
        </tr>
        <% }
        } else { %>
        <tr>
            <td colspan="5">No products found.</td>
        </tr>
        <% }%>

        <form action="main" method="POST">
            <button type="submit" name="action" value="viewCreate">Create</button>
        </form>


    </tbody>
</table>

<script type="text/javascript">
    function confirmDelete() {
        return confirm("Are you sure you want to delete?");
    }
</script>
</body>
</html>
