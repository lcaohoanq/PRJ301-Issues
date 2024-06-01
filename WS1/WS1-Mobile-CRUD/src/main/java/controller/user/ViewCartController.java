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
import model.UserDTO;

/**
 *
 * @author lcaohoanq
 */
@WebServlet(name = "ViewCart", urlPatterns = { "/ViewCartController" })
public class ViewCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (session != null) {
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user != null) {
                System.out.println("Current user: " + user);
                request.setAttribute("LOGIN_USER", user);
                request.getRequestDispatcher("./viewCart.jsp").forward(request, response);
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
