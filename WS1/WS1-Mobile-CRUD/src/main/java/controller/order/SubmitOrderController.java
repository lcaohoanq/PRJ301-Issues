package controller.order;

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

@WebServlet(name = "SubmitOrderController", urlPatterns = { "/SubmitOrderController" })
public class SubmitOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./viewOrder.jsp").forward(request, response);
        HttpSession session = request.getSession(false);
        if (session != null) {
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {

                int count = 1;
                double total = 0;
                for (MobileDTO item : cart.getCart().values()) {
                    double itemTotal = item.getPrice() * item.getQuantity();
                    total += itemTotal;
                    System.out.println("Order Data: " + item.getMobileId() + " " + item.getMobileName() + " "
                            + item.getPrice() + " " + item.getQuantity() + " " + itemTotal);
                }
            } else {
                response.sendRedirect("cart.jsp"); // Redirect to cart page if cart is empty
            }
        } else {
            response.sendRedirect("LoginController"); // Redirect to login page if session is null
        }
    }
}
