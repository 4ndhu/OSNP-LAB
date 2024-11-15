import java.io.*;
import java.net.*;

public class paragraphserver {
    public static void main(String[] args) {
        try {
           
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started. Waiting for a client...");

           
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder paragraph = new StringBuilder();
            String line;
            
            
            while ((line = input.readLine()) != null && !line.isEmpty()) {
                paragraph.append(line).append("\n");
            }
            String paragraphText = paragraph.toString();
            System.out.println("Received paragraph from client:\n" + paragraphText);

         
            int wordCount = paragraphText.split("\\s+").length;
            int spaceCount = paragraphText.length() - paragraphText.replace(" ", "").length();
            int lineCount = paragraphText.split("\n").length;

            
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Word Count: " + wordCount + ", Space Count: " + spaceCount + ", Line Count: " + lineCount);

            
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

