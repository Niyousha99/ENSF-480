package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RegisterGUI extends JFrame implements DocumentListener{
	/**
	 * Components of the frame
	 */
	private JTextField userText, bankText, cardText;
	private JPasswordField passwordText;
	private Button register;
	
	/**
	 * Constructs a StudentLoginFrame object
	 */
	public RegisterGUI() {
		
		// Login Frame
		super("Register Account");
		setBounds(800, 450, 300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel);
		panel.setLayout(null);

		JLabel userLabel = new JLabel("Email");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		userText.getDocument().addDocumentListener(this);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		passwordText.getDocument().addDocumentListener(this);
		panel.add(passwordText);
		
		JLabel bankLabel = new JLabel("Bank");
		bankLabel.setBounds(10, 70, 80, 25);
		panel.add(bankLabel);
		
		bankText = new JTextField();
		bankText.setBounds(100, 70, 160, 25);
		bankText.getDocument().addDocumentListener(this);
		panel.add(bankText);
		
		JLabel cardLabel = new JLabel("Credit Card");
		cardLabel.setBounds(10, 100, 80, 25);
		panel.add(cardLabel);
		
		cardText = new JTextField();
		cardText.setBounds(100, 100, 160, 25);
		cardText.getDocument().addDocumentListener(this);
		panel.add(cardText);
		
		register = new Button("register");
		register.setEnabled(false);
		register.setBounds(10, 150, 80, 25);
		register.setForeground(Color.BLACK);
		panel.add(register);
	}
	
	
	/**
	 * Displays message supplied by the given parameter in a dialog box
	 * @param message is the message to display
	 */
	public void displayErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	/**
	 * Checks if the name and id text fields are empty. 
	 * @return false if one of the text fields is empty. Otherwise returns true.
	 */
	private boolean credentialsEntered() {
		if (userText.getText().trim().length() == 0 || passwordText.getText().trim().length() == 0 ||
				bankText.getText().trim().length() == 0 || cardText.getText().trim().length() == 0)
			return false;
		
		return true;
	}
	
	/**
	 * Enables/Disables the login and register buttons according to return value of 
	 * called method credentialsIsEntered.
	 */
	private void checkCredentials() {
		register.setEnabled(credentialsEntered());
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {checkCredentials();}

	@Override
	public void removeUpdate(DocumentEvent e) {checkCredentials();}

	@Override
	public void changedUpdate(DocumentEvent e) {}
	
	public JButton getRegisterButton() {return register;}
	
	public String getEmail() {return userText.getText();}
	
	public String getBank() {return bankText.getText();}
	
	public String getCard() {return cardText.getText();}
	
	public String getPassword() {return passwordText.getText();}

	
}
