package Glory_Schema;

import java.io.*;
import java.net.*;

public class GloryGame {

    static Socket socket;
    static DataInputStream in;
    
    public static void main(String[] args) {
        try{
            System.out.println("Connecting...");
            socket=new Socket("localhost",7777);
            System.out.println("connection successfull");
            in =new DataInputStream(socket.getInputStream());
            System.out.println("Receiving information");
            String test=in.readUTF();
            System.out.println("Message from sever: "+test);
            
            Socket server=new Socket("localhost",7777);
            System.out.println("\n connection successfull test2");
            in =new DataInputStream(server.getInputStream());
            System.out.println("\n Receiving information 2");
             test=in.readUTF();
            System.out.println("\n Second call to serverMessage from sever: "+test);
        }
        
        catch(Exception e )
        {}
    }
}