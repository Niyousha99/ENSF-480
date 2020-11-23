package model;

public class RegisteredUser extends User {
	
	private Account account;
	
	public RegisteredUser(String n, String bankName) {
		super(n);
		setAccount(bankName);
	}

	private void setAccount(String bankName) {
		Payment payment = new Payment();
		FinancialInstitution fi = new FinancialInstitution(bankName);
		
		
	}

}
