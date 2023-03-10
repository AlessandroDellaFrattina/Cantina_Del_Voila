package Client;

import java.io.IOException;

public class Receiver extends Thread {
 
    @Override
    public void run() {

        while (Client.isConnected()) {

            try {
             
                String msg = Client.in.readLine();
                System.out.println(msg);
            }

            catch (IOException e) {

                System.err.println("Failed to read the received data");
            }
        }
    }
}
