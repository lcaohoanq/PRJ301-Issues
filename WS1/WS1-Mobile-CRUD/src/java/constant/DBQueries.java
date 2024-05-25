package constant;

public class DBQueries {
    // User
    public static final String USER_LOGIN = "SELECT userId, password FROM tbl_User WHERE userId=? AND password=? ";
    public static final String USER_SEARCH = "SELECT userId, fullName, role FROM tbl_User WHERE fullName like ?";
    public static final String USER_PASSWORD = "SELECT password FROM tbl_User WHERE userId = ?";
    public static final String USER_SELECT_ALL = "SELECT * FROM tbl_User";
    public static final String USER_DELETE = "DELETE tbl_User WHERE userId=?";
    public static final String USER_UPDATE = "UPDATE tbl_User SET fullName=?, role=? WHERE userId=?";
    public static final String USER_CHECK_DUPLICATE = "SELECT userId FROM tbl_User WHERE userId=?  ";
    public static final String USER_INSERT = "INSERT INTO tbl_User(userId, password, fullName, role) " + "VALUES(?,?,?,?)";
    
    // MObile
    public static final String SELECT_ALL_MOBILE = "SELECT * FROM tbl_Mobile";
}
