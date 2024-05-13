package com.lcaohoanq.controller;

import com.lcaohoanq.DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!isEmpty(username, password)) {
            if (UserDTO.isAdmin(username, password) || (username.equals("hoang") && password.equals("1"))) {
                request.setAttribute("username", username);
                request.getRequestDispatcher("./welcome.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("./login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("./login.jsp").forward(request, response);
        }

    }

    private boolean isEmpty(String username, String password) {
        return username.isEmpty() || password.isEmpty();
    }

}
