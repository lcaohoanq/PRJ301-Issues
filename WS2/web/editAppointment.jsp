<%@page import="utils.DBUtils"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./style.css"/>
    </head>
    <body>
        <%
            if (session == null || session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }

            int id = Integer.parseInt(request.getParameter("id"));
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointments WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
        %>
        <form action="AppointmentServlet?action=edit" method="post">
            <input type="hidden" name="id" value="<%= id%>">
            Date: <input type="date" name="appointmentDate" value="<%= rs.getDate("appointmentDate")%>" required><br>
            Time: <input type="time" name="appointmentTime" value="<%= rs.getTime("appointmentTime")%>" required><br>
            Purpose: <input type="text" name="purpose" value="<%= rs.getString("purpose")%>" required><br>
            <input class="btn btn-primary" type="submit" value="Save Changes">
        </form>
        <%
            }
            stmt.close();
            conn.close();
        %>
        <a class="text text-danger" href="viewAppointments.jsp">Back to Appointments</a>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
