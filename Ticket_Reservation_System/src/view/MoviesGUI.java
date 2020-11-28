package view;
import model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.StyleConstants;

import java.util.ArrayList;

// TODO Make displayMovies dynamic and add view showtimes button

public class MoviesGUI extends JFrame{
	/**
	 * Components of the frame
	 */
	// one "book seats" button per showtime per movie
	private ArrayList<JButton> bookSeats;
	
	private JComboBox<String> showtimeMenu;
	
	/**
	 * Constructs a MainFrame object
	 */
	public MoviesGUI(ArrayList<Movie> movies) {
		super("Browse Movies");
		setBounds(500, 100, 1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		bookSeats = new ArrayList<JButton>(movies.size()); 
		
		displayMovies(movies);
	}
	
	// each second column gets the next movie.toString
	private void displayMovies(ArrayList<Movie> movies) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 50, 50));
		panel.setBackground(Color.BLACK);
		
		for (Movie m: movies) {
			MoviePosterGUI poster = new MoviePosterGUI(m.getTitle());
			panel.add(poster.getPoster());
			
			// create movie description area beside movie poster
			JPanel desArea = new JPanel();
			desArea.setBackground(Color.BLACK);
			desArea.setLayout(null);
			
			JTextArea text = new JTextArea();
			text.setBackground(Color.BLACK);
			text.setForeground(Color.WHITE);
			text.setBounds(10, 10, 300, 200);
			text.setEditable(false);
			text.setFont(new Font("Arial", Font.BOLD, 15));
			text.setLineWrap(true);
			text.setWrapStyleWord(true);
			text.setText(m.toString());
			desArea.add(text);
			
			// create dropdown menu to select showtime
			JLabel label = new JLabel("Showtimes:");
			label.setBounds(10, 110, 100, 100);
			label.setBackground(Color.BLACK);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Arial", Font.BOLD, 10));
			desArea.add(label);
			
			String[] times = m.getShowtimeChoices();
		    showtimeMenu = new JComboBox<String>(times);
		    showtimeMenu.setBounds(10, 300, 180, 25);
		    desArea.add(showtimeMenu);
		    
			// create button to book seats for selected showtime of the movie
			BookSeatsButton button = new BookSeatsButton("book seats", m);
			button.setEnabled(false);
			button.setBounds(10, 400, 130, 25);
			bookSeats.add(button);
			desArea.add(button);
			panel.add(desArea);
		}	
		
		// add vertical scrollbar
		add(panel, BorderLayout.CENTER);
		JScrollPane scrollPanel = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPanel, BorderLayout.CENTER);
	}
	
	public ArrayList<JButton> getBookSeatsButtons() {return bookSeats;}
	
	public JComboBox<String> getShowtimeMenu(){return showtimeMenu;}
}
