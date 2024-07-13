/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String REGISTER = "Register";
    private static final String LOGIN = "Login";
    private static final String LOGOUT = "Logout";
    private static final String ADD = "AddComestic";
    private static final String SEARCH = "ListComestic";
    private static final String DELETE = "DeleteComestic";
    private static final String UPDATE = "UpdateComestic";
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  // Set request encoding to UTF-8
        response.setContentType("text/html;charset=UTF-8"); // Set response content type and encoding
        String url = ERROR;
        String action = request.getParameter("action");
        try {
            if("Register".equals(action)){
               url = REGISTER;
            }
            else if("Login".equals(action)){
               url = LOGIN;
            }
            else if("Logout".equals(action)){
               url = LOGOUT;
            } 
            else if("ShowAdd".equals(action)){
                url = ADD;
            } 
            else if("Add".equals(action)){
               url = ADD;
            }
            else if("Search".equals(action)){
               url = SEARCH;
            }
            else if("Delete".equals(action)){
               url = DELETE;
            }
            else if("Update".equals(action)){
               url = UPDATE;
            }
        } catch (Exception e) {
            log("Error at MainController " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
