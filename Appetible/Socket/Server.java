import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
    public static void main(String[] args) throws IOException {

        try {

        ServerSocket ss = new ServerSocket(8080);
        Socket s = ss.accept();

        // If client connects, display its infos.
        System.out.println("Client connected");
        System.out.println(s.toString());

        // If client connects, initialize I/O channels
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // Request input from client
        String input = in.readLine();
        System.out.println("Client input > " + input);

        // Close connection
        ss.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
