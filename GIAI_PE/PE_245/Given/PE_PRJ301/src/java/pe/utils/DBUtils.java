/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pe.dtos.UserDTO;

/**
 *
 * @author Hoa Doan
 */
public class DBUtils {
//    Do not change this code

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=ComesticManagement";
        conn = DriverManager.getConnection(url, "sa", "12345");
        return conn;
    }

    public static void main(String[] args) {
        try {
            if (DBUtils.getConnection() != null) {
                System.out.println("1");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
