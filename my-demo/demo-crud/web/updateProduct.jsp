<%@page import="dao.ProductDAO"%>
<%@page import="models.ProductDTO"%>
<%@page import="utils.DBUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update page</h1>
        <%
            ProductDTO id = (ProductDTO) request.getAttribute("product");
            ProductDTO product = new ProductDAO().load(id.getProductID());
            if(product != null) {
        %>
        <form action="main" method="POST">
            <input type="hidden" name="productId" value="<%= product.getProductID() %>">

            <div>
                <label for="changeDate">Name</label>
                <input id="changeDate" type="text" name="productName" value="<%= product.getProductName()%>" required><br>
            </div>
            <div >
                <label for="changeTime" >Description</label>
                <input  id="changeTime" type="text" name="productDescription" value="<%= product.getDescription()%>" required><br>
            </div>
            <div >
                <label for="changePurpose" >Price</label>
                <input  id="changePurpose" type="text" name="productPrice" value="<%= product.getPrice()%>" required><br>
            </div>
            <div >
                <label for="changePurpose" >Status</label>
                <input  id="changePurpose" type="text" name="productStatus" value="<%= product.getStatus()%>" required><br>
            </div>

            <button type="submit" name="action" value="saveChangeUpdateProduct">Save Changes</button>
            <a href="product.jsp">Back to view</a>
        </form>
        <%
            }
        %>
    </body>
</html>
