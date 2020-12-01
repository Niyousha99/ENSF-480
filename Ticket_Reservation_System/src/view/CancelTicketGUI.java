package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.*;

public class CancelTicketGUI extends JFrame {
	
	private Button confirmCancel;
	private Reservation theRes;
	private JTextField selectSeatsText;
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
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 100, 100);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		add(panel, BorderLayout.NORTH);
		
		JTextArea text = new JTextArea();
		text.setBackground(Color.DARK_GRAY);
		text.setForeground(Color.WHITE);
		text.setBounds(10, 10, 564, 520);
		text.setEditable(false);
		text.setFont(new Font("Arial", Font.PLAIN, 15));
		text.setLineWrap(true);
		text.setText(cancelationInfo());
		panel.add(text);
		
		JPanel selectSeatsPanel = new JPanel();
		selectSeatsPanel.setBounds(0, 200, 100, 100);
		selectSeatsPanel.setBackground(Color.BLACK);
		selectSeatsText = new JTextField(20);
		selectSeatsText.setBounds(10, 50, 10, 20);
		selectSeatsPanel.add(selectSeatsText);
		add(selectSeatsPanel, BorderLayout.CENTER);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		confirmCancel = new Button("Confirm Cancellation");
		confirmCancel.setSize(80, 25);
		buttonPanel.add(confirmCancel);
		add(buttonPanel, BorderLayout.SOUTH);
		
		
		selectSeatsText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		        JTextField textField = (JTextField) e.getSource();
		         String[] temp = textField.getText().split(" ");
		    }    
		});
	}

	public Button getConfirmCancelButton() {
		return confirmCancel;
	}
	
	public String cancelationInfo() {
		double total = tickets.size() * 12.50 *0.15;
		total = Math.round(total * 100.0) / 100.0;
		refund = tickets.size() * 12.50 - total;
		refund = Math.round(refund * 100.0) / 100.0;
		String s = "";
		s+= theRes.toString();
		if(theRes.getUserType() == 0) {
			s += "\n\n Becasue you are not a registered user you will have to pay a 15% cancellation fee\n";
			s += "Cancellation fee: " + "$"+total;
		}
		return s;
	}
	
	public void checkTicket(String[] inputArr) {
		for(int i =0; i< inputArr.length; i++) {
			if(theRes.getTicket(inputArr[i]) != null) {
				tickets.add(theRes.getTicket(inputArr[i]));
			}
		}
	}
	
	public double getRefund() {
		return refund;
	}
}
