/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.prj301.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.prj301.utils.DBUtils;

/**
 *
 * @author hd
 */
public class DAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Products> getAllProduct() throws ClassNotFoundException, SQLException {
        List<Products> list = new ArrayList<>();
        String query = "SELECT * FROM [tblProducts]";
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Products(rs.getString("productID"), rs.getString("productName"), rs.getString("description"), rs.getFloat("price"), rs.getInt("status")));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return list;
    }

    public Products getProductNameAndPriceByID(String id) throws ClassNotFoundException, SQLException {
        String query = "SELECT productName, price FROM [tblProducts] where productID = ?";
        Products p = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(query);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    p = new Products(rs.getString("productName"), rs.getFloat("price"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return p;
    }

    public int addProduct(String id, String name, String des, float price, int status) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO [tblProducts] VALUES (?, ?, ?, ?, ?)";
        int rowsAffected = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(query);
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, des);
                ps.setFloat(4, price);
                ps.setInt(5, status);
                rowsAffected = ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return rowsAffected;
    }

    public int editProduct(String id, String name, String des, float price, int status) throws ClassNotFoundException, SQLException {
        String query = "UPDATE [tblProducts] SET productName = ?, description = ?, price = ?, status = ? WHERE productID = ?";
        int rowsAffected = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, des);
                ps.setFloat(3, price);
                ps.setInt(4, status);
                ps.setString(5, id);
                rowsAffected = ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return rowsAffected;
    }

    public int deleteProduct(String productID) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM [tblProducts] WHERE productID = ?";
        int rowsAffected = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(query);
                ps.setString(1, productID);
                rowsAffected = ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return rowsAffected;
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        testGetAllProducts();
//        testAddProduct();
//        testEditProduct();
//        testDeleteProduct();
        testGetProductsNameAndPrice("P001");

    }

    public static void testGetAllProducts() {
        try {
            for (Products item : new DAO().getAllProduct()) {
                System.out.println("Product: " + item);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetProductsNameAndPrice(String id) {
        try {
            System.out.println("Product: " + new DAO().getProductNameAndPriceByID(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testAddProduct() {
        try {
            DAO dao = new DAO();
            int rowsAffected = dao.addProduct("P001", "Product1", "Description1", 10.0f, 1);
            System.out.println("Rows affected by addProduct: " + rowsAffected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testEditProduct() {
        try {
            DAO dao = new DAO();
            int rowsAffected = dao.editProduct("P001", "UpdatedProduct1", "UpdatedDescription1", 15.0f, 0);
            System.out.println("Rows affected by editProduct: " + rowsAffected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testDeleteProduct() {
        try {
            DAO dao = new DAO();
            int rowsAffected = dao.deleteProduct("P001");
            System.out.println("Rows affected by deleteProduct: " + rowsAffected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
