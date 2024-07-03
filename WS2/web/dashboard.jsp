<%@page import="utils.DBUtils"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./style.css"/>
    </head>
    <body>

        <%
            if (session == null || session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }

            int userId = (int) session.getAttribute("userId");
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointments WHERE userId = ? AND status = 'Scheduled'");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
        %>

        <!-- Header -->
        <h2 class="mt-3 text-center">Dashboard</h2>

        <p class="text-center">Welcome, <%= session.getAttribute("username")%></p>

        <form method="POST" action="UserServlet">
            <button class="btn btn-danger mb-3 col-md-12"  name="action" value="logout">Logout</button>
        </form>

        <h3 class="text-center mb-3">Upcoming Appointments</h3>
        <table class="table" border="1">
            <tr>
                <th scope="col">Date</th>
                <th scope="col">Time</th>
                <th scope="col">Purpose</th>
                <th scope="col">Status</th>
            </tr>
            <%
                while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getDate("appointmentDate")%></td>
                <td><%= rs.getTime("appointmentTime")%></td>
                <td><%= rs.getString("purpose")%></td>
                <td><%= rs.getString("status")%></td>
            </tr>
            <%
                }
                stmt.close();
                conn.close();
            %>
        </table>

        <div class="row d-flex justify-content-center">
            <a class="col-md-3 btn btn-primary mt-3 me-3" href="createAppointment.jsp">Create New Appointment</a>
            <a class="col-md-3 btn btn-primary mt-3 me-3" href="viewAppointment.jsp">View All Appointments</a>
            <a class="col-md-3 btn btn-primary mt-3" href="appointmentHistory.jsp">View Appointment History</a>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

    </body>
</html>
