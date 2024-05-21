package constant;

public class DBQueries {
    // User
    public static final String USER_LOGIN = "SELECT fullName, roleID FROM tblUsers WHERE userID=? AND password=? ";
    public static final String USER_SEARCH = "SELECT userID, fullName, roleID FROM tblUsers WHERE fullName like ?";
    public static final String USER_DELETE = "DELETE tblUsers WHERE userID=?";
    public static final String USER_UPDATE = "UPDATE tblUsers SET fullName=?, roleID=? WHERE userID=?";
    public static final String USER_CHECK_DUPLICATE = "SELECT userID FROM tblUsers WHERE userID=?  ";
    public static final String USER_INSERT = "INSERT INTO tblUsers(userId, fullName, roleID, password) " + "VALUES(?,?,?,?)";
    
    // Book
    public static final String SELECT_ALL_BOOK = "SELECT * FROM tblBooks";
}
