package com.lcaohoanq.DTO;

public class UserDTO {

    private String userID;
    private String fullName;
    private String roleID;
    private String password;

    public UserDTO(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public UserDTO(String userID, String fullName, String roleID, String password) {
        this.userID = userID;
        this.fullName = fullName;
        this.roleID = roleID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public static boolean isAdmin(String userID, String password) {
        return userID.equals("admin") && password.equals("admin");
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", fullName=" + fullName + ", roleID=" + roleID + ", password=" + password + '}';
    }
    
}
