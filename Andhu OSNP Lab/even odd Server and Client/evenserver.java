import java.net.*;
import java.io.*;
public class evenserver {
    public static void main(String args[]) throws Exception {
        // Create ServerSocket on port 8003
        ServerSocket ss = new ServerSocket(8003);
        System.out.println("Server is running...");
        // Accept client connection
        Socket s = ss.accept();
        System.out.println("Client connected");
        // Create input and output streams
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        // Variable to store the result
        String result = "";
        // Read an integer from the client
        int number = din.readInt();
        System.out.println("Number received: " + number);
        // Check if the number is even or odd
        if (number % 2 == 0) {
            result = "even";
        } else {
            result = "odd";
        }
        // Send the result back to the client
        dout.writeUTF("The number " + number + " is " + result);
        dout.flush();
        // Close the streams and socket
        din.close();
        dout.close();
        s.close();
        ss.close();
        System.out.println("Server closed");
    }
}

