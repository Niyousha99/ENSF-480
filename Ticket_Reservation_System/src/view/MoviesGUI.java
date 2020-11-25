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

public class MoviesGUI extends JFrame{
	/**
	 * Components of the frame
	 */
	private JButton viewShowtimes;
	
	/**
	 * Constructs a MainFrame object
	 */
	public MoviesGUI() {
		super("Browse Movies");
		setBounds(200, 100, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout());
		
		JLabel background = new JLabel(new ImageIcon("img/MainFrame_background.jpg"));
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		
		
		
		
		add(background);
		pack();
	}
	
	public JButton getViewShowtimesButton() {
		return viewShowtimes;
	}
}
