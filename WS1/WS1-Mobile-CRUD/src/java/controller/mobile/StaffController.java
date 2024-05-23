package controller.mobile;

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
import model.UserError;

@WebServlet(name = "StaffController", urlPatterns = { "/StaffController" })
public class StaffController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        String search = req.getParameter("action").trim();
        System.out.println("Data: " + search);

        try {
            // if enter the price range, will receive the product in that range
            if (search.matches(Regex.MOBILE_SEARCH_NAME) && !search.contains("MOB")) {
                req.setAttribute("LIST_MOBILE", new MobileDAO().searchMobileByName(search));
            } else if (search.matches(Regex.MOBILE_SEARCH_ID)) {
                req.setAttribute("MOBILE", new MobileDAO().getMobileById(search));
            } else if (search.isEmpty()) {
                // if not enter anything, will see the all product in shope
                req.setAttribute("LIST_MOBILE", new MobileDAO().getAllMobile());
            } else {
                req.setAttribute("ERROR", "Enter the price range in the format: min,max");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            req.getRequestDispatcher("./staff.jsp").forward(req, res);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

}
