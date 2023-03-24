import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class Client{

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket();
        Frame frame = new Frame(socket);

        boolean connectionSetup = true;

        while(true) {

            String[] clientOutput = new String[2];

            // Needs to be updated every second
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            // Checks connection before I/O operations
            if(socket.isConnected() && connectionSetup) {

                frame.showRegLogPanels();
                connectionSetup = false;
            }

            // TODO: Get data from GUI text boxes and send it to server
            if(frame.login && !(frame.register)) {

                clientOutput[0] = frame.loginInfo()[0];
                clientOutput[1] = frame.loginInfo()[1];
            }

            if(frame.register && !(frame.login)) {

                clientOutput[0] = frame.registerInfo()[0];
                clientOutput[1] = frame.registerInfo()[1];
            }

            if(clientOutput[0] != null && clientOutput[1] != null) {

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String choice = "";                ; // TRUE: REGISTER    FALSE: LOGIN
                if(frame.register && !frame.login) {

                    choice = "register";
                }

                if(frame.login && !frame.register) {

                    choice = "login";
                }
                out.println(choice);
                out.println(clientOutput[0]);
                out.println(clientOutput[1]);
            }

        }


    }
}
