package controller.staff;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MobileDAO;

@WebServlet(name = "DeleteProductStaff", urlPatterns = { "/DeleteProductStaffController" })
public class DeleteProductStaffController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                request.getRequestDispatcher("./staff.jsp").forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                try {
                        String mobileId = request.getParameter("mobileId");
                        if (new MobileDAO().deleteMobile(mobileId)) {
                                request.setAttribute("DELETE_STATUS", "Delete success");
                        } else {
                                request.setAttribute("DELETE_STATUS", "Delete failed");
                        }
                } catch (Exception e) {

                } finally {
                        response.sendRedirect(
                                        "http://localhost:8080/mobile-crud/MainController?searchQuery=&action=SearchProductStaff");
                }
        }

}
