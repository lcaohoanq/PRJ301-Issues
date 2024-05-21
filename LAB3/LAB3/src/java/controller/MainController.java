package controller;

import constant.ServletController;
import constant.ServletName;
import java.io.IOException;
import java.io.PrintWriter;
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
                case ServletName.LOGIN:
                    directTo = ServletController.LOGIN_CONTROLLER;
                    break;
                case ServletName.REGISTER:
                    directTo = ServletController.REGISTER_CONTROLLER;
                    break;
                case ServletName.SEARCH:
                    directTo = ServletController.SEARCH_CONTROLLER;
                    break;
                case ServletName.UPDATE:
                    directTo = ServletController.UPDATE_CONTROLLER;
                    break;
                case ServletName.DELETE:
                    directTo = ServletController.DELETE_CONTROLLER;
                    break;
                case ServletName.LOGOUT:
                    directTo = ServletController.LOGOUT_CONTROLLER;
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
