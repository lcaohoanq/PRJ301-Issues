package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ProductDTO;
import utils.DBUtils;

public class ProductDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ProductDTO> getAllProduct()
            throws ClassNotFoundException, SQLException {
        List<ProductDTO> list = new ArrayList<>();
        String query = "SELECT * FROM [tblProducts]";
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(
                            new ProductDTO(
                                    rs.getString("productID"),
                                    rs.getString("productName"),
                                    rs.getString("description"),
                                    rs.getFloat("price"),
                                    rs.getInt("status")
                            )
                    );
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return list;
    }

    public int addProduct(
            String id,
            String name,
            String des,
            float price,
            int status
    ) throws ClassNotFoundException, SQLException {
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

    public int editProduct(
            String id,
            String name,
            String des,
            float price,
            int status
    ) throws ClassNotFoundException, SQLException {
        String query
                = "UPDATE [tblProducts] SET productName = ?, description = ?, price = ?, status = ? WHERE productID = ?";
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

    public ProductDTO load(String productId) {
        String query = "SELECT * FROM [tblProducts] WHERE productId = ?";
        ProductDTO productDTO = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(query);
                ps.setString(1, productId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    productDTO = new ProductDTO(
                            rs.getString("productID"),
                            rs.getString("productName"),
                            rs.getString("description"),
                            rs.getFloat("price"),
                            rs.getInt("status")
                    );
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return productDTO;
    }

    public int deleteProduct(String productID)
            throws ClassNotFoundException, SQLException {
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

    //"SELECT * FROM [tblProducts] WHERE productName LIKE %?% OR description LIKE %?"
    public List<ProductDTO> search(String productName)
            throws ClassNotFoundException, SQLException {
        List<ProductDTO> list = new ArrayList<>();
        String query = "SELECT * FROM [tblProducts] WHERE productName LIKE ?";
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(query);
                ps.setString(1, "%" + productName + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(
                            new ProductDTO(
                                    rs.getString("productID"),
                                    rs.getString("productName"),
                                    rs.getString("description"),
                                    rs.getFloat("price"),
                                    rs.getInt("status")
                            )
                    );
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return list;
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
//        testGetAllProducts();
        //        testAddProduct();
        //        testEditProduct();
        //        testDeleteProduct();
//        testSearch();
        testLoad();
    }

    public static void testLoad() {
        try {
            System.out.println(new ProductDAO().load("P001"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetAllProducts() {
        try {
            for (ProductDTO item : new ProductDAO().getAllProduct()) {
                System.out.println("Product: " + item);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testAddProduct() {
        try {
            ProductDAO dao = new ProductDAO();
            int rowsAffected = dao.addProduct(
                    "P001",
                    "Product1",
                    "Description1",
                    10.0f,
                    1
            );
            System.out.println("Rows affected by addProduct: " + rowsAffected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testEditProduct() {
        try {
            ProductDAO dao = new ProductDAO();
            int rowsAffected = dao.editProduct(
                    "P001",
                    "UpdatedProduct1",
                    "UpdatedDescription1",
                    15.0f,
                    0
            );
            System.out.println("Rows affected by editProduct: " + rowsAffected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testDeleteProduct() {
        try {
            ProductDAO dao = new ProductDAO();
            int rowsAffected = dao.deleteProduct("P001");
            System.out.println(
                    "Rows affected by deleteProduct: " + rowsAffected
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSearch() {
        try {
            for (ProductDTO item : new ProductDAO().search("n")) {
                System.out.println("Product: " + item);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
