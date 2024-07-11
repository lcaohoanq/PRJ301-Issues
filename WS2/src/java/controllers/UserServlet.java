package controllers;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import utils.DBUtils;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Du lieu nhan trong UserServlet: " + action);
        switch (action) {
            case "viewRegister":
                request.getRequestDispatcher("./register.jsp").forward(request, response);
                break;
            case "register":
                registerUser(request, response);
                break;
            case "login":
                loginUser(request, response);
                break;
            case "logout":
                logoutUser(request, response);
                break;
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try {
            new UserDAO().registerUser(username, hashedPassword, email);
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            UserDAO userDAO = new UserDAO();
            if (userDAO.checkLogin(username)) {
                String storedPassword = userDAO.getPassword(username);
                if (BCrypt.checkpw(password, storedPassword)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", userDAO.getID(username));
                    session.setAttribute("username", username);
                    response.sendRedirect("dashboard.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=invalid");
                }
            } else {
                response.sendRedirect("login.jsp?error=invalid");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

}
