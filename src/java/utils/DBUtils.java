/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hd
 */
public class DBUtils {
    public static final Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:1433;databaseName=UserManagement";
        conn= DriverManager.getConnection(url, "sa", "12345");
        return conn;
    }
    
    public static void main(String[] args) {
        try ( Connection conn = DBUtils.getConnection()) {
            if (conn != null) {
                System.out.println("Connect successfully");
            } else {
                throw new Error("Do not connect");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
