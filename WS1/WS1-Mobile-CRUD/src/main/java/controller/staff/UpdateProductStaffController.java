package controller.staff;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MobileDAO;
import model.MobileDTO;

@WebServlet(name = "UpdateProductStaff", urlPatterns = {"/UpdateProductStaffController"})
public class UpdateProductStaffController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("At update");

            String mobileIdStr = request.getParameter("mobileId");
            String mobileDescriptionStr = request.getParameter("mobileDescription");
            String mobilePriceStr = request.getParameter("mobilePrice");
            String mobileQuantityStr = request.getParameter("mobileQuantity");
            String mobileNotSaleStr = request.getParameter("mobileNotSale");

            System.out.println(
                    "Update data = " + "id: " + mobileIdStr + " description: " + mobileDescriptionStr + " price: "
                    + mobilePriceStr + " quantity: " + mobileQuantityStr + " not sale: " + mobileNotSaleStr);

            // cast price: float, quantity and notSale: int
            float mobilePriceFloat = Float.parseFloat(mobilePriceStr);
            int mobileQuantityInt = Integer.parseInt(mobileQuantityStr);
            int mobileNotSaleInt = Integer.parseInt(mobileNotSaleStr);

            if (new MobileDAO().updateMobile(new MobileDTO(mobileIdStr, mobilePriceFloat,
                    mobileDescriptionStr,
                    mobileQuantityInt, mobileNotSaleInt))) {
                request.setAttribute("UPDATE_STATUS", "Update success");
            } else {
                request.setAttribute("UPDATE_STATUS", "Update failed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            response.sendRedirect("http://localhost:8080/mobile-crud/MainController?searchQuery=&action=SearchProductStaff");
        }
    }

}
