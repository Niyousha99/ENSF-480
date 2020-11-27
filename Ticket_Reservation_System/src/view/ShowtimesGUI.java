package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.*;

public class ShowtimesGUI extends JFrame{
	private Button viewSeatsButton;

	public ShowtimesGUI(Movie m) {
		super("Browse Movies");
		setBounds(700, 100, 800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		displayShowtimes(m);
	}
	
	private void displayShowtimes(Movie m) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		panel.setBackground(Color.BLACK);
		
		// create movie poster
		MoviePosterGUI poster = new MoviePosterGUI(m.getTitle());
		panel.add(poster.getPoster());
		
		// create movie info
		JPanel movieInfo = new JPanel();
		movieInfo.setLayout(null);
		JTextArea text = new JTextArea();
		text.setBounds(10, 10, 200, 100);
		text.setEditable(false);
		text.setFont(new Font("Arial", Font.BOLD, 15));
		text.setLineWrap(true);
		text.setText(m.toString());
		movieInfo.add(text);
		
		// create dropdown menu to select showtime
		String[] times = m.getShowtimeChoices();
	    final JComboBox<String> showtimeMenu = new JComboBox<String>(times);
	    showtimeMenu.setBounds(10, 110, 80, 25);
	    movieInfo.add(showtimeMenu);
	    
	    // create button to view seats for selected showtime
	    viewSeatsButton = new Button("view seats");
	    viewSeatsButton.setBounds(10, 130, 80, 25);
		movieInfo.add(viewSeatsButton);
		
		panel.add(movieInfo);
		add(panel, BorderLayout.CENTER);
	}

	public JButton getViewSeatsButton() {return viewSeatsButton;}
}
