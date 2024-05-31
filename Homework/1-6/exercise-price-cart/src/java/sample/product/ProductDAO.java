package sample.product;

import sample.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.user.UserDTO;

public class ProductDAO {

    public List<ProductDTO> getListProductByPrice(double fromPrice, double toPrice) throws Exception {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT id, name, price, quantity FROM tblItems WHERE price BETWEEN ? AND ?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, fromPrice);
            ps.setDouble(2, toPrice);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String brand = rs.getString("brand");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    list.add(new ProductDTO(id, brand, name, price, quantity));
                }
            }
        }
        return list;

    }

    public boolean removeProduct(String productId) throws Exception {
        boolean isRemoved = false;
        String sql = "DELETE FROM tblItems WHERE id=?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, productId);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public boolean addProduct(ProductDTO product) throws Exception {
        boolean isAdded = false;
        String sql = "INSERT INTO tblItems(id, brand, name, price, quantity) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getId());
            ps.setString(2, product.getBrand());
            ps.setString(3, product.getName());
            ps.setInt(4, product.getPrice());
            ps.setInt(5, product.getQuantity());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                isAdded = true;
            }
        }
        return isAdded;
    }

    public ProductDTO getProductById(String productId) {
        ProductDTO product = null;
        String sql = "SELECT id, brand, name, price, quantity FROM tblItems WHERE id = ?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String id = rs.getString("id");
                    String brand = rs.getString("brand");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    product = new ProductDTO(id, brand, name, price, quantity);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    public boolean update(ProductDTO product) throws SQLException {
        boolean checkUpdate = false;
        String sql = "UPDATE tblItems SET name=?, price=?, quantity=? WHERE id=?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setInt(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getId());

            checkUpdate = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkUpdate;
    }

    public List<ProductDTO> getAllProducts() throws Exception {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT id, brand, name, price, quantity FROM tblItems";

        try (Connection conn = DBUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String brand = rs.getString("brand");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    list.add(new ProductDTO(id, brand, name, price, quantity));
                }
            }
        }
        return list;
    }

    public List<ProductDTO> searchByBrand(String brand) {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT id, brand, name, price, quantity FROM tblItems WHERE brand LIKE ?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + brand + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    list.add(new ProductDTO(id, brand, name, price, quantity));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
