package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartDTO;
import model.MobileDAO;
import model.MobileDTO;

@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String mobileId = request.getParameter("mobileId");
            String mobileName = request.getParameter("mobileName");
            float mobilePrice = Float.parseFloat(request.getParameter("mobilePrice"));
            int buy = 1;

            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartDTO();
            }
            boolean check = cart.add(new MobileDTO(mobileId, mobilePrice, mobileName, buy));
            if (check) {
                session.setAttribute("CART", cart);
                request.setAttribute("MESSAGE", "You added " + mobileName + ". Quantity: " + buy);
            }

        } catch (Exception e) {
            log("Error at AddToCartController: " + e.toString());
        } finally {
            List<MobileDTO> mobilesList = new MobileDAO().getAllMobile();
            request.setAttribute("LIST_MOBILE", mobilesList);
            request.getRequestDispatcher("./user.jsp").forward(request, response);
        }
    }

}
