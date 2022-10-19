import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GUI {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		ImageIcon image = new ImageIcon("resources/duce.jpg");
		frame.setIconImage(image.getImage());
		JLabel label = new JLabel();
		label.setIcon(image);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		frame.setVisible(true);
		frame.add(label);
		frame.pack();
	}
}
