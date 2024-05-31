package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.product.ProductDAO;
import sample.product.ProductDTO;

@WebServlet(name = "AddController", urlPatterns = { "/AddController" })
public class AddController extends HttpServlet {

    private static final String itemsList = "itemsList.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(itemsList).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // data from request
        String id = request.getParameter("id").trim();
        String brand = request.getParameter("brand").trim();
        String name = request.getParameter("name").trim();
        String priceStr = request.getParameter("price").trim();
        String quantityStr = request.getParameter("quantity").trim();

        if (!isEmptyField(id, brand, name, priceStr, quantityStr)) {
            // data validation
            int price = Integer.parseInt(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            if (isDuplicateID(id)) {
                request.setAttribute("MESSAGE", "ID đã tồn tại.");
                request.getRequestDispatcher(itemsList).forward(request, response);
            } else if (!isValidFormatId(id)) {
                request.setAttribute("MESSAGE", "ID không hợp lệ.");
                request.getRequestDispatcher(itemsList).forward(request, response);
            } else if (!isValidFormatInteger(priceStr)) {
                request.setAttribute("MESSAGE", "Giá sản phẩm không hợp lệ.");
                request.getRequestDispatcher(itemsList).forward(request, response);
            } else if (!isValidFormatInteger(quantityStr)) {
                request.setAttribute("MESSAGE", "Số lượng sản phẩm không hợp lệ.");
                request.getRequestDispatcher(itemsList).forward(request, response);
            } else {

                try {
                    if (new ProductDAO().addProduct(new ProductDTO(id, brand, name, price, quantity))) {
                        request.setAttribute("MESSAGE", "Sản phẩm đã được thêm vào list.");
                        request.getRequestDispatcher(itemsList).forward(request, response);
                    } else {
                        response.sendRedirect(itemsList);
                    }
                } catch (Exception e) {
                    log("itemsList at AddController: " + e.toString());
                    response.sendRedirect(itemsList);
                }
            }
        } else {
            request.setAttribute("MESSAGE", "Vui lòng nhập đầy đủ thông tin.");
            request.getRequestDispatcher(itemsList).forward(request, response);
        }

    }

    private boolean isEmptyField(String... fields) {
        for (String field : fields) {
            if (field == null || field.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateID(String id) {
        return new ProductDAO().getProductById(id) != null;
    }

    private boolean isValidFormatId(String id) {
        return id.matches("^\\d{5}$");
    }

    private boolean isValidFormatInteger(String quantity) {
        return quantity.matches("^[1-9]\\d*$");
    }

}
