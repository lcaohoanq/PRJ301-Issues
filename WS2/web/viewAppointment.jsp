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
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointments WHERE userId = ?");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
        %>
        <h2>All Appointments</h2>
        <table border="1">
            <tr>
                <th>Date</th>
                <th>Time</th>
                <th>Purpose</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <%
                while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getDate("appointmentDate")%></td>
                <td><%= rs.getTime("appointmentTime")%></td>
                <td><%= rs.getString("purpose")%></td>
                <td><%= rs.getString("status")%></td>
                <td>
                    <a href="editAppointment.jsp?id=<%= rs.getInt("id")%>">Edit</a> |
                    <a href="AppointmentServlet?action=cancel&id=<%= rs.getInt("id")%>">Cancel</a>
                </td>
            </tr>
            <%
                }
                stmt.close();
                conn.close();
            %>
        </table>
        <a href="dashboard.jsp">Back to Dashboard</a>
    </body>
</html>
