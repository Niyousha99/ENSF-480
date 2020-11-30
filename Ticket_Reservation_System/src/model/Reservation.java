package model;

import java.util.ArrayList;

public class Reservation {
	private ArrayList<Ticket> tickets;
	private int userType; // 1 = registered, 0 = ordinary?

	public Reservation(int uType) {
		tickets = new ArrayList<Ticket>();
		userType = uType;
	}
	
	// For reserving tickets
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}
	
	// For canceling tickets
	public void deleteTicket(Ticket ticket) {
		
	}
	
	public Ticket getTicket(Seat seat) {
		for (Ticket t: tickets)
			if (t.getSeat().equals(seat)) return t;
		
		return null;
	}
	
	public ArrayList<Ticket> getTickets(){return tickets;}
	
	// Returns all tickets as a string
	@Override
	public String toString() {
		String str = "";
		for (Ticket t : tickets) {
			str += t;
			str += "\n\n";
		}
		return str;
	}
	
}
