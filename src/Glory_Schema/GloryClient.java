/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glory_Schema;

import java.io.*;
import java.net.*;
import java.util.Date;

/**
 *
 * @author Ak
 */
public class GloryClient extends GloryElement {

    public static void connectToServer() {
        try {
            Socket socket = new Socket("127.0.0.1", 4000);
            BufferedWriter writerChannel = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader readerChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;

            writerChannel.write(new Date().toString() + "\n\r");
            writerChannel.flush();

            while ((line = readerChannel.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {

        }
//        try {
//            Socket clientSocket = new Socket("127.0.0.7", 7777);
//        } catch (IOException e) {
//        }
    }

}
