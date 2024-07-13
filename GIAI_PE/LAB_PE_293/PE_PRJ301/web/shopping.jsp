
<%@page import="java.util.ArrayList"%>
<%@page import="pe.prj301.shopping.Products"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1>Welcome to HD's shop</h1>
        <!--your code here-->

        <form action="MainController" method="POST">
            <button type="submit" name="action" value="SearchAll">Search All</button>
            <button type="submit" name="action" value="ViewCart">View Cart</button>
        </form>

        <%
            List<Products> searchAll = (ArrayList<Products>) request.getAttribute("searchAll");
//            request.setAttribute("data", searchAll);
            if (searchAll != null) {


        %>

        <table border=1>
            <thead>
                <tr>
                    <td>No</td>
                    <td>ProductID</td>
                    <td>ProductName</td>
                    <td>ProductDescription</td>
                    <td>Price</td>
                    <td>Add</td>
                </tr>
            </thead>
            <tbody>
                <%                    int i = 1;
                    for (Products p : searchAll) {
                %>
                <tr>
                    <td><%= i++%></td>
                    <td><%= p.getProductID()%></td>
                    <td><%= p.getProductName()%></td>
                    <td><%= p.getDescription()%></td>
                    <td><%= p.getPrice()%></td>
            <form action="MainController" method="POST">
                <td>
                    <input type="hidden" name="id" value="<%= p.getProductID()%>" />
                    <button type="submit" name="action" value="Add">Add</button>
                </td>
            </form>
        </tr>
        <%}
        %>
    </tbody>

</table>



<%        } else {
%>
<p>No product found</p>
<%
    }
%>

<%
    Products addedProduct = (Products) request.getAttribute("addedProduct");

    if (addedProduct != null) {
%>
<p> Added <%= addedProduct.getProductName() %> - 1 Cái - <%= addedProduct.getPrice() %> </p>
    <%
        }
    %>

</body>
</html>
