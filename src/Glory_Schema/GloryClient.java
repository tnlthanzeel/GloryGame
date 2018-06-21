/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glory_Schema;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ak
 */
public class GloryClient {

    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;

    public GloryClient() {
        try {
            System.out.println("Connecting...");
            socket = new Socket("localhost", 7777);
            System.out.println("Connection Successful");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Input input = new Input(in);
            Thread thread = new Thread(input);
            thread.start();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your Username:");
            String name = sc.nextLine();
            out.writeUTF(name);
            while (true) {
                String str = sc.nextLine();
                out.writeUTF(str);
            }
        } catch (IOException ex) {
            Logger.getLogger(GloryClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Input implements Runnable {

    DataInputStream in;

    public Input(DataInputStream in) {
        this.in = in;
    }

    public void run() {
        while (true) {
            String msg;
            try {
                msg = in.readUTF();
                System.out.println(msg);
            } catch (IOException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
