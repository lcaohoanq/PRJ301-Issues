package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String DB_NAME="PRODUCT_PE_PRJ301";
    private static final String DB_USER_NAME="sa";
    private static final String DB_PASSWORD="12345";
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:1433;databaseName="+ DB_NAME;
        conn= DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return conn;
    }
    
    public static void main(String[] args) {
        try{
            if(DBUtils.getConnection() != null){
                System.out.println("Connect Successfully");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}