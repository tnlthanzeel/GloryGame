/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glory_Schema;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thanzeel
 */
public class LoginService extends GloryElement {

    public String userName;
    public String password;
    boolean isValidUser;

    public boolean authenticateUser(LoginService loginService) {
        try {
            ResultSet rs = connectionObject.createStatement().executeQuery("select * from users where username='" + loginService.userName + "' AND password='" + loginService.password + "'");
            if (rs.next()) {
                isValidUser = true;
            } else {
                isValidUser = false;
            }
        } catch (SQLException ex) {
            isValidUser = false;
        }
        return isValidUser;
    }
}
