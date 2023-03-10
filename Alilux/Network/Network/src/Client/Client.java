package Client;

import java.net.*;
import java.io.*;

public final class Client {

    public static void connect(String address, int port) {

        try {

            m_socket = new Socket(address, port);
            in = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(m_socket.getOutputStream()));

            m_sender.start();
            m_receiver.start();
        }

        catch (UnknownHostException e) {

            System.err.println("ERROR: " + address + ":" + port + " is an unknown host");
        }

        catch (ConnectException e) {

            System.err.println("ERROR: The connection was refused remotely (e.g., no process is listening on the remote address/port)");
        }

        catch (IOException e) {

            e.printStackTrace();
        }
    }
    
    public static boolean isConnected() {

        return m_socket.isConnected();
    }

    public static BufferedReader in = null;
    public static BufferedWriter out = null;

    private static Socket m_socket = null;
    private static Sender m_sender = new Sender();
    private static Receiver m_receiver = new Receiver();
}
