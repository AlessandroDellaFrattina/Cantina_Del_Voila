import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Serializable {
    public static void main(String[] args) throws IOException {

        // Connection to Server
        Socket s = new Socket("localhost", 8080);

        // IO channel initialization
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        Scanner in = new Scanner(System.in);

        // Input request
        System.out.print("Input > ");
        String input = in.nextLine();
        out.println(input);

        // Close connection
        in.close();
        s.close();
    }
}
