package Server;

import java.net.*;
import java.io.*;

public class Server {
    
    static ServerSocket server;
    static final short port = 25565;
    static Socket[] clients;

    public void accept() throws IOException {

        server.accept();
    }

    public static void main(String[] args) {

        try {

            server = new ServerSocket(port);

            
        }

        catch (IOException e) {

            e.printStackTrace();
        }
    }
}
