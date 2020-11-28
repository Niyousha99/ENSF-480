package model;

import java.util.ArrayList;

public class Movie {
	private String title, description;
	private ArrayList<Showtime> showtimes;
	
	public Movie(String n, String d) {
		title = n;
		description = d;
		showtimes = new ArrayList<Showtime>();
	}
	
	// populate showtimes (identical for each movie)
	public void setShowtimes(ArrayList <Showtime> src) {
		for (Showtime st: src) {
			showtimes.add(st);
		}
	}
	
	public Showtime searchShowtime(String showtime) {
		for (int i = 0; i < showtimes.size() - 1; i++) {
			Showtime st = showtimes.get(i);
			if (st.toString().equalsIgnoreCase(showtime))
				return st;
		}
		
		return null;
	}
	
	public ArrayList<Showtime> getShowtimes() {return showtimes;}
	
	public String[] getShowtimeChoices() {
		String[] times = new String[showtimes.size()];
		for (int i = 0; i < showtimes.size() - 1; i++) {
			times[i] = showtimes.get(i).toString();
		}
		return times;
	}
	
	public String getTitle() {return title;}
	
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
