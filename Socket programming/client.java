import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        String serverHost = "localhost"; // Replace with the server host address
        int serverPort = 1234; // Replace with the server port number
         Scanner sc =new Scanner(System.in);
        String msg = sc.nextLine();
        
        try {
            // Create a socket and connect to the server
            Socket socket = new Socket(serverHost, serverPort);
            
            // Get the input/output streams for reading/writing data
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            
            // Create readers and writers for easier communication
            PrintWriter writer = new PrintWriter(outputStream, true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            // Send data to the server
            String messageToSend = msg;
            writer.println(messageToSend);
            
            // Receive data from the server
            String receivedMessage = reader.readLine();
            System.out.println("Server says: " + receivedMessage);
            
            // Close the socket and streams when done
            socket.close();
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}