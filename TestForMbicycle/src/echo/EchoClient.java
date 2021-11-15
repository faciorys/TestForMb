package echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        System.out.println("Echo client.......");
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            Socket socket = new Socket(localHost, 8000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("we are connected to server ... ");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter text: ");
                String input = scanner.nextLine();
                if ("exit".equals(input)) {
                    break;
                }
                out.println(input);
                String response = buf.readLine();
                System.out.println("Server message " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
