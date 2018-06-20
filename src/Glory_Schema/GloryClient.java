/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glory_Schema;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Ak
 */
public class GloryClient {

    /**
     * Creates a new instance of Client
     */
    private Socket clientSocket;
    private String hostName;
    private int serverPort;
    private DataInputStream reader;
    private DataOutputStream writer;
    private Protocol protocol;

    private static GloryClient client;

    public GloryClient() {
        protocol = new Protocol();
    }

    public void register(String Ip, int port, int posX, int posY) throws IOException {
        this.serverPort = port;
        this.hostName = Ip;
        clientSocket = new Socket(Ip, port);
        writer = new DataOutputStream(clientSocket.getOutputStream());

        writer.writeUTF(protocol.RegisterPacket(posX, posY));

    }

    public void sendToServer(String message) {
        if (message.equals("exit")) {
            System.exit(0);
        } else {
            try {
                Socket s = new Socket(hostName, serverPort);
                System.out.println(message);
                writer = new DataOutputStream(s.getOutputStream());
                writer.writeUTF(message);
            } catch (IOException ex) {

            }
        }

    }

    public Socket getSocket() {
        return clientSocket;
    }

    public String getIP() {
        return hostName;
    }

    public static GloryClient getGameClient() {
        if (client == null) {
            try {
                client = new GloryClient();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return client;
    }

    public void closeAll() {
        try {
            reader.close();
            writer.close();
            clientSocket.close();
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
