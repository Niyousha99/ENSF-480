package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Provides data fields and methods to create a Java data-type, representing a GUI main frame in a Movie Theater Ticket Reservation System.
 */
public class MainGUI extends JFrame implements DocumentListener{
	/**
	 * Components of the frame
	 */
	private JButton browseMovies, cancelTicket;
	
	/**
	 * Constructs a MainFrame object
	 */
	public MainGUI() {
		super("Ticket Reservation System");
		setBounds(450, 150, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout());
		
		JLabel background = new JLabel(new ImageIcon("src/img/MainFrame_background.jpg"));
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		
		background.add(Box.createRigidArea(new Dimension(0, 300)));
		JLabel welcomeText = new JLabel("Welcome to your local Ticket Reservation System!");
		welcomeText.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		welcomeText.setForeground(Color.WHITE);
		background.add(welcomeText);
		
		background.add(Box.createRigidArea(new Dimension(50, 50)));

		browseMovies = new Button("Browse Movies");
		browseMovies.setPreferredSize(new Dimension(50, 50));
		background.add(browseMovies);
		
		background.add(Box.createRigidArea(new Dimension(50, 20)));
		
		cancelTicket = new Button("Cancel Ticket");
		cancelTicket.setPreferredSize(new Dimension(50, 50));
		background.add(cancelTicket);

		add(background);
		pack();
	}
	
	public JButton getBrowseMoviesButton() {
		return browseMovies;
	}
	
	public JButton getCancelTicketButton() {
		return cancelTicket;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {}
	@Override
	public void removeUpdate(DocumentEvent e) {}
	@Override
	public void changedUpdate(DocumentEvent e) {}
}
