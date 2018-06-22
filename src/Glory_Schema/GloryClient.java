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
public class GloryClient implements Runnable {

    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;
    int playerid;
    int[] sc = new int[4];

    public GloryClient() {
        try {
            System.out.println("Connecting...");
            socket = new Socket("localhost", 7777);
            System.out.println("Connection Successful");
            in = new DataInputStream(socket.getInputStream());
            playerid = in.readInt();
            out = new DataOutputStream(socket.getOutputStream());
            Input input = new Input(in, this);
            Thread thread = new Thread(input);
            thread.start();
            Thread thread2 = new Thread();
            thread2.start();
        } catch (IOException ex) {
            System.out.println("Unable to start client");
        }
    }

    public void updateScore(int pid, int score) {
        this.sc[pid] = score;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GloryClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class Input implements Runnable {

    DataInputStream in;
    GloryClient client;

    public Input(DataInputStream in, GloryClient c) {
        this.in = in;
        this.client = c;
    }

    public void run() {
        while (true) {
            try {
                int playerid = in.readInt();
                int playerscore = in.readInt();
                client.updateScore(playerid, 1000);
            } catch (IOException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
