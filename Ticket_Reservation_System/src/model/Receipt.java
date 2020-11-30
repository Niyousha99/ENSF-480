package model;

public class Receipt {
	private Reservation reservation;
	
	
	public Receipt(Reservation r) {
		setReservation(r);
	}
	
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}	
	
	@Override
	public String toString() {
		// TODO fix text alignment
		String str = "";
		str += "Receipt:\n";
		str += "General Ticket";
		if (reservation.getTickets().size() > 1)
			str += "s";
		str += "	" + reservation.getTickets().size() + " x $" + reservation.getTickets().get(0).getPrice();
		str += " = $" + reservation.getTickets().get(0).getPrice() * reservation.getTickets().size();
		str += "\nTax               	   $" + Double.valueOf(reservation.getTickets().get(0).getPrice() * reservation.getTickets().size()) / 20;
		str += "\n----------------------------------";
		str += "Total               $" + Double.valueOf(reservation.getTickets().get(0).getPrice() * reservation.getTickets().size()) / 20
									   + reservation.getTickets().get(0).getPrice() * reservation.getTickets().size();
		return str;
	}
}
