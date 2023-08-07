import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class server {
    public static void main(String[] args) {
        int port = 1234; // Specify the port number you want to use
        Scanner sc =new Scanner(System.in);
        String msg = sc.nextLine();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for client connection...");
            
            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
            
            // Create output stream to send data to the client
            OutputStream outputStream = clientSocket.getOutputStream();
            
            // Send custom message to the client
            String message = msg;
            outputStream.write(message.getBytes());
            outputStream.flush();
            
            System.out.println("Message sent: " + message);
            
            // Close the connection
            outputStream.close();
            clientSocket.close();
            serverSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}