package DAO;

import models.BookDTO;
import constants.DBQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import constants.DBQueries;
import utils.DBUtils;

public class BookDAO {

    public List<BookDTO> getListBook() {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(DBQueries.SELECT_ALL_BOOK);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("SKU");
                    String name = rs.getString("Name");
                    double price = rs.getDouble("Price");
                    String des = rs.getString("Description");
                    int quantity = rs.getInt("Quantity");
                    list.add(new BookDTO(id, name, price, des, quantity));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(conn, pst, rs);
        }
        return list;
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();   // doesn't really close it ... just puts back in connection pool
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
