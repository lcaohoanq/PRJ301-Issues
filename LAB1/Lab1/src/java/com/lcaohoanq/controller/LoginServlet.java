package com.lcaohoanq.controller;

import com.lcaohoanq.DAO.UserDAO;
import com.lcaohoanq.DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userID = request.getParameter("userID");
        String password = request.getParameter("password");

        if (!isEmpty(userID, password)) {
            try {
                System.out.println(new UserDAO().checkLogin(userID, password));
                if (UserDTO.isAdmin(userID, password) || new UserDAO().checkLogin(userID, password) != null) {
                    request.setAttribute("userID", userID);
                    request.getRequestDispatcher("./welcome.jsp").forward(request, response);
                } 
                request.setAttribute("fail", "Invalid user or password!!!");
                request.getRequestDispatcher("fail.jsp").forward(request, response);
                throw new SQLException("Invalid user or password!!!");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            request.getRequestDispatcher("./login.jsp").forward(request, response);
        }

    }

    private boolean isEmpty(String userID, String password) {
        return userID.isEmpty() || password.isEmpty();
    }

}
