package model;

public class UserDTO {

    private String userID;
    private String name;
    private String password;
    private String roleID;

    public UserDTO() {
    }

    public UserDTO(String userID, String name, String password) {
        this.userID = userID;
        this.name = name;
        this.password = password;
    }
    
    public UserDTO(String userID, String name, String roleID, String password){
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

    public String getRoleID() {
        return this.userID.substring(0, 2);
    }
    public void setRoleID(String roleID){
        
    }

}
