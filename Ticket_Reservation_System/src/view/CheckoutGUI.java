package view;
import model.*;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CheckoutGUI extends JFrame{
	
	
	public CheckoutGUI(Movie selectedMovie, String selectedShowtime, ArrayList<Seat> selectedSeats) {
		super("Checkout");
		setBounds(700, 250, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout());
		
		
		
	}
	
	
	/**
	 * Displays message supplied by the given parameter in a dialog box
	 * @param message is the message to display
	 */
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
