<%@ page import="java.util.ArrayList"%>
<%@ page import="models.ProductDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSTL Example</title>
    </head>
    <body>
        <%
            // Creating a Date object to get the current date and time
            Date now = new Date();
            // Setting the current date and time as a request attribute
            request.setAttribute("currentTime", now);

            // Creating a list of ProductDTO objects for demonstration
            List<ProductDTO> demo = new ArrayList<>();
            demo.add(new ProductDTO("P001", "iPhone", "Dienthoai", 15, 1));
            demo.add(new ProductDTO("P002", "Nokie", "FPT", 10, 0));
            demo.add(new ProductDTO("P003", "Samsung", "Suka", 70, 1));

            // Setting the demo list as a request attribute
            List<ProductDTO> dataSearch = demo;
            request.setAttribute("dataSearch", dataSearch);
        %>

        <!-- Setting a variable using JSTL c:set tag -->
        <c:set var="greeting" value="Hello, JSTL!" />
        <!-- Displaying the value of the greeting variable using c:out tag -->
        <p><c:out value="${greeting}" /></p>

        <!-- Conditional logic using JSTL c:if tag -->
        <c:if test="${greeting == 'Hello, JSTL!'}">
            <p>Condition is true!</p>
        </c:if>

        <!-- Conditional logic using JSTL c:choose, c:when, and c:otherwise tags -->
        <c:choose>
            <c:when test="${greeting == 'Hello, JSTL!'}">
                <p>It's a greeting.</p>
            </c:when>
            <c:otherwise>
                <p>It's something else.</p>
            </c:otherwise>
        </c:choose>

        <!-- Creating a list of items using c:set tag -->
        <c:set var="items" value="${['Item 1', 'Item 2', 'Item 3']}" />
        <!-- Iterating over the list of items using c:forEach tag -->
        <c:forEach var="item" items="${items}">
            <p>${item}</p>
        </c:forEach>

        <!-- Formatting the current date and time using fmt:formatDate tag -->
        <fmt:formatDate value="${currentTime}" pattern="yyyy-MM-dd HH:mm:ss" var="formattedDate"/>
        <p>Formatted Date: <c:out value="${formattedDate}" /></p>

        <!-- Formatting a number as currency using fmt:formatNumber tag -->
        <fmt:formatNumber value="1234567.89" type="currency" var="formattedNumber"/>
        <p>Formatted Number: <c:out value="${formattedNumber}" /></p>

        <!-- Using JSTL functions to manipulate and analyze strings -->
        <c:set var="myString" value="Hello, JSTL!" />
        <p>Length of String: ${fn:length(myString)}</p>
        <p>Contains 'JSTL': ${fn:contains(myString, 'JSTL')}</p>

        <!-- Checking if the dataSearch list is null using JSP scriptlet -->
        <% if (dataSearch == null) { %>
            <p>Nothing to show</p>
        <% } else { %>
            <!-- Displaying the dataSearch list in a table -->
            <table border="1">
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
                    <!-- Iterating over the dataSearch list using JSTL c:forEach tag -->
                    <c:forEach var="p" items="${dataSearch}">
                        <tr>
                            <td>${p.productID}</td>
                            <td>${p.productName}</td>
                            <td>${p.description}</td>
                            <td>${p.price}</td>
                            <td>${p.status}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        <% } %>
    </body>
</html>
