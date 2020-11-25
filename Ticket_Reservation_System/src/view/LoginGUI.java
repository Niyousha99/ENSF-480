package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginGUI extends JFrame implements DocumentListener{
	/**
	 * Components of the frame
	 */
	private JTextField userText;
	private JPasswordField passwordText;
	private JButton login, register;
	
	/**
	 * Constructs a StudentLoginFrame object
	 */
	public LoginGUI() {
		
		// Login Frame
		super("Login");
		setBounds(800, 450, 300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);

		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		login = new JButton("login");
		login.setBounds(10, 80, 80, 25);
		panel.add(login);
		
		register = new JButton("register");
		register.setBounds(180, 80, 80, 25);
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
		if (userText.getText().trim().length() == 0 || passwordText.getText().trim().length() == 0)
			return false;
		
		return true;
	}
	
	/**
	 * Enables/Disables the login button according to return value of 
	 * called method credentialsIsEntered.
	 */
	private void checkCredentials() {
		login.setEnabled(credentialsEntered());
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {checkCredentials();}

	@Override
	public void removeUpdate(DocumentEvent e) {checkCredentials();}

	@Override
	public void changedUpdate(DocumentEvent e) {}
	
	public JButton getLoginButton() {return login;}
	
	public JButton getRegisterButton() {return register;}
	
	public JTextField getUsernameField() {return userText;}
	
	public JTextField passwordField() {return passwordText;}
	
	public String getUsername() {return userText.getText();}
	
	public String getPassword() {return passwordText.getText();}
}
