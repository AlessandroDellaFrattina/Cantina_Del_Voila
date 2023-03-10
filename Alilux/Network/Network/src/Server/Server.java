package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Server {

    public void accept() throws IOException {

        clients.add(m_server.accept());
    }

    public void receiveAndSend() {
  
        for (int i = 0; i < clients.size(); i++) {

            try {

                //@TODO: Fix every-fucking-thing

                BufferedReader in = new BufferedReader(new InputStreamReader(clients.get(i).getInputStream()));

                System.out.println(in.readLine());

                Thread t = new Thread() {

                    public void run() {

                        for (int i = 0; i < clients.size(); i++) {

                            try {

                                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(Server.clients.get(i).getOutputStream()));


                            }

                            catch (IOException e) {

                                e.printStackTrace();
                            }
                        }
                    }
                };

                t.start();

                String msg = in.readLine();
                System.out.println(msg);
            }

            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    private static ServerSocket m_server = null;
    public static final short port = 25565;
    public static LinkedList<Socket> clients = new LinkedList<Socket>();
    public static BufferedReader in = null;
    public static BufferedWriter out = null;
}
