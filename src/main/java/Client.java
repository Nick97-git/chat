import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        Scanner scanner = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            System.out.println("Client started");
            socket = new Socket("localhost", 4444);
            scanner = new Scanner(System.in);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String text = "";
            while (!text.equals("stop")) {
                System.out.println("Type your message");
                text = scanner.nextLine();
                System.out.println("REPEAT: " + text);
                writer.write(text + "\n");
                writer.flush();
                System.out.println("Written");
                String serverAnswer = reader.readLine();
                System.out.println("SERVER: " + serverAnswer);
            }
        } catch (IOException e) {
            System.out.println("MISTAKE!!!");
        } finally {
            socket.close();
            reader.close();
            writer.close();
            scanner.close();
        }
    }

    @Override
    public void run() {
        super.run();
    }
}
