/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.dtos;

/**
 *
 * @author leyen
 */
public class UserDTO {

    private String fullname;
    private String userID;

    private String password;
    private String roleID;

    public UserDTO(String fullname, String userID, String password) {
        this.fullname = fullname;
        this.userID = userID;

        this.password = password;
        this.roleID = "US";
    }

    public UserDTO(String fullname, String userID, String password, String roleID) {
        this.fullname = fullname;
        this.userID = userID;
        this.password = password;
        this.roleID = roleID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "fullname=" + fullname + ", userID=" + userID + ", password=" + password + ", roleID=" + roleID + '}';
    }

}
