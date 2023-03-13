import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.LinkedList;

public class Server {

    public static void main(String[] args) throws IOException {

        boolean openConnection = true;

        LinkedList<String> usernames = new LinkedList<>();
        LinkedList<String> passwords = new LinkedList<>();

        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server started on port " + 5555);

        Socket socket = new Socket();

        // TODO: Change to manage multiple connections
        while(openConnection) {
            socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());
            openConnection = false;
        }

        OutputStream outputStream = socket.getOutputStream();
        String data = "Connected!";
        outputStream.write(data.getBytes());
    }
}
