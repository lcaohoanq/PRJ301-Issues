/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 *
 * @author lcaohoanq
 */
@WebServlet(name = "AppointmentServlet", urlPatterns = {"/AppointmentServlet"})
public class AppointmentServlet extends HttpServlet {

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createAppointment(request, response);
                break;
            case "edit":
                editAppointment(request, response);
                break;
            case "cancel":
                cancelAppointment(request, response);
                break;
        }
    }

    private void createAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        String appointmentDate = request.getParameter("appointmentDate");
        String appointmentTime = request.getParameter("appointmentTime");
        String purpose = request.getParameter("purpose");

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Appointments (userId, appointmentDate, appointmentTime, purpose, status) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, userId);
            stmt.setString(2, appointmentDate);
            stmt.setString(3, appointmentTime);
            stmt.setString(4, purpose);
            stmt.setString(5, "Scheduled");
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            response.sendRedirect("dashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String appointmentDate = request.getParameter("appointmentDate");
        String appointmentTime = request.getParameter("appointmentTime");
        String purpose = request.getParameter("purpose");

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Appointments SET appointmentDate = ?, appointmentTime = ?, purpose = ? WHERE id = ?");
            stmt.setString(1, appointmentDate);
            stmt.setString(2, appointmentTime);
            stmt.setString(3, purpose);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            response.sendRedirect("viewAppointments.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cancelAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Appointments SET status = 'Cancelled' WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            response.sendRedirect("viewAppointments.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("reminder".equals(action)) {
            sendReminders(request, response);
        }
    }

    private void sendReminders(HttpServletRequest request, HttpServletResponse response) {
        // Implement the reminder functionality (e.g., using JavaMail API for emails)
    }

}
