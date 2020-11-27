package view;
import model.*;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

// TODO Make displayMovies dynamic and add view showtimes button

public class MoviesGUI extends JFrame{
	/**
	 * Components of the frame
	 */
	private ArrayList<JButton> viewShowtimes;
	
	/**
	 * Constructs a MainFrame object
	 */
	public MoviesGUI(ArrayList<Movie> movies) {
		super("Browse Movies");
		setBounds(500, 100, 1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		viewShowtimes = new ArrayList<JButton>(movies.size()); // one "view showtimes" button per movie
		
		displayMovies(movies);
	}
	
	// each second column gets the next movie.toString
	private void displayMovies(ArrayList<Movie> movies) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 50, 50)); // any number of rows and 2 columns (movie poster and description text)
		panel.setBackground(Color.BLACK);
		
		// parse movie titles if needed to find matching movie poster images in img
		// or just rename jpg file names according to movie titles stored in DB 
		
		/*
		for (Movie m: movies) {
			MoviePosterGUI poster = new MoviePosterGUI("src/img/[MOVIE_TITLE].jpg"); // stringbuilder
			panel.add(poster.getPoster());
			
			// create movie description area beside movie poster
			JPanel desArea = new JPanel();
			desArea.setLayout(null);
			
			JTextArea text = new JTextArea();
			text.setBounds(10, 10, 200, 100);
			text.setEditable(false);
			text.setFont(new Font("Arial", Font.BOLD, 15));
			text.setLineWrap(true);
			text.setText(m.toString());
			desArea.add(text);
			
			ViewShowtimesButton button = new ViewShowtimesButton("view showtimes", m);
			button.setBounds(10, 110, 80, 25);
			viewShowtimes.add(button);
			desArea.add(button);
		}
		
		*/
		// For now, just hardcoding the list of movies....
		
		MoviePosterGUI poster1 = new MoviePosterGUI("Avengers");
		panel.add(poster1.getPoster());
		
		JTextArea text1 = new JTextArea();
		text1.setBackground(Color.BLACK);
		text1.setForeground(Color.WHITE);
		text1.setEditable(false);
		text1.setFont(new Font("Arial", Font.BOLD, 15));
		text1.setLineWrap(true);
		String d1 = "The Avengers";
		text1.setText(d1);
		panel.add(text1);
		
		MoviePosterGUI poster2 = new MoviePosterGUI("Lion King");
		panel.add(poster2.getPoster());

		JTextArea text2 = new JTextArea();
		text2.setBackground(Color.BLACK);
		text2.setForeground(Color.WHITE);
		text2.setEditable(false);
		text2.setFont(new Font("Arial", Font.BOLD, 15));
		text2.setLineWrap(true);
		String d2 = "The Lion King";
		text2.setText(d2);
		panel.add(text2);
		
		MoviePosterGUI poster3 = new MoviePosterGUI("Top Gun");
		panel.add(poster3.getPoster());
		
		JTextArea text3 = new JTextArea();
		text3.setBackground(Color.BLACK);
		text3.setForeground(Color.WHITE);
		text3.setEditable(false);
		text3.setFont(new Font("Arial", Font.BOLD, 15));
		text3.setLineWrap(true);
		String d3 = "Top Gun";
		text3.setText(d3);
		panel.add(text3);
		
		
		MoviePosterGUI poster4 = new MoviePosterGUI("The Debugger");
		panel.add(poster4.getPoster());
		
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
	
	public ArrayList<JButton> getViewShowtimesButtons() {return viewShowtimes;}
	
}
