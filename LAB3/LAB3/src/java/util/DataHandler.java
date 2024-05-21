package util;

import constant.Regex;

public class DataHandler {

    public static boolean isMatchUserID(String userID) {
        return userID.matches(Regex.USER_ID);
    }

    public static boolean isMatchPasswordAndConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
    
    public static boolean isNameInRange(String name, int begin, int end){
        return name.length() >= begin && name.length() <= end;
    }
    
    public static boolean isEmtpyField(String userID, String name, String password, String confirm){
        return userID.isEmpty() || name.isEmpty() || password.isEmpty() || confirm.isEmpty();
    }

}
