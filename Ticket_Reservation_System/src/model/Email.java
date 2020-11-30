package model;

public abstract class Email {
	private String address;
	private String content;
	private Reservation reservation;
	private Receipt receipt;
	
	public Email(String userAddress, Reservation reservation, Receipt r) {
		setAddress(userAddress);
		setReservation(reservation);
		setReceipt(r);
		
	}
	
	@Override
	public String toString() {
		String str = "To: " + address + "\n";
		str += "From: Your Local Ticket Reservation Application\n\n";
		return str;
	}

	public String getAddress() {return address;}

	public void setAddress(String address) {this.address = address;}

	public String getContent() {return content;}

	public void setContent(String content) {this.content = content;}

	public Reservation getReservation() {return reservation;}

	public void setReservation(Reservation reservation) {this.reservation = reservation;}

	public Receipt getReceipt() {return receipt;}

	public void setReceipt(Receipt receipt) {this.receipt = receipt;}
}
