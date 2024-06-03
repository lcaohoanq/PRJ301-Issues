/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
import model.WishListDTO;

/**
 *
 * @author lcaohoanq
 */
@WebServlet(name = "RemoveWishListController", urlPatterns = {"/RemoveWishListController"})
public class RemoveWishListController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("At view wishlist POST");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            WishListDTO wishList = (WishListDTO) session.getAttribute("WISHLIST");
            if (wishList != null) {
                if (wishList.getWishList().containsKey(id)) {
                    boolean check = wishList.remove(id);
                    if (check) {
                        if (wishList.getWishList().size() == 0) {
                            session.setAttribute("WISHLIST", null);
                        } else {
                            session.setAttribute("WISHLIST", wishList);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log("Error at AddToCartController: " + e.toString());
        } finally {
            request.getRequestDispatcher("./viewWishlist.jsp").forward(request, response);
        }
    }

}
