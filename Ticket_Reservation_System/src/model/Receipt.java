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
		String str = "";
		
		
		
		return str;
	}
}
