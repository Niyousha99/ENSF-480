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
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		//test = new Reservation(0);
		displayReservation();
	}
	
	private void displayReservation() {
		JPanel resPanel = new JPanel();
		//resPanel.setBounds(0, 0, 100, 100);
		resPanel.setBackground(Color.WHITE);
		resPanel.setLayout(new BoxLayout(resPanel, BoxLayout.Y_AXIS));
		
		JTextArea text = new JTextArea();
		text.setBackground(Color.DARK_GRAY);
		text.setForeground(Color.WHITE);
		//resPanel.setSize(200, 200);
		//text.setBounds(10, 10, 564, 520);
		text.setSize(600, 300);
		text.setPreferredSize(new Dimension(600, 300));
		text.setEditable(false);
		text.setFont(new Font("Arial", Font.PLAIN, 15));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setText(cancelationInfo());
		resPanel.add(text);
		
		JPanel selectSeatsPanel = new JPanel();
		//selectSeatsPanel.setBounds(0, 200, 100, 100);
		selectSeatsPanel.setBackground(Color.WHITE);
		selectSeatsText = new JTextField(20);
		
		selectSeatsText.getDocument().addDocumentListener(this); //ADDED
		
		selectSeatsText.setPreferredSize(new Dimension(80, 25));
		selectSeatsPanel.setLayout(new BoxLayout(selectSeatsPanel, BoxLayout.Y_AXIS));
		//selectSeatsText.setBounds(10, 50, 10, 20);
		selectSeatsText.setMaximumSize(selectSeatsText.getPreferredSize());
		//selectSeatsText.setSize(120, 20);
		selectSeatsText.setAlignmentX(Component.CENTER_ALIGNMENT);
		selectSeatsPanel.add(selectSeatsText);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		confirmCancel = new Button("Confirm Cancellation");
		confirmCancel.setSize(80, 25);
		confirmCancel.setPreferredSize(new Dimension(80, 25));
		buttonPanel.add(confirmCancel);
		
		Container contentPane = getContentPane();
		contentPane.add(resPanel, BorderLayout.PAGE_START);
		contentPane.add(selectSeatsPanel, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.PAGE_END);
	}

	public String cancelationInfo() {
		System.out.println("ticket size: " + tickets.size());
		//double total = tickets.size() * 12.50 *0.15;
		double total = 2 * 12.50 *0.15;
		total = Math.round(total * 100.0) / 100.0;
		//refund = tickets.size() * 12.50 - total;
		refund = 2 * 12.50 - total;
		refund = Math.round(refund * 100.0) / 100.0;
		String s = "";
		s+= theRes.toString();
		if(theRes.getUserType() == 0) {
			s += "\n\n Becasue you are not a registered user you will have to pay a 15% cancellation fee\n";
			s += "Cancellation fee: " + "$"+total;
		}
		return s;
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
