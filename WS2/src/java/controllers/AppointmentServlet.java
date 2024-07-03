/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DAO.AppointmentDAO;
import DAO.UserDAO;
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
import utils.EmailUtils;

/**
 *
 * @author lcaohoanq
 */
@WebServlet(name = "AppointmentServlet", urlPatterns = {"/AppointmentServlet"})
public class AppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        System.out.println("Action: " + action);

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
            case "open":
                openAppointment(request, response);
                break;
            case "completed":
                completedAppointment(request, response);
                break;
            case "unCompleted":
                // uncompleted ~ back to scheduled status
                openAppointment(request, response);
                break;
            case "reminder":
                sendReminders(request, response);
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
            new AppointmentDAO().addAppointment(userId, appointmentDate, appointmentTime, purpose);
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
            new AppointmentDAO().editAppointment(id, appointmentDate, appointmentTime, purpose);
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            new AppointmentDAO().openAppointment(id);
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cancelAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("In cancel appointment");
        try {
            new AppointmentDAO().cancelAppointment(id);
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void completedAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            new AppointmentDAO().completedAppointment(id);
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendReminders(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        try {
            EmailUtils handleEmail = new EmailUtils();
            UserDAO userDAO = new UserDAO();
            AppointmentDAO apDAO = new AppointmentDAO();
            String email = userDAO.getEmail(userId);

            String sub = "Reminder Notification";
            String msg = handleEmail.messageNewOrder(userDAO.getUserName(userId), apDAO.getDateAppointment(id).toString(), apDAO.getTimeAppointment(id).toString(), apDAO.getPurpose(id));
            handleEmail.sendEmail(sub, msg, email);
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
