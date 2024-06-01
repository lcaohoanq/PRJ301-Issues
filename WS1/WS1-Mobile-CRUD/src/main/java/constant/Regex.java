package constant;

public class Regex {
    public static final String USER_ID = "^(MN|ST|US)[a-zA-Z0-9]+\\d*$";
    public static final String MOBILE_SEARCH_RANGE = "^\\d+,\\d+$";
    public static final String MOBILE_ID = "^MOB\\d{3}$";
    public static final String MOBILE_NAME = "^[a-zA-Z0-9 ]+$";
    public static final String MOBILE_PRICE = "^\\d+(\\.\\d+)?$";
    public static final String MOBILE_YEAR = "^\\d{4}$";
    public static final String MOBILE_QUANTITY = "^\\d+$";
    public static final String MOBILE_NOT_SALE = "^[01]$";
    public static final String MOBILE_DESCRIPTION = "^[a-zA-Z0-9 ]+$";
    public static final String HASHED_PASSWORD = "\\$31\\$(\\d\\d?)\\$(.{43})"; // format for pbkdf2
}
