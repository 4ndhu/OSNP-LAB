import java.net.*;
import java.io.*;
public class evenclient {
    public static void main(String args[]) throws Exception {
  // Connect to the server at localhost on port 8003
        Socket s = new Socket("localhost", 8003);
        System.out.println("\nConnected to server");
  // Create input and output streams
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
  // Create BufferedReader for user input
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
 // Take user input (integer number) and send to server
        System.out.print("Enter a number: ");
        int num = Integer.parseInt(userInput.readLine());    
        // Send the number to the server
        dout.writeInt(num);
        dout.flush();
        // Receive response from server
        String response = din.readUTF();
        System.out.println("\nServer: " + response);
        // Close streams and socket
        dout.close();
        din.close();
        s.close();
    }
}

