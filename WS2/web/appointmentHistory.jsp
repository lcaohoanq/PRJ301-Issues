<%@page import="utils.DBUtils"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
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
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointments WHERE userId = ? AND status = 'Completed'");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
        %>
        <h2 class="text-center">Appointment History</h2>
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
        <a class="btn btn-primary" href="dashboard.jsp">Back to Dashboard</a>
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
