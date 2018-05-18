package Glory_Schema.Classes;

import java.io.*;
import java.net.*;


public class Server {
   
    public static ServerSocket serverSocket;
    static Socket socket;
    static DataOutputStream out;
    public static void main(String[] args) {
       
        try{
         
            System.out.print("starting server....");
            serverSocket=new ServerSocket(7777);
            System.out.println("\n Server started...");
            socket=serverSocket.accept();  
            System.out.println("Connection from : "+socket.getInetAddress() );
            out=new DataOutputStream(socket.getOutputStream());
            out.writeUTF("this is a test java socket");
            System.out.println("data has been sent");
        }
        catch(Exception e)
        {
            
        }
    }
}
