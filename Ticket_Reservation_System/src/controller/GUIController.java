package controller;
import view.*;
import model.*;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class GUIController {
	private DBManager database;
	private ArrayList<Movie> movies;
	private ArrayList<Account> accounts;
	private User user;
	private RegisteredUser registeredUser;
	
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
	

	public void initCancelTicketFrame(Reservation r) {
		cancelTicketFrame = new CancelTicketGUI(r);
		cancelTicketFrame.setVisible(true);
		cancelTicketEventHandler(r);
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
		Receipt tempReceipt = new Receipt(r);
		ConfirmationEmail email = new ConfirmationEmail(user.getEmail(), r, tempReceipt);
		emailFrame = new EmailGUI(email);
		emailFrame.setVisible(true);
		confirmationEmailEventHandler(r);
	}

	private void moviesFrameEventHandler() {
		int i = 0;
		for (JComboBox<String> cb: moviesFrame.getShowtimeMenus()) {
			BookSeatsButton b = moviesFrame.getBookSeatButtons().get(i);
			
			cb.addActionListener((ActionEvent e) ->{
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
		int userType = CheckUserType();
		checkoutFrame = new CheckoutGUI(selectedMovie, selectedShowtime, selectedSeats, userType);
		checkoutFrame.setVisible(true);
		checkoutFrameEventHandler(selectedMovie, selectedShowtime, selectedSeats );
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
					registeredUser = new RegisteredUser(a.getEmail(), a);
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
	
	private void checkoutFrameEventHandler(Movie m, String showtime, ArrayList<Seat> theSeats) {
		checkoutFrame.getConfirmButton().addActionListener((ActionEvent e) ->{
			int userType = CheckUserType();
			Reservation reservation = new Reservation(userType);

			if(userType == 0) {
				for (int i = 0; i < theSeats.size(); i++) {
					Ticket newTick = new Ticket(m, theSeats.get(i), 
							new Account(checkoutFrame.getEmailInput(), "", checkoutFrame.getCreditCardNumInput(), checkoutFrame.getBankInput()), showtime);
							reservation.addTicket(newTick);
							
					theSeats.get(i).setReserved(true);
					user = new User(checkoutFrame.getEmailInput());
				}
			}
			
			else {
				for (int i = 0; i < theSeats.size(); i++) {
					Ticket newTick = new Ticket(m, theSeats.get(i), findAccount(user.getEmail()), showtime);
					theSeats.get(i).setReserved(true);
					reservation.addTicket(newTick);
				}
			}
			
			// TODO input error checking:
			//      - credit card number can only contain integers 
			//      - payment valid (if balance enough in bank)
			//      - etc.
			checkoutFrame.displayMessage("Payment confirmed!");
			checkoutFrame.dispose();
			initConfirmationEmailFrame(reservation);
		});	
		
	}
	
	private int CheckUserType() {
		int userType = 0;
		if (user instanceof RegisteredUser)	userType = 1;
		return userType;
	}
	
	public Account findAccount(String email) {
		for(int i =0; i< accounts.size(); i++) {
			if(accounts.get(i).getEmail().equals(email)) {
				return accounts.get(i);
			}
		}
		return null;
	}

	private void confirmationEmailEventHandler(Reservation r) {
		emailFrame.getCancelTicketButton().addActionListener((ActionEvent e) ->{
			emailFrame.dispose();
			initCancelTicketFrame(r);
		});
		
		initMainFrame();
	}
	
	private void cancelTicketEventHandler(Reservation r) {
		cancelTicketFrame.getConfirmCancelButton().addActionListener((ActionEvent e) ->{
			
			cancelTicketFrame.setSeats(cancelTicketFrame.getSeatsEntered().split(" "));
			
			if(!cancelTicketFrame.setTickets())
				cancelTicketFrame.displayErrorMessage("Invalid seat number(s)!");
			
			else {		
				RegisteredUser currentUser = (RegisteredUser)user;
				System.out.println(currentUser.getAccount().getFI().getBankName());
				currentUser.getAccount().getFI().deposit(cancelTicketFrame.getRefund());
				user = currentUser;

				for (Ticket t: cancelTicketFrame.getTickets()) {
					t.getSeat().setReserved(false);
					r.deleteTicket(t);
					
					cancelTicketFrame.dispose();
					JOptionPane.showMessageDialog(null, "Cancellation completed.");
					initMainFrame();
				}
			}
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
