import java.io.*;
import java.net.*;

public class paragraphclient {
    public static void main(String[] args) {
  
           
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server.");

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

          
            System.out.println("Enter a paragraph of text (end input with an empty line):");
            String line;
            while (!(line = reader.readLine()).isEmpty()) {
                output.println(line);
            }
            output.println();  
            
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = input.readLine();
            System.out.println("Response from server: " + response);
			 socket.close();
    
    }
}
