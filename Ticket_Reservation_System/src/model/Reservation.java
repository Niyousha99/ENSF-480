package model;

import java.util.ArrayList;

public class Reservation {
	private ArrayList<Ticket> tickets;
	private double reservationTotal;
	private int userType; // 1 = registered, 0 = ordinary?

	public Reservation(int uType) {
		tickets = new ArrayList<Ticket>();
		setUserType(uType);
	}
	
	// For reserving tickets
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
		setReservationTotal(getReservationTotal() + ticket.getPrice());
	}
	
	// For canceling tickets
	public void deleteTicket(Ticket ticket) {
		for(int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getSeat().toString().equals(ticket.getSeat().toString()))
				tickets.remove(i);
		}
	}
	
	public Ticket getTicket(Seat seat) {
		for (Ticket t: tickets)
			if (t.getSeat().equals(seat)) return t;
		
		return null;
	}
	
	public Ticket getTicket(String seat) {
		for (Ticket t: tickets)
			if (t.getSeat().toString().equals(seat)) return t;
		
		return null;
	}

	public ArrayList<Ticket> getTickets(){return tickets;}
	
	public double getReservationTotal() {return reservationTotal;}

	public void setReservationTotal(double reservationTotal) {this.reservationTotal = reservationTotal;}

	public int getUserType() {return userType;}

	public void setUserType(int userType) {this.userType = userType;}
	
	// Returns all tickets as a string
	@Override
	public String toString() {
		String str = "These are your Tickets\n";
		for (Ticket t : tickets) {
			str += t.toString();
			str += "\n\n";
		}
		
		return str;
	}
}
