<%@page import="utils.DBUtils"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }

            int userId = (int) session.getAttribute("userId");
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointments WHERE userId = ? AND status = 'Scheduled'");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
        %>
        <h2>Dashboard</h2>
        <p>Welcome, <%= session.getAttribute("username")%></p>
        <a href="UserServlet?action=logout">Logout</a>

        <h3>Upcoming Appointments</h3>
        <table border="1">
            <tr>
                <th>Date</th>
                <th>Time</th>
                <th>Purpose</th>
                <th>Status</th>
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

        <a href="createAppointment.jsp">Create New Appointment</a>
        <a href="viewAppointments.jsp">View All Appointments</a>
        <a href="appointmentHistory.jsp">View Appointment History</a>
    </body>
</html>
