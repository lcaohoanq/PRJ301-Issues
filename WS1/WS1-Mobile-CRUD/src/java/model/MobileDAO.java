package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBUtils;

public class MobileDAO {

    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public List<MobileDTO> getAllMobile() throws Exception {
        List<MobileDTO> mobilesList = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pstm = con.prepareStatement("SELECT * FROM tbl_Mobile");
                rs = pstm.executeQuery();

                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    int notSale = rs.getInt("notSale");

                    mobilesList.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity,
                            notSale));
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mobilesList;
    }

    public List<MobileDTO> selectPriceInRange(int min, int max) throws Exception {
        List<MobileDTO> mobilesList = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pstm = con.prepareStatement("SELECT * FROM tbl_Mobile WHERE price BETWEEN ? AND ?");
                pstm.setInt(1, min);
                pstm.setInt(2, max);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    int notSale = rs.getInt("notSale");

                    mobilesList.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity,
                            notSale));
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mobilesList;
    }

    public List<MobileDTO> searchMobileByName(String search) throws Exception {
        List<MobileDTO> mobilesList = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pstm = con.prepareStatement("SELECT * FROM tbl_Mobile WHERE mobileName LIKE ?");
                pstm.setString(1, "%" + search + "%");
                rs = pstm.executeQuery();

                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    int notSale = rs.getInt("notSale");

                    mobilesList.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity,
                            notSale));
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mobilesList;
    }

    public List<MobileDTO> getMobileById(String mobileId) throws Exception {
        List<MobileDTO> mobilesList = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pstm = con.prepareStatement("SELECT * FROM tbl_Mobile WHERE mobileId = ?");
                pstm.setString(1, mobileId);
                rs = pstm.executeQuery();

                if (rs.next()) {
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    int notSale = rs.getInt("notSale");

                    mobilesList.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity,
                            notSale));
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mobilesList;
    }

    public boolean updateMobile(MobileDTO mobile) throws Exception {
        boolean result = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                pstm = con.prepareStatement(
                        "UPDATE tbl_Mobile SET description = ?, price = ?, mobileName = ?, yearOfProduction = ?, quantity = ?, notSale = ? WHERE mobileId = ?");
                pstm.setString(1, mobile.getDescription());
                pstm.setFloat(2, mobile.getPrice());
                pstm.setString(3, mobile.getMobileName());
                pstm.setInt(4, mobile.getYearOfProduction());
                pstm.setInt(5, mobile.getQuantity());
                pstm.setInt(6, mobile.getNotSale());
                pstm.setString(7, mobile.getMobileId());

                result = pstm.executeUpdate() > 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MobileDAO().getAllMobile().stream().forEach(System.out::println);
    }

}
