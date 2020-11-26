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
		//pack();
	//	setMinimumSize(getPreferredSize());
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
		
		
		ImageIcon image1 = new ImageIcon("src/img/avengers.jpg");
		Image image = image1.getImage(); // transform it 
		Image newimg1 = image.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		image1 = new ImageIcon(newimg1);  // transform it back
		JLabel poster1 = new JLabel(image1);
		poster1.setHorizontalAlignment(JLabel.CENTER);
        poster1.setVerticalAlignment(JLabel.CENTER);
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
		
		ImageIcon image2 = new ImageIcon("src/img/lion_king.jpg");
		Image getImage2 = image2.getImage(); // transform it 
		Image newimg2 = getImage2.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		image2 = new ImageIcon(newimg2);  // transform it back
		JLabel poster2 = new JLabel(image2);
		poster2.setHorizontalAlignment(JLabel.CENTER);
        poster2.setVerticalAlignment(JLabel.CENTER);
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
		
		ImageIcon image3 = new ImageIcon("src/img/top_gun.jpg");
		Image getImage3 = image3.getImage(); // transform it 
		Image newimg3 = getImage3.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		image3 = new ImageIcon(newimg3);  // transform it back
		JLabel poster3 = new JLabel(image3);
		poster3.setHorizontalAlignment(JLabel.CENTER);
        poster3.setVerticalAlignment(JLabel.CENTER);
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
		
		ImageIcon image4 = new ImageIcon("src/img/debugger.jpg");
		Image getImage4 = image4.getImage(); // transform it 
		Image newimg4 = getImage4.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		image3 = new ImageIcon(newimg4);  // transform it back
		JLabel poster4 = new JLabel(image4);
		poster4.setHorizontalAlignment(JLabel.CENTER);
        poster4.setVerticalAlignment(JLabel.CENTER);
		panel.add(poster4);
		JTextArea text4 = new JTextArea();
		text4.setBackground(Color.BLACK);
		text4.setForeground(Color.WHITE);
		text4.setEditable(false);
		text4.setFont(new Font("Arial", Font.BOLD, 15));
		text4.setLineWrap(true);
		String d4 = "The Debugger";
		text4.setText(d4);
		panel.add(text4);
		add(panel, BorderLayout.CENTER);
		JScrollPane scrollPanel = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPanel, BorderLayout.CENTER);
		
	}
	
	public JButton getViewShowtimesButton() {
		return viewShowtimes;
	}
}
