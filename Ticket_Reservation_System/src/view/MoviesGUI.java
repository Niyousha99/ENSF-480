package view;
import model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

import java.util.ArrayList;

public class MoviesGUI extends JFrame{
	/**
	 * Components of the frame
	 */
	// one "book seats" button per showtime per movie
	private ArrayList<BookSeatsButton> bookSeats;
	
	private ArrayList<JComboBox<String>> showtimeMenus;
	
	private ArrayList<Movie> movies;
	
	private String selectedShowtime;
	
	private Movie selectedMovie;
	
	/**
	 * Constructs a MainFrame object
	 */
	public MoviesGUI(ArrayList<Movie> m) {
		super("Browse Movies");
		setBounds(500, 100, 1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		
		movies = m;
		bookSeats = new ArrayList<BookSeatsButton>(movies.size()); 
		showtimeMenus = new ArrayList<JComboBox<String>>();
		
		displayMovies();
		createEventHandlers();
	}
	
	// each second column gets the next movie.toString
	private void displayMovies() {
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
			
			JComboBox<String> menu = new JComboBox<String>(m.getShowtimeChoices());
		    menu.setBounds(10, 300, 180, 25);
		    showtimeMenus.add(menu);
		    desArea.add(menu);
		    
			// create button to book seats for selected showtime of the movie
			BookSeatsButton button = new BookSeatsButton("book seats", m);
			button.setMovie(m);
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
	
	private void createEventHandlers() {
		int i = 0;
		for (JComboBox<String> cb: showtimeMenus) {
			BookSeatsButton b = bookSeats.get(i);
			
			cb.addActionListener((ActionEvent e) ->{
				// if showtime is selected
				if(cb.getSelectedIndex() != -1) {
					b.setEnabled(true);
					selectedMovie = b.getMovie();
					selectedShowtime = (String)(((JComboBox)e.getSource()).getSelectedItem());
				}
			});
			
			i++;
		}
	}
	
	public String getSelectedShowtime() {return selectedShowtime;}

	public Movie getSelectedMovie() {return selectedMovie;}
}
