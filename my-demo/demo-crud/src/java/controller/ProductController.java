package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        System.out.println("ProductController action: " + action);
        switch (action) {
            case "viewUpdate":
                request.setAttribute("product", new ProductDAO().load(request.getParameter("productId")));
                request.getRequestDispatcher("./updateProduct.jsp").forward(request, response);
                break;
            case "saveChangeUpdateProduct":
                update(request, response);
                break;
            case "viewCreate":
                request.getRequestDispatcher("./createProduct.jsp").forward(request, response);
                break;
            case "saveChangeCreateProduct":
                create(request, response);
                break;
            case "searchProduct":
                search(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }
    
    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("productId");
        String name = request.getParameter("productName");
        String des = request.getParameter("productDescription");
        float price = Float.parseFloat(request.getParameter("productPrice"));
        int status = Integer.parseInt(request.getParameter("productStatus"));
        
        try {
            new ProductDAO().addProduct(id, name, des, price, status);
            response.sendRedirect("./product.jsp");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("productId");
        String name = request.getParameter("productName");
        String des = request.getParameter("productDescription");
        float price = Float.parseFloat(request.getParameter("productPrice"));
        int status = Integer.parseInt(request.getParameter("productStatus"));
        
        try {
            new ProductDAO().editProduct(id, name, des, price, status);
            response.sendRedirect("./product.jsp");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("productId");
        
        try {
            new ProductDAO().deleteProduct(id);
            response.sendRedirect("./product.jsp");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("searchQuery");
        try {
            request.setAttribute("dataSearch", new ProductDAO().search(data));
            request.getRequestDispatcher("./searchProduct.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
