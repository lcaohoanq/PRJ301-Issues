package controller.staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MobileDAO;
import model.MobileDTO;
import model.MobileError;
import util.DataHandler;

@WebServlet(name = "InsertProductStaff", urlPatterns = { "/InsertProductStaffController" })
public class InsertProductStaffController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./insert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String mobileId = request.getParameter("mobileId");
            String mobileDescription = request.getParameter("mobileDescription");
            float mobilePrice = Float.parseFloat(request.getParameter("mobilePrice"));
            String mobileName = request.getParameter("mobileName");
            int mobileYear = Integer.parseInt(request.getParameter("mobileYear"));
            int mobileQuantity = Integer.parseInt(request.getParameter("mobileQuantity"));
            int mobileNotSale = Integer.parseInt(request.getParameter("mobileNotSale"));

            // validate

            System.out.println(
                    "Insert data = " + mobileId + " " + mobileDescription + " " + mobilePrice + " " + mobileName
                            + " " + mobileYear + " " + mobileQuantity + " " + mobileNotSale);

            if (new MobileDAO().insertMobile(new MobileDTO(mobileId, mobileDescription,
                    mobilePrice, mobileName,
                    mobileYear, mobileQuantity, mobileNotSale))) {
                request.setAttribute("INSERT_STATUS", "Insert success");
            } else {
                request.setAttribute("INSERT_STATUS", "Insert failed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            request.getRequestDispatcher("./insert.jsp").forward(request, response);
        }

    }

}
