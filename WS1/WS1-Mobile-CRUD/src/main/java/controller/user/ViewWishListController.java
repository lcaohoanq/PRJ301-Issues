package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartDTO;
import model.MobileDTO;
import model.UserDTO;

@WebServlet(name = "ViewWishListController", urlPatterns = { "/ViewWishListController" })
public class ViewWishListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
//        Cookie userCookie = null;
        if (session != null) {
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user != null) {
                System.out.println("Current user: " + user);
                request.setAttribute("LOGIN_USER", user);
                request.getRequestDispatcher("./viewWishlist.jsp").forward(request, response);
            } else {
                response.sendRedirect("LoginController"); // Redirect to login page if session is null
            }
        } else {
            response.sendRedirect("LoginController"); // Redirect to login page if session is null
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
