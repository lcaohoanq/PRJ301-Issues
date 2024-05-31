package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.cart.CartDTO;
import sample.product.ProductDTO;

@WebServlet(name = "AddToCartController", urlPatterns = { "/AddToCartController" })
public class AddToCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String quantity = request.getParameter("quantity");

            System.out.println(
                    "Data cart: " + "id: " + id + " name: " + name + " price: " + price + " quantity: " + quantity);

            HttpSession session = request.getSession();

            CartDTO cart = (CartDTO) session.getAttribute("CART");

            if (cart == null) {
                cart = new CartDTO();
            }

            if (cart.add(new ProductDTO(id, quantity, name, Integer.parseInt(price), Integer.parseInt(quantity)))) {
                System.out.println("add ok");
                session.setAttribute("CART", cart);
                request.setAttribute("MESSAGE", "You added " + name + " to your cart\nQuantity: " + quantity);
            } else {
                System.out.println("Khong add vo gio hang dc");
            }

        } catch (Exception e) {
            System.out.println("Error ne: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("./shopping.jsp").forward(request, response);
        }

    }

}
