package model;

public class ConfirmationEmail extends Email{
	
	public ConfirmationEmail(String userAddress, Reservation r, Receipt rec ) {
		super(userAddress, r, rec);
	}
	
	// prints email header and text content. Image content handled by EmailGUI.
	@Override
	public String toString() {
		String str = super.toString();
		str += "Subject: Booking Confirmation\n\n\n";
		str += "Congratulations, your reservation is confirmed!\n";
		str += "Please find below your tickets and receipt.\n\n";
		return str;
	}

	

	
}
