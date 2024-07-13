/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.daos.ComesticDAO;
import pe.daos.UserDAO;
import pe.dtos.ComesticDTO;

/**
 *
 * @author leyen
 */
@WebServlet(name = "UpdateComestic", urlPatterns = {"/UpdateComestic"})
public class UpdateComestic extends HttpServlet {

    private final static String ERROR = "ListComestic";
    private final static String SUCCESS = "ListComestic";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  // Set request encoding to UTF-8
        response.setContentType("text/html;charset=UTF-8"); // Set response content type and encoding
        String url = ERROR;

        String userId = request.getParameter("userId");

        try {
            if (!new UserDAO().getRoleByID(userId).equals("AD")) {
                url = "./authentication.jsp";
            } else {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String price = request.getParameter("price");
                String size = request.getParameter("size");
                float priceflo = -1;
                try {
                    priceflo = Float.parseFloat(price);
                } catch (Exception e) {
                    request.setAttribute("message", "Price must be a number!");
                    url = ERROR;
                    request.getRequestDispatcher(url).forward(request, response);
                }

                ComesticDAO comesticDAO = new ComesticDAO();
                ComesticDTO comestic = new ComesticDTO(id, name, description, priceflo, size);

                boolean checkUpdate = comesticDAO.update(comestic);
                if (checkUpdate) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("message", "Can not update comestic");
                }
            }

        } catch (Exception e) {
            log("Error at LogoutController: " + e.toString());
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
