package view;
import model.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EmailGUI extends JFrame{
	private Email email;
	
	private Button cancelTicket;
	
	public EmailGUI(ConfirmationEmail e) {
		super("Email");
		setBounds(800, 100, 500, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBackground(Color.WHITE);
		
		// Add email content
		JTextArea emailContent = new JTextArea();
		emailContent.setBounds(0, 0, 500, 200);
		emailContent.setBackground(Color.CYAN);
		emailContent.setEditable(false);
		emailContent.setForeground(Color.BLACK);
		emailContent.setFont(new Font("Arial", Font.BOLD, 15));
		emailContent.setText(e.toString());
		add(emailContent);
		
		// Add ticket(s)
		JPanel ticketPanel = new JPanel();
		ticketPanel.setBounds(0, 200, 500, 400);
		ticketPanel.setLayout(new GridLayout(0, 2));
		ticketPanel.setBackground(Color.WHITE);
		
		// movie poster
		MoviePosterGUI moviePoster = new MoviePosterGUI(e.getReservation().getTickets().get(0).getMovie().getTitle());
		ticketPanel.add(moviePoster.getPoster());
		
		// ticket information
		JPanel ticketInfoPanel = new JPanel();
		ticketInfoPanel.setBackground(Color.WHITE);
		ticketInfoPanel.setLayout(new GridLayout(0,1));
		
		for(Ticket t: e.getReservation().getTickets()){
			JTextArea text = new JTextArea();
			text.setBackground(Color.BLACK);
			text.setForeground(Color.WHITE);
			//text.setBounds(10, 10, 300, 200);
			text.setEditable(false);
			text.setFont(new Font("Arial", Font.PLAIN, 15));
			text.setLineWrap(true);
			text.setWrapStyleWord(true);
			text.setText(t.toString());
			ticketInfoPanel.add(text);
			ticketPanel.add(ticketInfoPanel);
		}
		
		add(ticketPanel);
		
		// Add receipt with cancel button
		JPanel receiptPanel = new JPanel();
		receiptPanel.setBounds(0, 600, 500, 350);
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
		
		cancelTicket = new Button("cancel ticket");
		cancelTicket.setForeground(Color.BLACK);
		cancelTicket.setBounds(0, 0, 100, 50);
		receiptPanel.add(cancelTicket);
		
		add(receiptPanel);
	}
	
	public Button getCancelTicketButton() {
		return cancelTicket;
	}
}
