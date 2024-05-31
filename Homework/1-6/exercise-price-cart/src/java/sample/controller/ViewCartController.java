package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.user.UserDTO;

@WebServlet(name = "ViewCartController", urlPatterns = { "/ViewCartController" })
public class ViewCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        if (session != null) {
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user != null) {
                request.setAttribute("LOGIN_USER", user);
                request.getRequestDispatcher("./viewCart.jsp").forward(request, response);
            } else {
                response.sendRedirect("LoginController");
            }
        } else {
            response.sendRedirect("LoginController");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
