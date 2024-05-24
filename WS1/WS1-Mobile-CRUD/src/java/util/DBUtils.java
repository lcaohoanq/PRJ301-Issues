package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hd
 */
public class DBUtils {
  public static final Connection getConnection() throws ClassNotFoundException, SQLException {
    Connection conn = null;
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    conn = DriverManager.getConnection(EnvUtils.get("DB_URL"), EnvUtils.get("DB_USER"), EnvUtils.get("DB_PASSWORD"));
    return conn;
  }

  public static void main(String[] args) throws Exception {
    try (Connection con = DBUtils.getConnection()) {
      System.out.println("Connected successfully");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}