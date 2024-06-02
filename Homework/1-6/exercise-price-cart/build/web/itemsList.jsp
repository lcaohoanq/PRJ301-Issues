<%@page import="sample.product.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="sample.product.ProductDTO"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items List Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            ProductDAO dao = new ProductDAO();
            List<ProductDTO> listProduct = null;
            String noResults = (String) request.getAttribute("NO_RESULTS");

            if (request.getAttribute("LIST_PRODUCT") != null) {
                listProduct = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            } else {
                listProduct = dao.getAllProducts();
            }
        %>
        <h1>Welcome <%= loginUser.getFullName()%></h1>


        <%
            if (request.getAttribute("ERROR") != null) {
        %>
        <script>
            alert("${requestScope.ERROR}");
        </script >
         <%
                }
         %>


        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <%            String fromPrice = request.getParameter("fromPrice");
            String toPrice = request.getParameter("toPrice");
            if (fromPrice == null) {
                fromPrice = "";
            }
            if (toPrice == null) {
                toPrice = "";
            }
        %>
        <form action="AdminSearchController" method="POST">
            From Price: <input type="text" name="fromPrice" value="<%= fromPrice%>"/>
            To Price: <input type="text" name="toPrice" value="<%= toPrice%>"/>
            <input type="submit" value="Search"/>
        </form>

        <%
            String brand = request.getParameter("brand");
            if (brand == null) {
                brand = "";
            }
        %>

        <form style="margin-top: 10px;" action="SearchBrandController" method="POST">
            Which Brand: <input type="text" name="brand" value="<%= brand%>"/>
            <input type="submit" value="Search"/>
        </form>

        <h2>Search Results</h2>
        <% if (noResults != null) {%>
        <p><%= noResults%></p>
        <% } else if (listProduct != null && !listProduct.isEmpty()) { %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Brand</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (ProductDTO product : listProduct) {
                        int subtotal = product.getPrice() * product.getQuantity();
                %>
                <tr>
            <form action="MainController" method="post">
                <td><%= ++count%></td>
                <td><%= product.getId()%></td>
                <td>
                    <input type="text" name="brand" value="<%= product.getBrand()%>" required=""/>
                </td>
                <td>
                    <input type="text" name="name" value="<%= product.getName()%>" required=""/>
                </td>
                <td>
                    <input type="text"  name="price" value="<%=  product.getPrice()%>" required="" />
                </td>
                <td>
                    <input type="number" name="quantity" value="<%= product.getQuantity()%>" required="" />
                </td>
                <td><%= subtotal%></td>
                <td>
                    <input type="hidden" name="fromPrice" value="<%= fromPrice%>"/>
                    <input type="hidden" name="toPrice" value="<%= toPrice%>" />
                    <input type="hidden" name="productId" value="<%= product.getId()%>"/>
                    <input type="submit" name="action" value="Remove"/>
                    <input type="submit" name="action" value="Update"/>
                </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <% } else { %>
      <p>No products found.</p>
    <% }%>

    <h3>Add New Items</h3>
    <form action="AddController" method="post">
        ID: <input type="text" name="id"><br>
        Brand: <input type="text" name="brand"><br>
        Name: <input type="text" name="name"><br>
        Price: <input type="text" name="price"><br>
        Quantity: <input type="text" name="quantity"><br>
        <input type="submit" value="Add More">
    </form>

    <%
        String message = (String) request.getAttribute("MESSAGE");
        if (message == null) {
            message = "";
        }
    %>
    <div>
        <%= message%>
    </div>
</body>
</html>
