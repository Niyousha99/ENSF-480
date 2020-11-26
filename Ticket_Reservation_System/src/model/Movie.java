package model;

import java.util.ArrayList;

public class Movie {
	private String title, description;
	private ArrayList<Showtime> showtimes;
	
	public Movie(String n, String d) {
		title = n;
		description = d;
		setShowtimes();
	}
	
	// populate showtimes for the movie
	public void setShowtimes() {
		
		
	}
	
	public ArrayList<Showtime> getShowtimes() {return showtimes;} 
	
	// How text will be presented next to movie poster in MoviesGUI
	// Want title and description
	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}
	
	public boolean equals(Movie m) { 

    // If the object is compared with itself then return true   
    	if (m.title == title) return true; 
    	return false;
	}

	  
	
}
