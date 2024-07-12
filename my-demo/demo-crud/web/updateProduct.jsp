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
            String id = request.getParameter("productId");
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [tblProducts] WHERE productID = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
        %>
        <form action="main" method="POST">
            <input type="hidden" name="productId" value="<%= id%>">

            <div>
                <label for="changeDate">Name</label>
                <input id="changeDate" type="text" name="productName" value="<%= rs.getString("productName")%>" required><br>
            </div>
            <div >
                <label for="changeTime" >Description</label>
                <input  id="changeTime" type="text" name="productDescription" value="<%= rs.getString("description")%>" required><br>
            </div>
            <div >
                <label for="changePurpose" >Price</label>
                <input  id="changePurpose" type="text" name="productPrice" value="<%= rs.getFloat("price")%>" required><br>
            </div>
            <div >
                <label for="changePurpose" >Status</label>
                <input  id="changePurpose" type="text" name="productStatus" value="<%= rs.getInt("status")%>" required><br>
            </div>

            <button type="submit" name="action" value="saveChangeEditProduct">Save Changes</button>
            <a href="product.jsp">Back to view</a>
        </form>
        <%
            }
            stmt.close();
            conn.close();
        %>
    </body>
</html>
