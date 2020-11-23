package controller;

import java.util.ArrayList;

import model.*;

// establish connection to MySQL
// create business logic in backend based on tables (theater, movies, registered users, etc.)
// Suggestion - Fill in all the data instead of just having getter functions?
//				e.g. get all movies from table in DB and fill in movieList in Theater
public class DBManager {
	
	public void connectToDB(String url, String u, String p) {
		
	}
	
	public void addUser() {
		
	}

	public ArrayList<Showtime> getShowtimes() {
		return null;
	}
	
	public ArrayList<Seat> getSeats(Showtime showtime){
		return null;
	}
	
	public Account getAccount(String email) {
		return null;
	}
	
	
}
