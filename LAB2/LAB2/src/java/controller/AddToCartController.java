/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.BookDAO;
import models.BookDTO;
import models.CartDTO;

@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "welcome.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        String id = request.getParameter("id");
        String name = "";
        String des = "";
        double price = 0;
        int quantity = 0;

        try {
            System.out.println("AddToCart id: " + id);

            //lay quantity ve
            quantity = Integer.parseInt(request.getParameter("Quantity"));

            //tim trong danh sach bang id
            //de lay nhung gia tri constant (name, des, price)
            for (BookDTO book : new BookDAO().getListBook()) {
                if (book.getId().equals(id)) {
                    name = book.getName();
                    des = book.getDescription();
                    price = book.getPrice();
                }
            }

            //track cart by session
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartDTO();
            }

            if (cart.add(new BookDTO(id, name, price, des, 1))) {
                session.setAttribute("CART", cart);
                request.setAttribute("MESSAGE", "You added " + name + ". quantity: " + quantity);
                request.setAttribute("success", "Adding book");
                url = SUCCESS;
            } else {
                throw new Error("Error while add product to cart");
            }

        } catch (Exception e) {
            log("Error at AddToCartController: " + e.toString());
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
