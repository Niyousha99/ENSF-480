package model;

import java.util.ArrayList;

public class Movie {
	private String title, description;
	private ArrayList<Showtime> showtimes;
	
	// pass showtimes here in ctor or can be separate (Call setShowtimes in DB)
	public Movie(String n, String d, ArrayList <Showtime> showtimes) {
		title = n;
		description = d;
		showtimes = new ArrayList<Showtime>();
		setShowtimes(showtimes);
	}
	
	// populate showtimes (identical for each movie)
	public void setShowtimes(ArrayList <Showtime> src) {
		for (Showtime st: src) {
			showtimes.add(st);
		}
	}
	
	public ArrayList<Showtime> getShowtimes() {return showtimes;} 
	
	// How text will be presented next to movie poster in MoviesGUI
	// This displays only the title and description because there is a
	// "View showtimes" button that will display the showtimes separately.
	@Override
	public String toString() {
		String str = "";
		
		str += title;
		str += "\n\n\n";
		str += description;
		
		return str;
	}
	
	public boolean equals(Movie m) { 

    // If the object is compared with itself then return true   
    	if (m.title == title) return true; 
    	return false;
	}

	  
	
}
