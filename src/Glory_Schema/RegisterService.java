package Glory_Schema;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Thanzeel
 */
public class RegisterService extends GloryElement {

    public String userName;
    public String password;
    public String confirmPassword;

    public RegisterService() {

    }

    public void registerUser(RegisterService registeruser) {
        try {

            ResultSet rs = connectionObject.createStatement().executeQuery("select * from users where username='" + registeruser.userName + "'");
            if (rs.next()) {
                if (registeruser.userName.equals(rs.getString(2))) {
                    JOptionPane.showMessageDialog(null, "Username already taken", "Register Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {

                Statement st;
                st = connectionObject.createStatement();
                st.executeUpdate("insert into users(username,password) values('" + registeruser.userName + "','" + registeruser.password + "')");
                JOptionPane.showMessageDialog(null, "You have successfully registered", "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
        }
    }

}
