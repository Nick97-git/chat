import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            System.out.println("Server launched");
            serverSocket = new ServerSocket(4444);
            socket = serverSocket.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String clientMsg = "";
            while (!clientMsg.equals("stop")) {
            System.out.println("Waiting for client message");
            clientMsg = reader.readLine();
            System.out.println("CLIENT: " + clientMsg);
            writer.write("SERVER read the message" + "\n");
            writer.flush();
            }
        } catch (IOException e) {
            System.out.println("SERVER MISTAKE");
        } finally {
            serverSocket.close();
            socket.close();
            reader.close();
            writer.close();
        }
    }
}
