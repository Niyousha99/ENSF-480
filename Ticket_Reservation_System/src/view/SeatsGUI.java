package view;
import model.*;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SeatsGUI extends JFrame{
	
	/**
	 * Components of the frame 
	 */
	private Button reserve, proceed, back;
	
	private ArrayList<Seat> seats;
	private ArrayList<Seat> selectedSeats;
	
	public SeatsGUI(ArrayList<Seat> s) {
		super("View Seats");
		setBounds(200, 100, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout());
		
		JLabel background = new JLabel(new ImageIcon("img/curtains.jpg"));
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		
		
		
		add(background);
		pack();
	}
	
	// TODO add error-checking: if seat not available
	public void selectSeat(Seat selection) {
		selectedSeats.add(selection);
	}

	public Button getReserveButton() {
		return reserve;
	}

	public Button getProceedButton() {
		return proceed;
	}

	public Button getBackButton() {
		return back;
	}

	public ArrayList<Seat> getSelectedSeats() {
		return selectedSeats;
	}
}
