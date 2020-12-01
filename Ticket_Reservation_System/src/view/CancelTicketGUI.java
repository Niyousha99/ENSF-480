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
