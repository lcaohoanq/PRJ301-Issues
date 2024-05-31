package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.product.ProductDAO;

@WebServlet(name = "RemoveController", urlPatterns = {"/RemoveController"})
public class RemoveController extends HttpServlet {
    private static final String SEARCH_PAGE = "SearchController"; 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productId = request.getParameter("productId");
        try {
            ProductDAO dao = new ProductDAO();
            dao.removeProduct(productId);
            
            request.getRequestDispatcher(SEARCH_PAGE).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
