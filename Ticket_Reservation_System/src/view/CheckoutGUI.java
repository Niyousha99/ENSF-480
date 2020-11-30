package view;
import model.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

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
	private Button login;

	public CheckoutGUI(Movie selectedMovie, String selectedShowtime, ArrayList<Seat> selectedSeats) {
		super("Checkout");
		setBounds(700, 250, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout());

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel);
		panel.setLayout(null);
		
		JTextArea text = new JTextArea();
		text.setBounds(10, 10, 200, 200);
		text.setEditable(false);
		text.setBackground(Color.GRAY);
		text.setFont(new Font("Arial", Font.BOLD, 15));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setText(selectedMovie.toString());
		panel.add(text);
		
		JLabel showtime = new JLabel("Showtime: "+selectedShowtime.toString());
		showtime.setBounds(10, 150, 200, 150);
		panel.add(showtime);
		
		JLabel seatsText = new JLabel("Seats Reserved: "+seatInfo(selectedSeats));
		seatsText.setBounds(10, 170, 161, 150);
		panel.add(seatsText);

		
//		JLabel movieInfo = new JLabel(selectedMovie.toString());
//		movieInfo.setBounds(10, 10, 161, 150);
//		panel.add(movieInfo);
		
		JLabel userLabel1 = new JLabel("Credit Card Number");
		userLabel1.setBounds(10, 250, 150, 50);
		panel.add(userLabel1);

		creditCardNumberText = new JTextField(20);
		creditCardNumberText.setBounds(150, 265, 150, 20);
		panel.add(creditCardNumberText);
		
		JLabel userLabel2 = new JLabel("Your Bank");
		userLabel2.setBounds(10, 280, 150, 50);
		panel.add(userLabel2);

		bankName = new JTextField(20);
		bankName.setBounds(150, 295, 150, 20);
		panel.add(bankName);
		
		creditCardNumberText.addKeyListener(new KeyAdapter() {
		      public void keyReleased(KeyEvent e) {
		        JTextField textField = (JTextField) e.getSource();
		        String text = textField.getText();
		      }

		      public void keyTyped(KeyEvent e) {
		      }

		      public void keyPressed(KeyEvent e) {
		      }
		    });
		

		login = new Button("login");
		login.setBounds(10, 350, 80, 25);
		panel.add(login);
		
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
	
	public JButton getLogin() {
		return login;
	}
}
