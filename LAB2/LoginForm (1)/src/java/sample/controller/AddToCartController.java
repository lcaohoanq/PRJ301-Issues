/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.book.BookDAO;
import sample.book.BookDTO;
import sample.book.CartDTO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

   private static final String ERROR="login.jsp";
    private static final String SUCCESS="welcome.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= ERROR;
        BookDAO list_book = new BookDAO();
        String id= request.getParameter("id");
            String name = "";
            String des = "";
            double price = 0;
            int quantity = 0;
        try {
            String q = request.getParameter("Quantity");
            quantity = Integer.parseInt(q);
            for (BookDTO i : list_book.getListBook()) {
                if(i.getId().equals(id)){
                    name = i.getName(); 
                    des = i.getDescription();
                    price = i.getPrice();
                }
            }
            HttpSession session= request.getSession();
            CartDTO cart= (CartDTO)session.getAttribute("CART");
            if(cart == null){
                cart= new CartDTO();
            }
            boolean check= cart.add(new BookDTO(id, name, price, des,quantity));
            if(check){
                session.setAttribute("CART", cart);
                request.setAttribute("MESSAGE", "You added "+ name+". quantity: "+ quantity);
                request.setAttribute("success", "Adding book");
                url=SUCCESS;
            }else{
                throw new Error("Error while add product to cart");
            }
            
        } catch (Exception e) {
            log("Error at AddToCartController: "+ e.toString());
        }finally{
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
