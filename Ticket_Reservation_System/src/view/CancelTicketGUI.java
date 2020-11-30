package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CancelTicketGUI extends JFrame {
	
	private Button confirmCancel;
	//private Reservation test;
	
	public CancelTicketGUI() {
		super("Cancel Ticket");
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
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		add(panel, BorderLayout.CENTER);
		
		JTextArea text = new JTextArea();
		text.setBackground(Color.DARK_GRAY);
		text.setForeground(Color.WHITE);
		text.setBounds(10, 10, 564, 520);
		text.setEditable(false);
		text.setFont(new Font("Arial", Font.PLAIN, 15));
		text.setLineWrap(true);
		text.setText("The reservation will be displayed here");
		panel.add(text);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		confirmCancel = new Button("Confirm Cancellation");
		confirmCancel.setSize(80, 25);
		buttonPanel.add(confirmCancel);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public Button getConfirmCancelButton() {
		return confirmCancel;
	}
}
