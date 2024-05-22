package model;

import constant.EnumRole;

public class UserDTO {

    private String userID;
    private String name;
    private String password;
    private int roleID;

    public UserDTO() {
    }

    public UserDTO(String userID, String name, String password) {
        this.userID = userID;
        this.name = name;
        this.password = password;
    }
    
    public UserDTO(String userID,String password, String name, int roleID){
        this.userID = userID;
        this.name = name;
        this.roleID = roleID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        String prefix = this.userID.substring(0, 2);
        return EnumRole.fromPrefix(prefix).getCode();
    }
    
    public void setRoleID(String roleID){
        
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", name=" + name + ", password=" + password + ", roleID=" + roleID + '}';
    }
    
    

}
