package model;

import java.util.ArrayList;

public class Showtime implements Constants {
	//private ArrayList<ArrayList<Seat>> seats;
		private Seat[][] seats;
		private Date date;
		private Time time;
		
//		public Showtime(String y, String month, String d, int h, int min) {
//			date = new Date(y, month, d);
//			time = new Time(h, min);
//			//seats = new ArrayList<ArrayList<Seat>>();
//			seats = new Seat[SEATROWS][SEATCOLS];		
//			initializeSeats();
//			//displaySeats();
//
//		}
		public Showtime(String y, String month, String d, String t) {
			date = new Date(y, month, d);
			time = new Time(t);
			//seats = new ArrayList<ArrayList<Seat>>();
			seats = new Seat[SEATROWS][SEATCOLS];		
			initializeSeats();
			//displaySeats();

		}
		
		// How text will be presented in the "View Showtimes" menu
		@Override
		public String toString() {
			String str = date + " " + time;
			return str;
		}

		// Returns the list of seatLists
		//public ArrayList<ArrayList<Seat>> getSeats() {return seats;}
		public Seat[][] getSeats() {return seats;}

		// Sets seats to given seat list
		public void setSeats(Seat[][] s) {seats = s;}
		
		// Initializes all seats in the Showtime
		public void initializeSeats() {
			char r = 'A';
			for (int i = 0; i < SEATROWS; i++, r++)
				for (int j = 0; j < SEATCOLS; j++)
					seats[i][j] = new Seat(r, j + 1);
		}
		
		public void displaySeats() {
			for (int i = 0; i < SEATROWS; i++)
				for (int j = 0; j < SEATCOLS; j++)
					System.out.println(seats[i][j].toString());

			
		}
		
		// Returns the number seats available in the Showtime
		public int numAvailSeats() {
			int avail = 0;
			for (int i = 0; i < SEATROWS; i++)
				for (Seat s : seats[i]) {
					if (!s.isReserved()) avail++;
				}
			return avail;
		}
	
}
