<%@page import="java.util.ArrayList"%>
<%@page import="models.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>

        <style>
            body{
                display: flex;
                align-items: center;
                justify-content: center;
                min-height: 100vh;
                background-color: #f1f1f1;
            }
        </style>
    </head>
    <body>

        <%

            List<ProductDTO> demo = new ArrayList<>();
            demo.add(new ProductDTO("P001", "iPhone", "Dienthoai", 15, 1));
            demo.add(new ProductDTO("P002", "Nokie", "FPT", 10, 0));
            demo.add(new ProductDTO("P003", "Samsung", "Suka", 70, 1));

            List<ProductDTO> dataSearch = demo;
            request.setAttribute("dataSearch", dataSearch);

//            List<ProductDTO> dataSearch = (ArrayList<ProductDTO>) request.getAttribute("dataSearch");
            if (dataSearch == null) {

        %>
        <p>Nothing to show</p>
        <%            } else {
        %>
        <table  border="1">
            <thead>
                <tr>
                    <td>Product ID</td>
                    <td>Product Name</td>
                    <td>Description</td>
                    <td>Price</td>
                    <td>Status</td>
                </tr>
            </thead>
            <tbody>
                <%
                    for (ProductDTO p : dataSearch) {
                %>
                <tr>
                    <td><%= p.getProductID()%></td>
                    <td><%= p.getProductName()%></td>
                    <td><%= p.getDescription()%></td>
                    <td><%= p.getPrice()%></td>
                    <td><%= p.getStatus()%></td>
                </tr>
                <%
                    }
                %>

                <c:forEach var="p" items="${dataSearch}">
                    <tr>
                        <td>${p.getProductID()}</td>
                        <td>${p.getProductName()}</td>
                        <td>${p.getDescription()}</td>
                        <td>${p.getPrice()}</td>
                        <td>${p.getStatus()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <%
            }
        %>

    </body>
</html>
