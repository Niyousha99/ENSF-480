package view;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SeatsGUI extends JFrame{
	
	/**
	 * Components of the frame
	 */
	//private JButton 
	
	public SeatsGUI() {
		super("View Seats");
		setBounds(200, 100, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout());
		
		JLabel background = new JLabel(new ImageIcon("img/MainFrame_background.jpg"));
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		
		
		
		
		add(background);
		pack();
	}
}
