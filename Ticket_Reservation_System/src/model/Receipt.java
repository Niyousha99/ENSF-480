package model;

public class Receipt {
	private Reservation reservation;
	private Payment paymentInfo;
	
	public Receipt(Reservation r, Payment p) {
		setReservation(r);
		setPaymentInfo(p);
	}
	
	public Payment getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(Payment paymentInfo) {
		this.paymentInfo = paymentInfo;
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
