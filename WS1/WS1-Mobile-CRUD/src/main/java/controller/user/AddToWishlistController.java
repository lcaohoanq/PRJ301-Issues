package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartDTO;
import model.MobileDAO;
import model.MobileDTO;
import model.WishListDTO;

@WebServlet(name = "AddToWishlistController", urlPatterns = { "/AddToWishlistController" })
public class AddToWishlistController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MobileDTO> mobilesList = new MobileDAO().getAllMobile();
        request.setAttribute("LIST_MOBILE", mobilesList);
        request.getRequestDispatcher("./user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("WishList added item");
        response.setContentType("text/html;charset=UTF-8");
            try {
                String mobileId = request.getParameter("mobileId");
                String mobileName = request.getParameter("mobileName");
                float mobilePrice = Float.parseFloat(request.getParameter("mobilePrice"));
                int buy = 1;

            HttpSession session = request.getSession();
                WishListDTO wishList = (WishListDTO) session.getAttribute("WISHLIST");
                if (wishList == null) {
                    wishList = new WishListDTO();
                }
                boolean check = wishList.add(new MobileDTO(mobileId, mobilePrice, mobileName, buy));
                if (check) {
                    session.setAttribute("WISHLIST", wishList);
                }

            } catch (Exception e) {
                log("Error at AddToWishlistController: " + e.toString());
            } finally {
                List<MobileDTO> mobilesList = new MobileDAO().getAllMobile();
                request.setAttribute("LIST_MOBILE", mobilesList);
                request.getRequestDispatcher("./user.jsp").forward(request, response);
            }
        }

    }
