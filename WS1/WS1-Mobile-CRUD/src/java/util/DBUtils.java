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
    String url = "jdbc:sqlserver://localhost:1433;databaseName=MobileCRUD";
    conn = DriverManager.getConnection(url, "sa", "Luucaohoang1604^^");
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