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

    public boolean authenticateUser(LoginService loginService) {

    //ResultSet rs = connectionObject.createStatement().executeQuery("select * from cusdet where dcusid='" + loginService.userName + "'");
            //if (rs.next()) {
        // userName = rs.getString(1);
        //password = rs.getString(2);
//                if (tempid.equals(un) && temppass.equals(tmp) && st == 0) {
//
//                    jPasswordField1.setText("");
//                    Customer c = new Customer();
//                    this.hide();
//                    c.clogin(tempid);
//
//                } else if (tempid.equals(un) && temppass.equals(tmp) && st == 1) {
//                    jLabel10.setVisible(true);
//                    jLabel10.setText("User Blocked");
//
//                } else {
//                    jLabel10.setVisible(true);
//                    jLabel10.setText("Invalid User ID or password");
//                }
        return true;
    }
}