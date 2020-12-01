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
		String space = "			";
		String str = "General Ticket";
		
		if (reservation.getTickets().size() > 1) str += "s";
		
		str += "	" + reservation.getTickets().size() + " x $" + reservation.getTickets().get(0).getPrice();
		str += " = $" + reservation.getReservationTotal();
		str += "\nTax" + space + "$" + Double.valueOf(reservation.getTickets().get(0).getPrice() * reservation.getTickets().size()) / 20;
		str += "\n" + space + "----------------------------------\n";
		str += "Total" + space + "$" + Double.valueOf(reservation.getTickets().get(0).getPrice() * reservation.getTickets().size()) / 20
									   + reservation.getReservationTotal();
		return str;
	}
}
