/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glory_Schema;

import java.io.*;
import java.net.*;

/**
 *
 * @author Ak
 */
public class GloryClient extends GloryElement {

    private static Socket socket;
    static int minPlayers = 0;

    public GloryClient() {
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
            System.out.println("Message sent to the server : " + toServer);

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String fromServer = br.readLine();
            System.out.println("Message received from the server : " + fromServer);

            minPlayers=minNumberOfPlayers = Integer.parseInt(fromServer);
            System.out.println("minNumberOfPlayers " + minNumberOfPlayers);
            setNumber(minPlayers);

        } catch (Exception ex) {
            System.out.println("Unable to start client");
        }
    }

    public   int getMinimumNumberOfPlayers() {

        return minNumberOfPlayers;
    }
}
