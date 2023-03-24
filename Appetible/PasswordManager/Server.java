import java.io.BufferedReader;
import java.io.InputStreamReader;
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

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String choice = in.readLine();
            if(choice == "register") {
                register(in, usernames, passwords);
            }

            if(choice == "login") {
                login(in, usernames, passwords);
            }
        }

        OutputStream outputStream = socket.getOutputStream();
        String data = "Connected!";
        outputStream.write(data.getBytes());
    }

    private static void login(BufferedReader in, LinkedList<String> usernames, LinkedList<String> passwords) throws IOException {

        String user = in.readLine();
        String pass = in.readLine();

        for(int i = 0; i < usernames.size(); i++) {

            if(usernames.get(i).equals(user)) {

                if(passwords.get(i).equals(pass)) {

                   System.out.println("Access granted!"); 
                }
                else {

                    System.out.println("Access denied! NIGGA!");
                }
            }
        }
                
        System.out.println("Username: " + user);
        System.out.println("Password: " + pass);
    }

    public static void register(BufferedReader in, LinkedList<String> usernames, LinkedList<String> passwords) throws IOException {

        String user = in.readLine();

        for(String tmp : usernames) {

            if(tmp.equals(user)) {

               System.err.println("Username already registered!"); 
               return;
            }
        }
        usernames.add(user);

        String pass = in.readLine();
        passwords.add(pass);
        
        System.out.println("Username: " + user);
        System.out.println("Password: " + pass);

        return;
    }
}
