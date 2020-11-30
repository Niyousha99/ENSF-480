package model;

public class ConfirmationEmail extends Email{
	
	public ConfirmationEmail(String userAddress, Reservation r, Receipt rec ) {
		super(userAddress, r, rec);
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str = "Subject: Booking Confirmation\n\n";
		str += "Congratulations, your reservation is confirmed!";
		str += "Please find below your tickets and receipt.\n\n";
		str += super.getReceipt().toString();
		return str;
	}

	

	
}
