package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import constant.DBQueries;
import util.DBUtils;
import util.PasswordHandler;

public class UserDAO {

    public UserDTO checkLogin(String userId, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DBQueries.USER_LOGIN);
                ptm.setString(1, userId);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String userName = rs.getString("userId");
                    String pass = rs.getString("password");
                    user = new UserDTO(userId, pass);
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

    public String getPassword(String userId) throws SQLException {
        String password = "";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DBQueries.USER_PASSWORD);
                ptm.setString(1, userId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    password = rs.getString("password");
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
        return password;
    }

    public UserDTO findUserById(String userId) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT userId, password, fullName, role FROM tbl_User WHERE userId = ?");
                ptm.setString(1, userId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("userId");
                    String password = rs.getString("password");
                    String fullName = rs.getString("fullName");
                    int role = rs.getInt("role");
                    user = new UserDTO(id, password, fullName, role);
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

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DBQueries.USER_SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userId = rs.getString("userId");
                    String password = "***";
                    String fullName = rs.getString("fullName");
                    String role = rs.getString("role");
                    list.add(new UserDTO(userId, fullName, password));
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
        return list;
    }

    public List<UserDTO> getListUser() throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DBQueries.USER_SELECT_ALL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userId = rs.getString("userId");
                    String password = rs.getString("password");
                    String fullName = rs.getString("fullName");
                    int role = rs.getInt("role");
                    list.add(new UserDTO(userId, password, fullName, role));
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
        return list;
    }

    public boolean update(UserDTO user) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DBQueries.USER_UPDATE);
                ptm.setString(1, user.getName());
                ptm.setString(2, String.valueOf(user.getRoleID()));
                ptm.setString(3, user.getUserID());
                checkUpdate = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkUpdate;
    }

    public boolean delete(String userId) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DBQueries.USER_DELETE);
                ptm.setString(1, userId);
                checkDelete = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }

    public boolean checkDuplicate(String userId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DBQueries.USER_CHECK_DUPLICATE);
                ptm.setString(1, userId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public boolean insertV2(UserDTO user, int role) throws ClassNotFoundException, SQLException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DBQueries.USER_INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getPassword());
                ptm.setString(3, user.getName());
                ptm.setInt(4, role);
                System.out.println("ptm: " + ptm.toString());
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
    }

    public static void main(String[] args) throws Exception {

        try {
            // new UserDAO().getListUser().stream().forEach(System.out::println);

//            System.out.println(new UserDAO().checkLogin("ST001", "345678").toString());
//            System.out.println(new UserDAO().insertV2(new UserDTO("ad", "1", "1"), 0));
//            System.out.println(new UserDAO().insertV2(new UserDTO("ST99", "Luucaohoang", new PasswordHandler().hash("1604".toCharArray())), 1));
            System.out.println(new UserDAO().getPassword("ST123"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
