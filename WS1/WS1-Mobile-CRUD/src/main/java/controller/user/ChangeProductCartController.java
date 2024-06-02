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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./viewCart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Change product pos");
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("MESSAGE_CHANGE_QUANTITY", "Your action is not support now");
        request.getRequestDispatcher("./viewCart.jsp").forward(request, response);

//        try {
//            String id = request.getParameter("id");
//            int newQuantity = Integer.parseInt(request.getParameter("quantity"));
//            HttpSession session = request.getSession();
//            CartDTO cart = (CartDTO) session.getAttribute("CART");
//            if (cart != null) {
//                if (cart.getCart().containsKey(id)) {
//                    String name = cart.getCart().get(id).getMobileName();
//                    float price = cart.getCart().get(id).getPrice();
//                    MobileDTO mobile = new MobileDTO(id, price, name, newQuantity);
//                    boolean check = cart.change(id, mobile);
//                    if (check) {
//                        session.setAttribute("CART", cart);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            log("Error at AddToCartController: " + e.toString());
//        } finally {
//            request.getRequestDispatcher("./viewCart.jsp").forward(request, response);
//        }
    }

}
