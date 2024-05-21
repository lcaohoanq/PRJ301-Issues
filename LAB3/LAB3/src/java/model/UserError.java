/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hd
 */
public class UserError {
    private String userID;
    private String name;
    private String password;
    private String confirm;
    private String tickBox;

    public UserError() {
        this.userID = "";
        this.name = "";
        this.password = "";
        this.confirm = "";
        this.tickBox = "";
    }

    public UserError(String userID, String name, String password, String confirm) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.confirm = confirm;
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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getTickBox() {
        return tickBox;
    }

    public void setTickBox(String tickBox) {
        this.tickBox = tickBox;
    }

    
    
}
