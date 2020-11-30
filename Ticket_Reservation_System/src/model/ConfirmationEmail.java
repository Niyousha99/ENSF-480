package model;

public class ConfirmationEmail extends Email{
	private Receipt confirmationReceipt;
	
	public ConfirmationEmail(String userAddress, Reservation r) {
		super(userAddress, r);
	}
	
	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}

	public Receipt getConfirmationReceipt() {return confirmationReceipt;}

	public void setConfirmationReceipt(Receipt confirmationReceipt) {this.confirmationReceipt = confirmationReceipt;}
	
}
