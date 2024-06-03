package controller;

import constant.ServletController;
import constant.ActionValue;
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
                case ActionValue.LOGIN:
                    directTo = ServletController.LOGIN_CONTROLLER;
                    break;
                case ActionValue.REGISTER:
                    directTo = ServletController.REGISTER_CONTROLLER;
                    break;
                case ActionValue.SEARCH:
                    directTo = ServletController.SEARCH_CONTROLLER;
                    break;
                case ActionValue.UPDATE:
                    directTo = ServletController.UPDATE_CONTROLLER;
                    break;
                case ActionValue.DELETE:
                    directTo = ServletController.DELETE_CONTROLLER;
                    break;
                case ActionValue.LOGOUT:
                    directTo = ServletController.LOGOUT_CONTROLLER;
                    break;
                // Case for staff: Insert, Update, Delete, Search
                case ActionValue.SEARCH_PRODUCT_STAFF:
                    directTo = ServletController.SEARCH_PRODUCT_STAFF_CONTROLLER;
                    break;
                case ActionValue.INSERT_PRODUCT_STAFF:
                    directTo = ServletController.INSERT_PRODUCT_STAFF_CONTROLLER;
                    break;
                case ActionValue.UPDATE_PRODUCT_STAFF:
                    directTo = ServletController.UPDATE_PRODUCT_STAFF_CONTROLLER;
                    break;
                case ActionValue.DELETE_PRODUCT_STAFF:
                    directTo = ServletController.DELETE_PRODUCT_STAFF_CONTROLLER;
                    break;
                // Case for user: Search, Add to cart, View cart, Delete from cart
                case ActionValue.SEARCH_PRODUCT_USER:
                    directTo = ServletController.SEARCH_PRODUCT_USER_CONTROLLER;
                    break;
                case ActionValue.ADD_TO_CART:
                    directTo = ServletController.ADD_TO_CART_CONTROLLER;
                    break;
                case ActionValue.VIEW_CART:
                    directTo = ServletController.VIEW_CART_CONTROLLER;
                    break;
                case ActionValue.REMOVE_FROM_CART:
                    directTo = ServletController.REMOVE_PRODUCT_CART_CONTROLLER;
                    break;
                case "DeleteFromWishList" :
                    directTo = "RemoveWishListController";
                    break;
                case ActionValue.CHANGE_CART:
                    directTo = ServletController.CHANGE_PRODUCT_CART_CONTROLLER;
                    break;
                case ActionValue.SUBMIT_ORDER:
                    directTo = ServletController.SUBMIT_ORDER_CONTROLLER;
                    break;
                case ActionValue.SAVE_ITEM:
                    directTo = ServletController.ADD_TO_WISH_LIST_CONTROLLER;
                    break;
                default:
                    request.setAttribute("ERROR", "Your action not supported");
                    break;
            }

        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            System.out.println("MainController will direct to: " + directTo);
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
