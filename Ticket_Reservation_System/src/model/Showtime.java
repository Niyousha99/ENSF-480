package model;

import java.util.ArrayList;

public class Showtime implements Constants {
	private ArrayList<ArrayList<Seat>> seats;
	private Date date;
	private Time time;
	
	public Showtime(String y, String month, String d, int h, int min) {
		date = new Date(y, month, d);
		time = new Time(h, min);
		seats = new ArrayList<ArrayList<Seat>>();
		initializeSeats();
	}
	
	@Override
	public String toString() {
		String str = date + " " + time;
		return str;
	}

	public ArrayList<ArrayList<Seat>> getSeats() {return seats;}

	public void setSeats(ArrayList<ArrayList<Seat>> s) {seats = s;}
	
	void initializeSeats() {
		char r = 'A';
		for (int i = 0; i < SEATROWS; i++, r++)
			for (int j = 0; j < SEATCOLS; j++)
				seats.get(i).add(new Seat(r, j + 1));
	}
}
