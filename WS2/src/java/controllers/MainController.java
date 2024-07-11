package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String directTo = "";
        try {
            switch (request.getParameter("action")) {
                // login, register
                case "viewLogin":
                    directTo = "UserServlet?action=viewLogin";
                    break;
                case "submitLogin":
                    directTo = "UserServlet?action=submitLogin";
                    break;
                case "viewRegister":
                    directTo = "UserServlet?action=viewRegister";
                    break;
                case "submitRegister":
                    directTo = "UserServlet?action=submitRegister";
                    break;
                case "submitLogout":
                    directTo = "UserServlet?action=submitLogout";
                    break;
                // appointment
                case "createNewPrompt":
                    directTo = "AppointmentServlet?action=createNewPrompt";
                    break;
                case "createNew":
                    directTo = "AppointmentServlet?action=createNew";
                    break;
                case "viewAll":
                    directTo = "AppointmentServlet?action=viewAll";
                    break;
                case "viewHistory":
                    directTo = "AppointmentServlet?action=viewHistory";
                    break;
                case "editAppointment":
                    directTo = "AppointmentServlet?action=editAppointment";
                    break;
                case "deleteAppointment":
                    directTo = "AppointmentServlet?action=deleteAppointment";
                    break;
                case "openAppointment":
                    directTo = "AppointmentServlet?action=openAppointment";
                    break;
                case "completedAppointment":
                    directTo = "AppointmentServlet?action=completedAppointment";
                    break;
                case "unCompletedAppointment":
                    directTo = "AppointmentServlet?action=unCompletedAppointment";
                    break;
                case "cancelAppointment":
                    directTo = "AppointmentServlet?action=cancelAppointment";
                    break;
                case "sendReminder":
                    directTo = "AppointmentServlet?action=sendReminder";
                    break;
                case "viewDashboard":
                    directTo = "AppointmentServlet?action=viewDashboard";
                    break;
                default:
                    request.setAttribute("ERROR", "Your action not supported");
                    break;
            }

        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(directTo).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
