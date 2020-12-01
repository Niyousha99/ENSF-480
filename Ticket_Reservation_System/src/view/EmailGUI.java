package view;
import model.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EmailGUI extends JFrame{
	private Email email;
	
	private Button cancelTicket;
	
	public EmailGUI(ConfirmationEmail e) {
		super("Email");
		setBounds(750, 100, 500, 775);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBackground(Color.WHITE);
		
		// Add email content
		JTextArea emailContent = new JTextArea();
		emailContent.setBounds(0, 0, 500, 200);
		emailContent.setBackground(Color.WHITE);
		emailContent.setEditable(false);
		emailContent.setForeground(Color.BLACK);
		emailContent.setFont(new Font("Arial", Font.BOLD, 15));
		emailContent.setText(e.toString());
		add(emailContent);
		
		// Add ticket(s)
		JPanel ticketPanel = new JPanel();
		ticketPanel.setBounds(0, 200, 500, 400);
		ticketPanel.setLayout(new GridLayout(0, 2));
		
		// movie poster
		MoviePosterGUI moviePoster = new MoviePosterGUI(e.getReservation().getTickets().get(0).getMovie().getTitle());
		ticketPanel.add(moviePoster.getPoster());
		
		// ticket information
		JPanel ticketInfoPanel = new JPanel();
		ticketInfoPanel.setBackground(Color.BLACK);
		ticketInfoPanel.setLayout(null);
		JTextArea text = new JTextArea();
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		text.setBounds(5, 5, 245, 300);
		text.setEditable(false);
		text.setFont(new Font("Arial", Font.BOLD, 15));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		String tickets = e.getReservation().getTickets().get(0).getMovie().toString();
		tickets += "\n\nShowtime: " + e.getReservation().getTickets().get(0).getShowtime();
		tickets += "\n\nSeats: \n";
		
		for(Ticket t: e.getReservation().getTickets()) tickets += t.toString() + "\n";
		
		text.setText(tickets);
		ticketInfoPanel.add(text);
		
		// add barcode image
		JLabel barcode = new JLabel(new ImageIcon("src/img/barcode.png"));
		barcode.setBounds(10, 300, 200, 80);
		ticketInfoPanel.add(barcode);
		
		ticketPanel.add(ticketInfoPanel);
		add(ticketPanel);
		
		// Add receipt
		JPanel receiptPanel = new JPanel();
		receiptPanel.setBounds(0, 600, 500, 100);
		receiptPanel.setLayout(null);
		receiptPanel.setBackground(Color.WHITE);
		
		JTextArea receipt = new JTextArea();
		receipt.setBounds(0, 20, 500, 100);
		receipt.setBackground(Color.WHITE);
		receipt.setForeground(Color.BLACK);
		receipt.setEditable(false);
		receipt.setFont(new Font("Arial", Font.PLAIN, 15));
		receipt.setLineWrap(true);
		receipt.setText(e.getReceipt().toString());
		receiptPanel.add(receipt);
		add(receiptPanel);
		
		// Add cancellation option
		JPanel cancelPanel = new JPanel();
		cancelPanel.setBackground(Color.DARK_GRAY);
		cancelPanel.setBounds(0, 700, 500, 100);
		cancelTicket = new Button("cancel ticket");
		cancelTicket.setBounds(210, 70, 80, 25);
		cancelPanel.add(cancelTicket);
		
		add(cancelPanel);
	}
	
	public JButton getCancelTicketButton() {
		return cancelTicket;
	}
}
