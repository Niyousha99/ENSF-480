package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Driver;
import model.*;
import java.sql.*; 


// establish connection to MySQL
// create business logic in backend based on tables (theater, movies, registered users, etc.)
// Suggestion - Fill in all the data instead of just having getter functions?
//				e.g. get all movies from table in DB and fill in movieList in Theater
public class DBManager {
	private ArrayList<Movie> movies;
	private ArrayList<Account> accounts;
	private Connection dbConnection;
	
	public DBManager() {
		setMovies(new ArrayList<Movie>());
		setAccounts(new ArrayList<Account>());
	}
	
	public void connectToLoadDB(String url, String u, String p) throws SQLException {
		dbConnection = DriverManager.getConnection(url, u, p);
		loadDB();
		//dbConnection.close();
	}
	
	public void ConnectToAddAccountToDB(Account acc,String url, String u, String p) throws SQLException {
		Connection dbConnection = DriverManager.getConnection(url, u, p);
		addAccountToDB(acc);
		//dbConnection.close();
	}
	
	private void loadDB() throws SQLException {
		loadMovies();
		loadAccounts();
	}
	
	private void loadMovies() throws SQLException {
		Statement dbStatement = dbConnection.createStatement();
		ResultSet movieResults = dbStatement.executeQuery("SELECT * FROM ticket_reservation_backend.movies"); // TODO correct query
		
		while(movieResults.next()) {
			String movieName = movieResults.getString("movie");
			String movieDesc = movieResults.getString("description");
			Movie newMovie = new Movie(movieName, movieDesc);
			newMovie.setShowtimes(loadShowtimes(newMovie));
			movies.add(newMovie);
		}
	}
	
	private ArrayList<Showtime> loadShowtimes(Movie movie) throws SQLException {
		ArrayList <Showtime> showtimes = new ArrayList<Showtime>();
		Statement dbStatement = dbConnection.createStatement();
		ResultSet showtimeResults = dbStatement.executeQuery("SELECT * FROM ticket_reservation_backend.showtimes WHERE movie = '" 
				+ movie.getTitle() + "'");
		while(showtimeResults.next()) {
			String [] showdate = showtimeResults.getString("date").split("/");
			//String [] showtime = showtimeResults.getString("time").split(":");
			String showtime = showtimeResults.getString("time");
//			int hr;
//			if(showtime[1].contains("pm")) {
//				hr = Integer.parseInt(showtime[0]);
//			}
//			else {
//				hr = Integer.parseInt(showtime[0]);
//			}
//			int sec = Integer.parseInt(showtime[1].substring(0, showtime[1].length()-2));
			Showtime newShowtime = new Showtime(showdate[2], showdate[0], showdate[1], showtime);
			showtimes.add(newShowtime);
		}
		return showtimes;
	}
	
	private void loadAccounts() throws SQLException {
		Statement dbStatement = dbConnection.createStatement();
		ResultSet accountResults = dbStatement.executeQuery("SELECT * FROM ticket_reservation_backend.registeredUsers");
		while(accountResults.next()) {
			String password = accountResults.getString("password");
			String cardNumber = accountResults.getString("creditCard");
			String bank = accountResults.getString("bankName");
			String email = accountResults.getString("email");
			Account newAccount = new Account(email, password, cardNumber, bank);
			accounts.add(newAccount);
		}
	}
	
	public void addAccountToDB(Account account) throws SQLException {
		String query = "INSERT INTO ticket_reservation_backend.registeredUsers (password, email, creditCard, bankName) values (?,?,?,?)";
		PreparedStatement pStat = dbConnection.prepareStatement(query);
		pStat.setString(1, account.getPassword());
		pStat.setString(2, account.getEmail());
		pStat.setString(3, account.getFI().getCardNumber());
		pStat.setString(4, account.getFI().getBankName());
		pStat.execute();
		pStat.close();
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
}
