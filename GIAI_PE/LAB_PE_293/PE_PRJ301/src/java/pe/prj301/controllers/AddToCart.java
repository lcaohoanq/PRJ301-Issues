package pe.prj301.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.prj301.shopping.Cart;
import pe.prj301.shopping.DAO;
import pe.prj301.shopping.Products;

@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

    private static final String ERROR = "index.jsp";
    private static final String SUCCESS = "shopping.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        DAO listDao = new DAO();
        String productId = request.getParameter("id");
        String name = "";
        String des = "";
        float price = 0;
        int quantity = 0;

        System.out.println("id: " + productId);

        try {

            for (Products i : listDao.getAllProduct()) {
                if (i.getProductID().equals(productId)) {
                    name = i.getProductName();
                    des = i.getDescription();
                    price = i.getPrice();
                }
            }
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
                cart = new Cart();
            }
            if (cart.add(new Products(productId, name, des, price, 1))) {
                session.setAttribute("CART", cart);
                request.setAttribute("MESSAGE", "You added " + name + ". quantity: " + quantity);
                request.setAttribute("searchAll", new DAO().getAllProduct());
                request.setAttribute("addedProduct", new DAO().getProductNameAndPriceByID(productId));
                url = SUCCESS;
            } else {
                throw new Error("Error while add product to cart");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
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
