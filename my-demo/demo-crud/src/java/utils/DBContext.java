
package utils;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }   
    /*Insert your other code right after this comment*/
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "Student_PE_PRJ301_Fall_Day9";
    private final String portNumber = "1433";
    private final String instance="";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "sa";
    private final String password = "Luucaohoang1604^^";
    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());
            //If success: ConnectionID:1 ...
            //If fail: Login failed for user 'sa'. ClientConnectionId:0b476a72-0c79-467e-ba14-ef7064bde5a2
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
 