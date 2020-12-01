package view;
import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutGUI extends JFrame{
	
	private JTextField creditCardNumberText;
	private JTextField bankName;
	private JTextField emailText;
	private Button confirm;
	private int userType;
	private String creditCardNumInput;
	private String bankInput;
	private String emailInput;

	public CheckoutGUI(Movie selectedMovie, String selectedShowtime, ArrayList<Seat> selectedSeats, int uType) {
		super("Checkout");
		userType = uType;
		setBounds(700, 250, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new GridLayout(0, 2));
		add(panel);
		
		// Add movie poster
		MoviePosterGUI poster = new MoviePosterGUI(selectedMovie.getTitle());
		panel.add(poster.getPoster());
		
		// checkout info beside movie poster
		JPanel checkoutInfo = new JPanel();
		checkoutInfo.setBackground(Color.LIGHT_GRAY);
		checkoutInfo.setLayout(null);
		
		JTextArea text = new JTextArea();
		text.setBounds(10, 60, 250, 200);
		text.setBorder(BorderFactory.createCompoundBorder(
		        text.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		text.setEditable(false);
		text.setBackground(Color.GRAY);
		text.setFont(new Font("Arial", Font.BOLD, 15));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setText(selectedMovie.toString());
		checkoutInfo.add(text);
		
		JLabel showtime = new JLabel("Showtime: "+selectedShowtime.toString());
		showtime.setBounds(10, 260, 200, 150);
		checkoutInfo.add(showtime);
		
		JLabel seatsText = new JLabel("Seats Reserved: " + seatInfo(selectedSeats));
		seatsText.setBounds(10, 280, 161, 150);
		checkoutInfo.add(seatsText);
		
		if(userType == 0) {
			JLabel userLabel3 = new JLabel("Email");
			userLabel3.setBounds(10, 370, 150, 50);
			checkoutInfo.add(userLabel3);
			
			emailText = new JTextField(20);
			emailText.setBounds(150, 385, 120, 20);
			checkoutInfo.add(emailText);
		
			JLabel userLabel1 = new JLabel("Credit Card Number");
			userLabel1.setBounds(10, 400, 150, 50);
			checkoutInfo.add(userLabel1);

			creditCardNumberText = new JTextField(20);
			creditCardNumberText.setBounds(150, 415, 120, 20);
			checkoutInfo.add(creditCardNumberText);
		
			JLabel userLabel2 = new JLabel("Your Bank");
			userLabel2.setBounds(10, 430, 150, 50);
			checkoutInfo.add(userLabel2);

			bankName = new JTextField(20);
			bankName.setBounds(150, 445, 120, 20);
			checkoutInfo.add(bankName);
			
			emailText.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
			        JTextField textField = (JTextField) e.getSource();
			        emailInput = textField.getText();
			    }    
			});
		
			creditCardNumberText.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					JTextField textField = (JTextField) e.getSource();
					creditCardNumInput = textField.getText();
				}    
			});
		
			bankName.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					JTextField textField = (JTextField) e.getSource();
					bankInput = textField.getText();
				}    
			});
		}
		else {
			JTextArea textForRegisteredUser = new JTextArea();
			textForRegisteredUser.setBounds(10, 400, 250, 50);
			textForRegisteredUser.setFont(new Font("Arial", Font.PLAIN, 15));
			textForRegisteredUser.setBackground(Color.LIGHT_GRAY);
			textForRegisteredUser.setEditable(false);
			textForRegisteredUser.setLineWrap(true);
			textForRegisteredUser.setWrapStyleWord(true);
			textForRegisteredUser.setText("You're already logged in, please confirm your reservation below.");
			checkoutInfo.add(textForRegisteredUser);
		}

		confirm = new Button("confirm");
		confirm.setBounds(10, 480, 80, 25);
		checkoutInfo.add(confirm);
		
		panel.add(checkoutInfo);
	}
	
	public String seatInfo(ArrayList<Seat> selectedSeats) {
		String str = "";
		for(int i=0; i< selectedSeats.size(); i++) {
			str += selectedSeats.get(i).toString();
			str+= " ";
		}
		return str;
	}
	
	
	/**
	 * Displays message supplied by the given parameter in a dialog box
	 * @param message is the message to display
	 */
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
		
	}
	
	public JButton getConfirmButton() {return confirm;}
	
	public String getEmailInput() {
		return emailInput;
	}

	public String getCreditCardNumInput() {
		return creditCardNumInput;
	}

	public String getBankInput() {
		return bankInput;
	}
	
}
