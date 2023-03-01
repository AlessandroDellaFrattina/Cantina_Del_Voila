import java.io.ByteArrayOutputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JOptionPane;

public class Record {

    static AudioFormat format = new AudioFormat(44100.0f, 16, 1, true, true);
    static TargetDataLine microphone;
    static SourceDataLine speakers;
    static boolean isRunning = true;
    
    public static void main(String[] args) {

        try {

            microphone = AudioSystem.getTargetDataLine(format);
    
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            
            JOptionPane.showMessageDialog(null,"Hit ok to start recording");
            microphone.start();

            Thread audioPlayerThread = new Thread() {

                @Override public void run() {

                    DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, format);
                    try {

                        speakers = (SourceDataLine)AudioSystem.getLine(dataLineInfo);
                        speakers.open(format);
                        speakers.start();

                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        int CHUNK_SIZE = 1024;
                        byte[] data = new byte[microphone.getBufferSize() / 5];
                        int numBytesRead;

                        while (isRunning) {

                            numBytesRead = microphone.read(data, 0, CHUNK_SIZE);
                            out.write(data, 0, numBytesRead); 
                            speakers.write(data, 0, numBytesRead);
                        }
                    }

                    catch (LineUnavailableException e) {

                        e.printStackTrace();
                    }
                }
            };
    
            audioPlayerThread.start();

            JOptionPane.showMessageDialog(null,"Hit ok to stop recording");
            isRunning = false;

            speakers.drain();
            speakers.close();
            microphone.close();
        }

        catch (LineUnavailableException e) {

            e.printStackTrace();
        }
    }
}
