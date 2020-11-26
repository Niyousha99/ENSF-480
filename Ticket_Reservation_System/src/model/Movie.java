package model;

import java.util.ArrayList;

public class Movie {
	private String title, description;
	private ArrayList<Showtime> showtimes;
	
	public Movie(String n, String d) {
		title = n;
		description = d;
		
		setShowtimes(); // TODO do we need this method?
	}
	
	// define a set of showtimes for every movie
	// can be same for every day or different for weekdays/weekends
	private void setShowtimes() {
		
		
	}
	
	// How text will be presented next to movie poster in MoviesGUI
	// Want title, description, and showtimes in order
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
