package controller;
import view.*;
import model.*;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUIController {
	private DBManager database;
	private ArrayList<Movie> movies;
	private ArrayList<Account> accounts;
	private User user;
	
	private MainGUI mainFrame;
	private LoginGUI loginWindow;
	private RegisterGUI registerWindow;
	private MoviesGUI moviesFrame;
	private SeatsGUI seatsFrame;
	private CheckoutGUI checkoutFrame;
	private CancelTicketGUI cancelTicketFrame;
	private EmailGUI emailFrame;
	
	public GUIController(DBManager db) {
		database = db;
		populateData();
		initMainFrame();
	}
	
	private void populateData() {
		movies = database.getMovies();
		accounts = database.getAccounts();
	}

	private void initMainFrame() {
		mainFrame = new MainGUI();
		mainFrame.setVisible(true);
		mainFrameEventHandler();
	}
	

	public void initCancelTicketFrame() {
		cancelTicketFrame = new CancelTicketGUI();
		cancelTicketFrame.setVisible(true);
		cancelTicketEventHandler();
	}

	private void initLoginFrame() {
		loginWindow = new LoginGUI();
		loginWindow.setVisible(true);
		loginEventHandler();
	}
	
	private void initRegisterFrame() {
		registerWindow = new RegisterGUI();
		registerWindow.setVisible(true);
		registerWindowEventHandler();
	}

	private void initMoviesFrame() {
		moviesFrame = new MoviesGUI(movies);
		moviesFrame.setVisible(true);
		moviesFrameEventHandler();	
	}
	
	private void initConfirmationEmailFrame(Reservation r) {
		// TODO create Email object and pass to EmailGUI
		ConfirmationEmail email = new ConfirmationEmail(user.getEmail(), r);
		emailFrame = new EmailGUI(email);
		emailFrame.setVisible(true);
		confirmationEmailEventHandler();
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

	private void initCheckoutFrame(Movie selectedMovie, String selectedShowtime, ArrayList<Seat> selectedSeats) {
		checkoutFrame = new CheckoutGUI(selectedMovie, selectedShowtime, selectedSeats);
		checkoutFrame.setVisible(true);
		checkoutFrameEventHandler();
	}
	
	/**
	 * Waits and responds to events in mainFrame through lambda expressions.
	 */
	private void mainFrameEventHandler() {
		mainFrame.getBrowseMoviesButton().addActionListener((ActionEvent e) ->{
			mainFrame.dispose();
			initMoviesFrame();
		});
		
		mainFrame.getLoginButton().addActionListener((ActionEvent e) ->{
			mainFrame.dispose();
			initLoginFrame();
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
	
	private void loginEventHandler() {
		loginWindow.getLoginButton().addActionListener((ActionEvent e) ->{
			String email = loginWindow.getEmail();
			String password = loginWindow.getPassword();
			boolean verified = false;
			
			for (Account a: accounts) {
				if (a.verifyAccount(email, password)) {
					verified = true;
					user = new RegisteredUser(a.getEmail(), a);
					loginWindow.dispose();
					initMoviesFrame();
				}
			}
			
			if (!verified) loginWindow.displayErrorMessage("Incorrect credentials!");
		});	
		
		loginWindow.getRegisterButton().addActionListener((ActionEvent e) ->{
			initRegisterFrame();
		});
	}
	
	private void registerWindowEventHandler() {
		registerWindow.getRegisterButton().addActionListener((ActionEvent e) ->{
			String email = registerWindow.getEmail();
			String password = registerWindow.getPassword();
			String bank = registerWindow.getBank();
			String card = registerWindow.getCard();
			
			Account newAccount = new Account(email, password, card, bank);
			accounts.add(newAccount);
			addAccount(newAccount);
			user = new RegisteredUser(email, newAccount);
			
			registerWindow.dispose();
		});	
	}
	
	private void checkoutFrameEventHandler() {
		checkoutFrame.getConfirmButton().addActionListener((ActionEvent e) ->{
			// Create reservation for user
			int userType = 0;
			if (user instanceof RegisteredUser)	userType = 1;
			Reservation reservation = new Reservation(userType);
			
			// TODO add ticket(s) to reservation
			
			
			checkoutFrame.displayMessage("Payment confirmed!");
			checkoutFrame.dispose();
			initConfirmationEmailFrame(reservation);
		});	
		
	}
	
	private void confirmationEmailEventHandler() {
		// TODO Auto-generated method stub
		
	}
	
	private void cancelTicketEventHandler() {
		cancelTicketFrame.getConfirmCancelButton().addActionListener((ActionEvent e) ->{
			cancelTicketFrame.dispose();
			// TODO Carry out cancellation logic here. (refund account, remove reservation)
			JOptionPane.showMessageDialog(null, "Cancellation completed.");
			initMainFrame();
		});
	}
	
	private void addAccount(Account newAccount) {
		try {
			database.addAccountToDB(newAccount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
