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
	private Connection dbConnection;
	
	public void connectToDB(String url, String u, String p) throws SQLException {
		dbConnection = DriverManager.getConnection(url, u, p);
	}
	
	public void addUser(String email, String pWord, String cardNum, String bankName) throws SQLException {
		Statement dbStatement = dbConnection.createStatement();
		dbStatement.executeUpdate("INSERT INTO 'users' "
				+ "VALUES ('" + email + "','" + pWord + "','" + cardNum + "','" + bankName + "')");
	}
	
	public ArrayList<Movie> getAllMovies() throws SQLException {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		Statement dbStatement = dbConnection.createStatement();
		ResultSet moviesResult = dbStatement.executeQuery("SELECT * FROM db.movielist");
		while(moviesResult.next()) {
			String movieName = moviesResult.getString("name");
			// load in remainder of movie's data
		}
		return movies;
	}
	
	// May continue this way - will discuss further during wed's lecture -Albin
	public ArrayList<Showtime> getShowtimes() {
		return null;
	}
	
	public ArrayList<Seat> getSeats(Showtime showtime){
		return null;
	}
	
	public Account getAccount(String email) throws SQLException {
		Account newAccount = new Account(email, null, email, null); // TO BE FIXED
		Statement dbStatement = dbConnection.createStatement();
		ResultSet accountResult = dbStatement.executeQuery("SELECT * FROM db.accountlist WHERE account_email = '" + email + "'");
		
		return newAccount;
	}
	
	
}
