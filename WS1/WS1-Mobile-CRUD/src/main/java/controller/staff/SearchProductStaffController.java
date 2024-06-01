package controller.staff;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Regex;
import model.MobileDAO;

@WebServlet(name = "SearchProductStaff", urlPatterns = {"/SearchProductStaffController"})
public class SearchProductStaffController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        String search = req.getParameter("searchQuery").trim();

        if (search == null || search.trim().isEmpty()) {
            // if not enter anything, will see the all product in shope
            req.setAttribute("LIST_MOBILE", new MobileDAO().getAllMobile());
        } else {
            search = search.trim();
            try {
                // if enter the price range, will receive the product in that range
                if (search.matches(Regex.MOBILE_NAME) && !search.contains("MOB")) {
                    req.setAttribute("LIST_MOBILE", new MobileDAO().searchMobileByName(search));
                } else if (search.matches(Regex.MOBILE_ID)) {
                    req.setAttribute("LIST_MOBILE", new MobileDAO().getMobileById(search));
                } else {
                    req.setAttribute("ERROR", "Enter the price range in the format: min,max");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        req.getRequestDispatcher("./staff.jsp").forward(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
