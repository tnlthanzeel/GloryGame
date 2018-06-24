/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glory_Schema;

import static Glory_Schema.GloryClient.minPlayers;
import static Glory_Schema.GloryElement.playerName;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;

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
                playerName = rs.getString(2);
                isValidUser = true;
            } else {
                isValidUser = false;
            }
        } catch (SQLException ex) {
            isValidUser = false;
        }
        return isValidUser;
    }

    public static int checkIfClientsConnected() {
        Socket socket;
        try {
            String host = "localhost";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            String toServer = playerName + "\n";
            bw.write(toServer);
            bw.flush();
            System.out.println("Message sent to the server from login : " + toServer);

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String fromServer = br.readLine();
            System.out.println("Message received from the server : " + fromServer);

            minPlayers = minNumberOfPlayers = Integer.parseInt(fromServer);
            System.out.println("minNumberOfPlayers fro login " + minNumberOfPlayers);

        } catch (Exception ex) {
            System.out.println("Unable to start client");
        }
        return minPlayers;
    }
}
