/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author lcaohoanq
 */
public class UserDAO {

    private static final String SELECT_ALL_USERS = "SELECT UserID, Password FROM tblUsers";
    private static final String LOGIN = "SELECT UserID, Password FROM tblUsers WHERE userID=? AND password=? ";

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("UserID");
                    String roleID = rs.getString("Password");
                    user = new UserDTO(userID, fullName, roleID, "***");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public List<UserDTO> getAllUsers() throws SQLException {
        List<UserDTO> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SELECT_ALL_USERS);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("UserID");
                    String password = rs.getString("Password");
                    // Assuming the password is not retrieved from this query for security reasons
                    users.add(new UserDTO(userID, password));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return users;
    }

    public static void main(String[] args) throws Exception {
//        UserDAO user = new UserDAO();

        try ( Connection conn = DBUtils.getConnection()) {
            if (conn != null) {
                System.out.println("Connect successfully");

                UserDAO userDAO = new UserDAO();

                // Example usage to print all users
                List<UserDTO> usersList = userDAO.getAllUsers();
                for (UserDTO item : usersList) {
                    System.out.println(item);
                }

//        System.out.println(user.checkLogin("bao", "1"));
            } else {
                throw new Error("Do not connect");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
