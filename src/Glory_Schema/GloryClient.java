/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glory_Schema;

import java.io.*;
import java.net.*;
import java.util.Scanner;


/**
 *
 * @author Ak
 */
public class GloryClient {

    Socket s;
    DataInputStream din;
    DataOutputStream dout;

    public static void main(String[] args) {

        new GloryClient();
    }

    public GloryClient() {
        try {
            s = new Socket("localhost", 7777);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            listenForInput();
        } catch (UnknownHostException e) {
            
        } catch (IOException e) {
            
        }
    }

    public void listenForInput() {
        Scanner console = new Scanner(System.in);
        while (true) {
            while (!console.hasNextLine()) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    
                }
            }

            String input = console.nextLine();

            if (input.toLowerCase().equals("quit")) {
                break;
            }

            try {
                dout.writeUTF(input);

                while (din.available() == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        
                    }
                }

                String reply = din.readUTF();
                System.out.println(reply);
            } catch (IOException ex) {
                
                break;
            }
        }

        try {
            din.close();
            dout.close();
            s.close();
        } catch (IOException ex) {
            
        }
    }
}
//public class GloryClient extends GloryElement{
//
//    public static void connectToServer() {
//        try {
//            Socket socket = new Socket("127.0.0.1", 4000);
//            BufferedWriter writerChannel = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            BufferedReader readerChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String line;
//
//            writerChannel.write(new Date().toString() + "\n\r");
//            writerChannel.flush();
//
//            while ((line = readerChannel.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (Exception e) {
//
//        }
////        try {
////            Socket clientSocket = new Socket("127.0.0.7", 7777);
////        } catch (IOException e) {
////        }
//    }
//
//}
