package model;

import java.util.ArrayList;

public class Showtime {
	private ArrayList<Seat> seats;
	private Date date;
	private Time time;
	
	public Showtime() {
		
	}
	
	@Override
	public String toString() {
		String str = date + " " + time;
		return str;
	}

	public ArrayList<Seat> getSeats() {return seats;}

	public void setSeats(ArrayList<Seat> s) {seats = s;}
}
