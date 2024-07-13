/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.prj301.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hd
 */
public class DBUtils {
    private static final String DB_NAME="PE_PRJ301_293";
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
                System.out.println("1");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}