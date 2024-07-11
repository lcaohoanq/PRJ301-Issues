<%-- 
    Document   : MyExam
    Created on : Jul 6, 2024, 11:12:01 AM
    Author     : lcaohoanq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            p{
                text-align: left;

            }
            .container{
                display: flex;
                gap: 10px;
                flex-direction: column;
                justify-content: center;
                align-items: left;
            }
        </style>
    </head>
    <body>
        <p>TRAIN INFORMATION</p>
        <form action="TrainBookServlet" method="POST">
            <div class="container">
                <div>
                    <p style="display: inline">Train code</p>
                    <input type="text" name="code"/>
                </div>
                <div>
                    <p style="display: inline">Train name</p>
                    <input type="text" name="name"/>
                </div>
                <div>
                    <p style="display: inline">Seat number</p>
                    <input type="text" name="seat"/>
                </div>
                <div>
                    <p style="display: inline">Booked</p>
                    <input type="text" name="book"/>
                </div>
                <div>
                    <input type="submit" value="BOOK"/>
                </div>
            </div>
        </form>

        <%
                        String errorLackOfData = (String) request.getAttribute("errorLackOfData");

                        if (errorLackOfData != null) {

        %> 
        <p style="color: red"><%= errorLackOfData%></p>

        <%
                        }
        %>

        <%
                        String errorBookGreaterThanSeat = (String) request.getAttribute("errorBookedGreaterThanSeat");
                        if (errorBookGreaterThanSeat != null) {

        %> 
        <p style="color: red"><%= errorBookGreaterThanSeat%></p>
        <%
                        }
        %>

        <%
                        String errorFull = (String) request.getAttribute("errorFull");
                        String errorNotFull = (String) request.getAttribute("errorNotFull");
                        String code = (String) request.getAttribute("code");
                        String name = (String) request.getAttribute("name");
                        String seat = (String) request.getAttribute("seat");
                        String book = (String) request.getAttribute("book");
                        if (errorFull != null) {

        %>  
        <div>
            <p>Information of booked train:</p>
            <p>Id: <%= code%></p>
            <p>Name: <%= name%></p>
            <p>Seat: <%= seat%></p>
            <p>Book: <%= book%></p>
            <p style="color: red">Is full?<%= errorFull%></p>
        </div>
        <%
                } else if(errorNotFull != null) {
        %>
        <div>
            <p>Information of booked train:</p>
            <p>Id: <%= code%></p>
            <p>Name: <%= name%></p>
            <p>Seat: <%= seat%></p>
            <p>Book: <%= book%></p>
            <p style="color: red">Is full?<%= errorNotFull%></p>
        </div>
        <%
                        }
        %>
    </body>
</html>
