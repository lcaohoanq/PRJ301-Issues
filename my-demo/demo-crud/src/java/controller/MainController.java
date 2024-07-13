package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    protected void processRequest(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        System.out.println("MainController action: " + action);
        String directTo = "";
        switch (action) {
            case "viewUpdate":
                directTo = "product?action=viewUpdate";
                break;
            case "saveChangeUpdateProduct":
                directTo = "product?action=saveChangeUpdateProduct";
                break;
            case "saveChangeCreateProduct":
                directTo = "product?action=saveChangeCreateProduct";
                break;
            case "viewCreate":
                directTo = "product?action=viewCreate";
                break;
            case "searchProduct":
                directTo = "product?action=searchProduct";
                break;
            case "create":
                directTo = "product?action=Create";
                break;
            case "delete":
                directTo = "product?action=delete";
                break;
            default:
                directTo = "./404.jsp";
                break;
        }
        request.getRequestDispatcher(directTo).forward(request, response);
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
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
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
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
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
    } // </editor-fold>
}
