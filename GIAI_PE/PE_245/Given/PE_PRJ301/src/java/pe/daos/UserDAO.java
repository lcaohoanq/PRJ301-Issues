/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.dtos.UserDTO;
import pe.utils.DBUtils;

/**
 *
 * @author leyen
 */
public class UserDAO {

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select userID from tblUsers where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
              
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean insert(UserDTO user) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "insert into "
                        + "tblUsers(userID,fullName,roleID,password,status)"
                        + " values(?,?,?,?,?)";
                pstm = con.prepareStatement(sql);
                pstm.setString(1, user.getUserID());
                pstm.setString(2, user.getFullname());
                pstm.setString(3, user.getRoleID());
                pstm.setString(4, user.getPassword());

                pstm.setBoolean(5, true);
                check = pstm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return check;
    }

    public UserDTO checklogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select fullname, roleid from tblUsers where userID = ? and password = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userID);           
                pstm.setString(2, password);
                
                rs = pstm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("fullName");
                  
                    String role = rs.getString("roleID");
                    user = new UserDTO(name,userID,"",
                            role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;

    }
}
