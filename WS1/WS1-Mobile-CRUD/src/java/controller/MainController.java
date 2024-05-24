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

@WebServlet(name = "MainController", urlPatterns = { "/MainController" })
public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String directTo = "";
        System.out.println("Action: " + request.getParameter("action"));
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
                // Case for staff: Insert, Update, Delete, Search
                case ServletName.SEARCH_PRODUCT_STAFF:
                    directTo = ServletController.SEARCH_PRODUCT_STAFF_CONTROLLER;
                    break;
                case ServletName.INSERT_PRODUCT_STAFF:
                    directTo = ServletController.INSERT_PRODUCT_STAFF_CONTROLLER;
                    break;
                case ServletName.UPDATE_PRODUCT_STAFF:
                    directTo = ServletController.UPDATE_PRODUCT_STAFF_CONTROLLER;
                    break;
                case ServletName.DELETE_PRODUCT_STAFF:
                    directTo = ServletController.DELETE_PRODUCT_STAFF_CONTROLLER;
                    break;
                // Case for user: Search, Add to cart, View cart, Delete from cart
                case ServletName.SEARCH_PRODUCT_USER:
                    directTo = ServletController.SEARCH_PRODUCT_USER_CONTROLLER;
                    break;
                case ServletName.ADD_TO_CART:
                    directTo = ServletController.ADD_TO_CART_CONTROLLER;
                    break;
                case ServletName.VIEW_CART:
                    directTo = ServletController.VIEW_CART_CONTROLLER;
                    break;
                case ServletName.DELETE_FROM_CART:
                    directTo = ServletController.DELETE_FROM_CART_CONTROLLER;
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
