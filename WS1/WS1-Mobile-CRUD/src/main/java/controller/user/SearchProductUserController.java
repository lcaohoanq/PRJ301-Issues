/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Regex;
import model.MobileDAO;
import model.MobileDTO;

/**
 *
 * @author lcaohoanq
 */
@WebServlet(name = "SearchProductUser", urlPatterns = { "/SearchProductUserController" })
public class SearchProductUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        String search = req.getParameter("searchQuery");
        if (search == null || search.trim().isEmpty()) {
            // If no search query is provided, show all products
            List<MobileDTO> mobilesList = new MobileDAO().getAllMobile();
            req.setAttribute("LIST_MOBILE", mobilesList);
        } else {
            search = search.trim();
            System.out.println("Data: " + search);

            try {
                // if enter the price range, will receive the product in that range
                if (search.matches(Regex.MOBILE_SEARCH_RANGE)) {
                    String[] range = search.split(",");
                    int min = Integer.parseInt(range[0]);
                    int max = Integer.parseInt(range[1]);

                    if (min > max) {
                        int temp = min;
                        min = max;
                        max = temp;
                    }

                    List<MobileDTO> mobilesList = new MobileDAO().selectPriceInRange(min, max);
                    req.setAttribute("LIST_MOBILE", mobilesList);
                } else {
                    req.setAttribute("ERROR", "Enter the price range in the format: min,max");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        req.getRequestDispatcher("./user.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
