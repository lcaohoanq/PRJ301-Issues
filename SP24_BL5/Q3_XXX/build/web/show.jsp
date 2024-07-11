<%@page import="dto.BoatDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="show" method="GET">
                <label for="item"> Choose an option to filter: </label>
                <select name="item" id="list" onchange="this.form.submit()">
                    <option value="second">text2</option>
                    <option value="allDeparturePlaces">All Departure places</option>
                    <option value="third">text3</option>
                </select>
            </form>


            <!--            <form action="filter" method="GET">
                            <label for="item"> Choose an option to filter: </label>
                            <select name="item" id="list" onchange="this.form.submit()">
                                <option value="All-Departure-places">All Departure places</option>
                                <option value="second">text2</option>
                                <option value="third">text3</option>
                            </select>
                        </form>-->

        </div>

        <%
            List<BoatDTO> allBoat = (ArrayList<BoatDTO>) request.getAttribute("allDepaturePlaces");

            if (allBoat != null && !allBoat.isEmpty()) {
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>BoatID</th>
                    <th>BoatName</th>
                    <th>Seat</th>
                    <th>Booked</th>
                    <th>DepartPlace Name</th>
                    <th>Ticket Type</th>
                    <th>Is full?</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (BoatDTO boat : allBoat) {
                %>
                <tr>
                    <td><%= boat.getBoatID()%></td>
                    <td><%= boat.getBoatName()%></td>
                    <td><%= boat.getSeat()%></td>
                    <td><%= boat.getBooked()%></td>
                    <td><%= boat.getDepartPlaceName()%></td>
                    <td><%= boat.getTicketName()%></td>
                    <td><%= boat.getSeat() == boat.getBooked()? "X" : "" %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <%
        } else {
        %> 
            <p style="color: red">Error!!!!!</p>
        <%
            }
        %>
    </body>
</html>
