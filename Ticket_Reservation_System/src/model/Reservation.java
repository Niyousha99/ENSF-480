package model;

import java.util.ArrayList;

public class Reservation {
	private ArrayList<Ticket> tickets;
	private Payment paymentInfo;
	private int userType; // 1 = registered, 0 = ordinary?

	public Reservation(int uType) {
		tickets = new ArrayList<Ticket>();
		userType = uType;
	}
	
	// For reserving tickets
	public void addTicket(Ticket ticket) {
		
	}
	
	// For cancelling tickets
	public void deleteTicket(Ticket ticket) {
		
	}
	
	public Ticket getTicket(Seat seat) {
		for (Ticket t: tickets)
			if (t.getSeat().equals(seat)) return t;
		
		return null;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}
	
}
