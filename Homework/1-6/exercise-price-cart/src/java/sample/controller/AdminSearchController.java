package sample.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.product.ProductDAO;
import sample.product.ProductDTO;

@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class AdminSearchController extends HttpServlet {

    private static final String ERROR = "itemsList.jsp";
    private static final String SUCCESS = "itemsList.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String fromPriceStr = request.getParameter("fromPrice");
            String toPriceStr = request.getParameter("toPrice");

            if (fromPriceStr != null && toPriceStr != null && !fromPriceStr.isEmpty() && !toPriceStr.isEmpty()) {
                double fromPrice = Double.parseDouble(fromPriceStr);
                double toPrice = Double.parseDouble(toPriceStr);

                ProductDAO dao = new ProductDAO();
                List<ProductDTO> listProduct = dao.getListProductByPrice(fromPrice, toPrice);

                if (listProduct.isEmpty()) {
                    request.setAttribute("NO_RESULTS", "No search Results");
                } else {
                    request.setAttribute("LIST_PRODUCT", listProduct);
                }
            }

        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
        } finally {
            request.getRequestDispatcher("itemsList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "SearchController handles product search functionality";
    }
}
