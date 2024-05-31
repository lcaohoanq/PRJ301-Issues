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

@WebServlet(name = "UserSearchBrandController", urlPatterns = { "/UserSearchBrandController" })
public class UserSearchBrandController extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try {
      String brand = request.getParameter("brand");

      ProductDAO dao = new ProductDAO();
      if (brand != null && !brand.isEmpty()) {
        List<ProductDTO> listProduct = dao.searchByBrand(brand);
        if (listProduct.isEmpty()) {
          request.setAttribute("NO_RESULTS", "No search Results");
        } else {
          request.setAttribute("LIST_PRODUCT", listProduct);
        }
      } else {
        request.setAttribute("LIST_PRODUCT", dao.getAllProducts());
      }

    } catch (Exception e) {
      log("Error at SearchBrandController: " + e.toString());
    } finally {
      request.getRequestDispatcher("./shopping.jsp").forward(request, response);
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
    return "SearchBrandController handles product search functionality";
  }
}
