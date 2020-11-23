package model;

import java.util.ArrayList;

public class Movie {
	private String name;
	private ArrayList<Showtime> showtimes;
	
	public Movie(String n) {
		name = n;
		setShowtimes();
	}
	
	// define a set of showtimes for every movie
	// can be same for every day or different for weekdays/weekends
	private void setShowtimes() {
		
		
	}


	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}
	
	public boolean equals(Movie m) { 

    // If the object is compared with itself then return true   
    	if (m.name == name) return true; 
    	return false;
	}   
	
}
