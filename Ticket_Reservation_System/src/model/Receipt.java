package model;

public class Receipt {
	private Reservation reservation;
	private int numTickets;
	private double preTaxTotal;
	private double price;
	private double postTaxTotal;
	private double tax;
	
	
	public Receipt(Reservation r) {
		setReservation(r);
	}
	
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
		setNumTickets(reservation.getTickets().size());
		setPrice(reservation.getTickets().get(0).getPrice());
		setPreTaxTotal(reservation.getReservationTotal());
		setTax(preTaxTotal / 20.00);
		setPostTaxTotal(preTaxTotal + tax);
	}	
	
	@Override
	public String toString() {
		String space = "			";
		String str = "General Ticket";
		if (numTickets > 1) str += "s";
		
		str += "	      " + numTickets + "   x   $" + String.format("%.2f", price);
		str += "   =   $" + String.format("%.2f", preTaxTotal);
		str += "\nTax" + space + " $" + String.format("%.2f", tax);
		str += "\n" + space + "----------------------------------\n";
		str += "Total" + space + "$" + String.format("%.2f", postTaxTotal);
		return str;
	}

	public double getPreTaxTotal() {
		return preTaxTotal;
	}

	public void setPreTaxTotal(double total) {
		this.preTaxTotal = total;
	}
	
	public double getPostTaxTotal() {
		return postTaxTotal;
	}

	public void setPostTaxTotal(double total) {
		this.postTaxTotal = total;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
}
