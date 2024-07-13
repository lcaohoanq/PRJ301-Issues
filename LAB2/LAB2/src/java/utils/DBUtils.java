package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    public static final Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:1433;databaseName=UserManagement";
        conn= DriverManager.getConnection(url, "sa", "12345");
        return conn;
    }
}
