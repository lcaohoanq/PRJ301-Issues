package model;

import constant.EnumRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String userID;
    private String password;
    private String name;
    private int roleID;

    public UserDTO(String userID, String name, String password) {
        this.userID = userID;
        this.name = name;
        this.password = password;
    }
    
    public UserDTO(String userID, String password){
        this.userID = userID;
        this.password = password;
    }

    public int getRoleID() {
        String prefix = this.userID.substring(0, 2);
        return EnumRole.fromPrefix(prefix).getCode();
    }
    
}
