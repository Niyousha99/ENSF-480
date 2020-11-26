package view;
import model.*;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

// TODO fix sizing of movie posters

public class MoviesGUI extends JFrame{
	/**
	 * Components of the frame
	 */
	private JButton viewShowtimes;
	
	/**
	 * Constructs a MainFrame object
	 */
	public MoviesGUI(ArrayList<Movie> movies) {
		super("Browse Movies");
		setBounds(200, 100, 1500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		
		displayMovies(movies);
	}
	
	// each second column gets the next movie.toString
	private void displayMovies(ArrayList<Movie> movies) {
		// parse movie titles if needed to find matching movie poster images in img
		
		/*
		for (Movie m: movies) {
			JLabel poster = new JLabel(new ImageIcon("src/img/______"));
			add(poster);
			JTextArea text = new JTextArea();
			text.setEditable(false);
			text.setFont(new Font("Arial", Font.BOLD, 15));
			text.setLineWrap(true);
			text.setText(m.toString());
		}
		*/
		// For now, just hardcoding the list of movies....
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 50, 50)); // any number of rows and 2 columns (movie poster and desciption text)
		panel.setBackground(Color.BLACK);
		
		JLabel poster1 = new JLabel(new ImageIcon("src/img/avengers.jpg"));
		panel.add(poster1);
		JTextArea text1 = new JTextArea();
		text1.setBackground(Color.BLACK);
		text1.setForeground(Color.WHITE);
		text1.setEditable(false);
		text1.setFont(new Font("Arial", Font.BOLD, 15));
		text1.setLineWrap(true);
		String d1 = "The Avengers";
		text1.setText(d1);
		panel.add(text1);
		
		JLabel poster2 = new JLabel(new ImageIcon("src/img/lion_king.jpg"));
		panel.add(poster2);
		JTextArea text2 = new JTextArea();
		text2.setBackground(Color.BLACK);
		text2.setForeground(Color.WHITE);
		text2.setEditable(false);
		text2.setFont(new Font("Arial", Font.BOLD, 15));
		text2.setLineWrap(true);
		String d2 = "The Lion King";
		text2.setText(d2);
		panel.add(text2);
		
		JLabel poster3 = new JLabel(new ImageIcon("src/img/top_gun.jpg"));
		panel.add(poster3);
		JTextArea text3 = new JTextArea();
		text3.setBackground(Color.BLACK);
		text3.setForeground(Color.WHITE);
		text3.setEditable(false);
		text3.setFont(new Font("Arial", Font.BOLD, 15));
		text3.setLineWrap(true);
		String d3 = "Top Gun";
		text3.setText(d3);
		panel.add(text3);
		
		JScrollPane scrollPanel = new JScrollPane();
		panel.add(scrollPanel, BorderLayout.CENTER);
		
		add(panel, BorderLayout.CENTER);
	}
	
	public JButton getViewShowtimesButton() {
		return viewShowtimes;
	}
}
