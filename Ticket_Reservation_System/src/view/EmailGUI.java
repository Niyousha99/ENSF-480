package view;
import model.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EmailGUI extends JFrame{
	private Email email;
	
	private Button cancelTicket;
	
	public EmailGUI(ConfirmationEmail e) {
		super("Email");
		setBounds(400, 100, 500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1));
		setBackground(Color.WHITE);
		
		// Add email content
		JTextArea emailContent = new JTextArea();
		emailContent.setBackground(Color.BLUE);
		emailContent.setEditable(false);
		emailContent.setForeground(Color.WHITE);
		emailContent.setFont(new Font("Arial", Font.BOLD, 10));
		emailContent.setText(e.toString());
		add(emailContent);
		
		// Add ticket(s)
		JPanel ticketPanel = new JPanel();
		ticketPanel.setLayout(new GridLayout(0, 2));
		ticketPanel.setBackground(Color.WHITE);
		
		for(Ticket t: e.getReservation().getTickets()){
			// movie poster
			MoviePosterGUI moviePoster = new MoviePosterGUI(t.getMovie().getTitle());
			ticketPanel.add(moviePoster.getPoster());
			
			// ticket information
			JPanel ticketInfoPanel = new JPanel();
			ticketInfoPanel.setBackground(Color.WHITE);
			ticketInfoPanel.setLayout(null);
			
			JTextArea text = new JTextArea();
			text.setBackground(Color.WHITE);
			text.setForeground(Color.BLACK);
			text.setBounds(10, 10, 300, 200);
			text.setEditable(false);
			text.setFont(new Font("Arial", Font.PLAIN, 15));
			text.setLineWrap(true);
			text.setWrapStyleWord(true);
			text.setText(t.toString());
			ticketInfoPanel.add(text);
		}
		
		// Add receipt
		JTextArea receipt = new JTextArea();
		receipt.setBackground(Color.WHITE);
		receipt.setForeground(Color.BLACK);
		receipt.setEditable(false);
		receipt.setFont(new Font("Arial", Font.PLAIN, 15));
		receipt.setLineWrap(true);
		receipt.setText(e.getReceipt().toString());
		add(receipt);
		
		// Add cancellation option
		cancelTicket = new Button("cancel ticket");
		add(cancelTicket);
	}
}
