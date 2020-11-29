package controller;
import view.*;
import model.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUIController {
	private ArrayList<Movie> movies;
	private ArrayList<Account> accounts;
	
	private MainGUI mainFrame;
	private LoginGUI loginWindow;
	private MoviesGUI moviesFrame;
	private SeatsGUI seatsFrame;
	private CheckoutGUI checkoutFrame;
	private CancelTicketGUI cancelTicketFrame;
	private EmailGUI emailFrame;
	
	public GUIController(ArrayList<Movie> m, ArrayList<Account> a) {
		movies = m;
		accounts = a;
		initMainFrame();
	}
	
	private void initMainFrame() {
		mainFrame = new MainGUI();
		mainFrame.setVisible(true);
		mainFrameEventHandler();
	}
	
	// TODO create CancelTicket GUI
	private void initCancelTicketFrame() {
		
		
	}

	private void initLoginFrame() {
		loginWindow = new LoginGUI();
		loginWindow.setVisible(true);
		loginEventHandler();
	}
	
	private void initMoviesFrame() {
		moviesFrame = new MoviesGUI(movies);
		moviesFrame.setVisible(true);
		moviesFrameEventHandler();	
	}
	
	private void moviesFrameEventHandler() {
		int i = 0;
		for (JComboBox<String> cb: moviesFrame.getShowtimeMenus()) {
			BookSeatsButton b = moviesFrame.getBookSeatButtons().get(i);
			
			cb.addActionListener((ActionEvent e) ->{
				// if showtime is selected
				if(cb.getSelectedIndex() != -1) {
					b.setEnabled(true);
					b.addActionListener((ActionEvent be) ->{
						Movie selectedMovie = b.getMovie();
						String selectedShowtime = (String)(((JComboBox)e.getSource()).getSelectedItem());
						moviesFrame.dispose();
						initSeatsFrame(selectedMovie, selectedShowtime);
					});	
				}
			});
			i++;
		}
	}

	private void initSeatsFrame(Movie selectedMovie, String selectedShowtime) {
		Showtime showtime = selectedMovie.searchShowtime(selectedShowtime);
		seatsFrame = new SeatsGUI(showtime.getSeats());
		seatsFrame.setVisible(true);
		seatsFrameEventHandler(selectedMovie, selectedShowtime);
	}
	
	// TODO create checkout GUI
	private void initCheckoutFrame(Movie selectedMovie, String selectedShowtime, ArrayList<Seat> selectedSeats) {
		checkoutFrame = new CheckoutGUI(selectedMovie, selectedShowtime, selectedSeats);
		checkoutFrame.setVisible(true);
		checkoutFrameEventHandler();
		
	}
	
	// TODO create email GUI
	private void initEmailFrame() {
		
	}
	
	/**
	 * Switches back to the desired frame supplied by the first parameter by disposing the frame supplied by the second parameter 
	 * and setting the desired frame to visible.
	 * 
	 * @param desiredFrame is the frame to be displayed
	 * @param disposeFrame is the frame to be disposed
	 */
	private void switchFrame(JFrame desiredFrame, JFrame disposeFrame) {
		disposeFrame.dispose();
		desiredFrame.setVisible(true);
	}
	
	
	/**
	 * Waits and responds to events in mainFrame through lambda expressions.
	 */
	private void mainFrameEventHandler() {
		mainFrame.getBrowseMoviesButton().addActionListener((ActionEvent e) ->{
			mainFrame.dispose();
			initMoviesFrame();
		});
		
		mainFrame.getCancelTicketButton().addActionListener((ActionEvent e) ->{
			mainFrame.dispose();
			initCancelTicketFrame();
		});
	}

	private void seatsFrameEventHandler(Movie selectedMovie, String selectedShowtime) {
		seatsFrame.getRefreshButton().addActionListener((ActionEvent e) ->{
			seatsFrame.refresh();
		});	
		
		seatsFrame.getReserveButton().addActionListener((ActionEvent e) ->{
			seatsFrame.dispose();
			initCheckoutFrame(selectedMovie, selectedShowtime, seatsFrame.getSelectedSeats());
		});	
	}
	
	// TODO the following event handlers
	private void loginEventHandler() {
		loginWindow.getLoginButton().addActionListener((ActionEvent e) ->{
					
		});	
		
		loginWindow.getRegisterButton().addActionListener((ActionEvent e) ->{
			
		});
	}

	private void checkoutFrameEventHandler() {
		
	}
	
	private void cancelTicketEventHandler() {
		
	}
}
