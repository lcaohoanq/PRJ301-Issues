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

                    mobilesList.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale));
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mobilesList;
    }

    public static void main(String[] args) throws Exception {
        new MobileDAO().getAllMobile().stream().forEach(System.out::println);
    }

}
