package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartDTO;
import model.MobileDTO;

@WebServlet(name = "ChangeProductCartController", urlPatterns = {"/ChangeProductCartController"})
public class ChangeProductCartController extends HttpServlet {

    private static final String ERROR = "viewCart.jsp";
    private static final String SUCCESS = "viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("id");
            int newQuantity = Integer.parseInt(request.getParameter("quantity"));
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
                if (cart.getCart().containsKey(id)) {
                    String name = cart.getCart().get(id).getMobileName();
                    float price = cart.getCart().get(id).getPrice();
                    MobileDTO mobile = new MobileDTO(id, price, name, newQuantity);
                    boolean check = cart.change(id, mobile);
                    if (check) {
                        session.setAttribute("CART", cart);
                        url = SUCCESS;
                    }
                }
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
