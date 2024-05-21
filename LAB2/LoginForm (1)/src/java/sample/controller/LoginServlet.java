/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.book.BookDAO;
import sample.book.BookDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author Luu Minh Quan
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/loginservlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR="login.jsp";
    private static final String FAIL="fail.jsp";
    private static final String PAGE="welcome.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;

        try {
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            UserDAO login = new UserDAO();
            UserDTO userd = login.checkLogin(user, pass);
            String ms = "";
            if (userd != null) {
                ms = "Welcome: " + userd.getFullName();
                request.setAttribute("success", ms);
                url=PAGE;
            } else {
                ms = "Invalid user or password!!!";
                request.setAttribute("fail", ms);
                url = FAIL;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        try {
            UserDAO login = new UserDAO();
            UserDTO userd = login.checkLogin(user, pass);
            String ms = "";
            if (userd != null) {
                BookDAO list = new BookDAO();
                request.setAttribute("list_book", list.getListBook());
                ms = "Welcome: " + userd.getFullName();
                request.setAttribute("success", ms);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else {
                ms = "Invalid user or password!!!";
                request.setAttribute("fail", ms);
                request.getRequestDispatcher("fail.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
