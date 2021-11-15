package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println("Server start");
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("connection client");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outPut = new PrintWriter(clientSocket.getOutputStream(), true);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Server message:" + line);
                outPut.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
