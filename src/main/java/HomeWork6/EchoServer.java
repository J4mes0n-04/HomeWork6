package HomeWork6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8083)) {
            System.out.println("Server started");
            socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String data = inputStream.readUTF();
                if ("/end".equals(data)){
                    break;
                }

                outputStream.writeUTF("Echo: " + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}