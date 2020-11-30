package model;

public class ConfirmationEmail extends Email{
	private Receipt confirmationReceipt;
	
	public ConfirmationEmail(String userAddress, Reservation r) {
		super(userAddress, r);
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str = "Subject: Booking Confirmation\n\n";
		str += "Congratulations, your reservation is confirmed!";
		str += "Please find below your tickets and receipt.\n\n";
		str += confirmationReceipt;
		return str;
	}

	public Receipt getConfirmationReceipt() {return confirmationReceipt;}

	public void setConfirmationReceipt(Receipt confirmationReceipt) {this.confirmationReceipt = confirmationReceipt;}
	
}
