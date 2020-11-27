package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.*;

// establish connection to MySQL
// create business logic in backend based on tables (theater, movies, registered users, etc.)
// Suggestion - Fill in all the data instead of just having getter functions?
//				e.g. get all movies from table in DB and fill in movieList in Theater
public class DBManager {
	private ArrayList<Movie> movies;
	private ArrayList<Account> accounts;
	
	public DBManager() {
		setMovies(new ArrayList<Movie>());
		setAccounts(new ArrayList<Account>());
	}
	
	public void connectToLoadDB(String url, String u, String p) throws SQLException {
		Connection dbConnection = DriverManager.getConnection(url, u, p);
		loadDB(dbConnection);
		dbConnection.close();
	}
	
	public void ConnectToAddAccountToDB(Account acc,String url, String u, String p) throws SQLException {
		Connection dbConnection = DriverManager.getConnection(url, u, p);
		addAccountToDB(acc, dbConnection);
		dbConnection.close();
	}
	
	private void loadDB(Connection dbConnection) throws SQLException {
		loadMovies(dbConnection);
		loadAccounts(dbConnection);
	}
	
	private void loadMovies(Connection dbConnection) throws SQLException {
		Statement dbStatement = dbConnection.createStatement();
		ResultSet movieResults = dbStatement.executeQuery("SELECT * FROM theater.movie_list"); // TODO correct query
		
		while(movieResults.next()) {
			String movieName = movieResults.getString("movie_name");
			String movieDesc = movieResults.getString("movie_desc");
			Movie newMovie = new Movie(movieName, movieDesc);
			loadShowtimes(dbConnection, newMovie);
			movies.add(newMovie);
		}
	}
	
	private void loadShowtimes(Connection dbConnection, Movie movie) throws SQLException {
		ArrayList <Showtime> showtimes = new ArrayList<Showtime>();
		Statement dbStatement = dbConnection.createStatement();
		ResultSet showtimeResults = dbStatement.executeQuery("SELECT * FROM theater.showtime_list WHERE movie_name = '" 
				+ movie.getTitle() + "'"); // TODO correct query
		while(showtimeResults.next()) {
			String [] showdate = showtimeResults.getString("show_date").split("/");
			String [] showtime = showtimeResults.getString("show_time").split(":");
			Showtime newShowtime = new Showtime(showdate[0], showdate[1], showdate[2], 
					Integer.parseInt(showtime[0]), Integer.parseInt(showtime[1]));
			loadSeats(dbConnection, newShowtime);
			showtimes.add(newShowtime);
		}
	}
	
	private void loadSeats(Connection dbConnection, Showtime showtime) throws SQLException {
		Statement dbStatement = dbConnection.createStatement();
		ResultSet seatResults = dbStatement.executeQuery("SELECT * FROM theater.seat_list WHERE showtime_id = '");
		while(seatResults.next()) {
			char row = seatResults.getString("row").charAt(0);
			int col = seatResults.getInt("col");
			Seat newSeat = new Seat(row, col);
			newSeat.setReserved(seatResults.getBoolean("reserved"));
		}
	}
	
	private void loadAccounts(Connection dbConnection) throws SQLException {
		Statement dbStatement = dbConnection.createStatement();
		ResultSet accountResults = dbStatement.executeQuery("SELECT * FROM theater.account_list");
		while(accountResults.next()) {
			String password = accountResults.getString("user_pword");
			String cardNumber = accountResults.getString("user_cardnum");
			String bank = accountResults.getString("user_bankname");
			String email = accountResults.getString("user_email"); // maybe add to Account class
			Account newAccount = new Account(password, cardNumber, bank);
			accounts.add(newAccount);
		}
	}
	
	public void addAccountToDB(Account account, Connection dbConnection) throws SQLException {
		Statement dbStatement = dbConnection.createStatement();
		dbStatement.executeUpdate("INSERT INTO theater.account_list" +
				"VALUES ('" + account.getCardNumber() + "', '" + account.getFI().getBankName() + "')");// TODO add remainder of attributes
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
