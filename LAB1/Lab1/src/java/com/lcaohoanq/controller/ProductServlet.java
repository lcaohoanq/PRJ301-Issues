package com.lcaohoanq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lcaohoanq
 */
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./checkbox.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] optionsList = request.getParameterValues("options");

        if (optionsList != null) {
            request.setAttribute("optionsList", optionsList);
            request.getRequestDispatcher("./checkbox.jsp").forward(request, response);
        } else{
            request.getRequestDispatcher("./checkbox.jsp").forward(request, response);
        }
    }

}
