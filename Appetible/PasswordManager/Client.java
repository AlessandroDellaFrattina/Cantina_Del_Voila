import java.net.Socket;

public class Client{

    public static void main(String[] args) {

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
            clientOutput[0] = frame.loginInfo()[0];
            clientOutput[1] = frame.loginInfo()[1];



        }


    }
}
