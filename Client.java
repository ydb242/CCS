import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverName = "10.251.150.228"; // Replace with the IP address of the server computer
        int portNumber = 8080;

        try (
                Socket clientSocket = new Socket(serverName, portNumber);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Received server response: " + response);
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + serverName);
            System.exit(1);
        }
    }
}
