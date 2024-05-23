/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MobileDAO;
import model.MobileDTO;
import model.UserError;

/**
 *
 * @author lcaohoanq
 */
@WebServlet(name = "MobileController", urlPatterns = { "/MobileController" })
public class MobileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        String search = req.getParameter("action").trim();
        System.out.println("Data: " + search);

        try {
            // if not enter anything, will receive the all product in shope
            if (search.isEmpty()) {
                List<MobileDTO> mobilesList = new MobileDAO().getAllMobile();
                req.setAttribute("LIST_MOBILE", mobilesList);
            }

            // if enter the price range, will receive the product in that range
            String regex = "^\\d+-\\d+$";
            if (search.matches(regex)) {
                String[] range = search.split("-");
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
                req.setAttribute("ERROR", "Please enter the price range in the format: min-max");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            req.getRequestDispatcher("./user.jsp").forward(req, res);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

}
