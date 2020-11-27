package view;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CheckoutGUI extends JFrame{

	
	/**
	 * Displays message supplied by the given parameter in a dialog box
	 * @param message is the message to display
	 */
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
