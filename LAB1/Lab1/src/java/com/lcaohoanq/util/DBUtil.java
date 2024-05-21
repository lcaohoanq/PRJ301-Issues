package com.lcaohoanq.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static final Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:1433;databaseName=UserManagement";
        conn= DriverManager.getConnection(url, "sa", "12345");
        return conn;
    }
    
    public static void main(String[] args) {
        try ( Connection conn = DBUtil.getConnection()) {
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