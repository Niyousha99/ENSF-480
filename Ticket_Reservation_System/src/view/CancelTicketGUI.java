package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.*;

public class CancelTicketGUI extends JFrame implements DocumentListener{
	
	private Button confirmCancel;
	private Reservation theRes;
	private JTextField selectSeatsText;
	private String[] seats; // seats to cancel
	private ArrayList<Ticket> tickets;
	private double refund;
	
	public CancelTicketGUI(Reservation r) {
		super("Cancel Ticket");
		theRes = r;
		tickets = new ArrayList<Ticket>();
		setSize(600, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		//test = new Reservation(0);
		displayReservation();
	}
	
	private void displayReservation() {
		JPanel resPanel = new JPanel();
		resPanel.setBackground(Color.LIGHT_GRAY);
		
		JTextArea text = new JTextArea();
		text.setBackground(Color.LIGHT_GRAY);
		text.setPreferredSize(new Dimension(500, 500));
		text.setEditable(false);
		text.setFont(new Font("Arial", Font.PLAIN, 15));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setText(cancelationInfo());
		resPanel.add(text);
		
		JPanel selectSeatsPanel = new JPanel();
		selectSeatsPanel.setBackground(Color.DARK_GRAY);
		selectSeatsText = new JTextField(30);
		selectSeatsText.getDocument().addDocumentListener(this);
		selectSeatsText.setPreferredSize(new Dimension(100, 25));
		selectSeatsText.setAlignmentX(Component.CENTER_ALIGNMENT);
		selectSeatsPanel.add(selectSeatsText);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.DARK_GRAY);
		confirmCancel = new Button("Confirm Cancellation");
		confirmCancel.setPreferredSize(new Dimension(200, 25));
		buttonPanel.setSize(new Dimension(200, 30));
		confirmCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(confirmCancel);
		
		Container contentPane = getContentPane();
		contentPane.add(resPanel);
		contentPane.add(selectSeatsPanel);
		contentPane.add(buttonPanel);
	}

	public String cancelationInfo() {
		String s = "";
		s+= theRes.toString();
		if(theRes.getUserType() == 0) {
			s += "\n\n Because you are not a registered user you will have to pay a 15% cancellation fee\n";
		}
		s+= "\n\n\n Please input the seats you'd like to cancel, separated by a space";
		return s;
	}
	
	public void displayRefundAmount() {
		double total = tickets.size() * 12.50;
		refund = total;
		if(theRes.getUserType() == 0) {
			total = total* 0.15;
			refund = tickets.size() * 12.50 - total;
		}
		refund = Math.round(refund * 100.0) / 100.0;
		JOptionPane.showMessageDialog(null, "Cancellation completed. $" + String.format("%.2f", refund) + " has been deposited into your account.");
	}
	
	public boolean setTickets() {
		for(int i = 0; i < seats.length; i++) {
			if(theRes.getTicket(seats[i]) != null) {
				tickets.add(theRes.getTicket(seats[i]));
			}else return false;
		}
		return true;
	}
	
	private boolean seatsEntered() {
		if (selectSeatsText.getText().trim().length() != 0) 
			return true;
		
		return false;
	}
	
	private void checkInput() {
		confirmCancel.setEnabled(seatsEntered());
	}
	
	public void displayErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {checkInput();}

	@Override
	public void removeUpdate(DocumentEvent e) {checkInput();}

	@Override
	public void changedUpdate(DocumentEvent e) {}
	
	public String getSeatsEntered() {return selectSeatsText.getText();}
	
	public ArrayList<Ticket> getTickets(){return tickets;}
	
	public double getRefund() {return refund;}
	
	public Button getConfirmCancelButton() {return confirmCancel;}
	
	public String[] getSeats() {return seats;}

	public void setSeats(String[] seats) {this.seats = seats;}
	
}
