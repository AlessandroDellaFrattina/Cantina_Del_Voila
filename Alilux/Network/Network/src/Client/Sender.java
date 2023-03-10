package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sender extends Thread {
    
    @Override
    public void run() {

        while (Client.isConnected()) {

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            try {

                String msg = keyboard.readLine();
                Client.out.write(msg);
            }

            catch (IOException e) {

                System.err.println("Failed to send the message");
            }
        }
    }
}
