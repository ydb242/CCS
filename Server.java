import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int portNumber = 5000;
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started on port " + portNumber);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection established with client " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received message from client: " + inputLine);
                out.println("Server response: " + inputLine);
            }

            in.close();
            out.close();
            clientSocket.close();
        }
    }
}