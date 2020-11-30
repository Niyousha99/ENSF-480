package model;

public class RegisteredUser extends User {
	
	private Account account;
	
	public RegisteredUser(String n, String bankName, String cardNum) {
		super(n);
		setAccount(bankName, cardNum);
	}

	private void setAccount(String bankName, String cardNum) {
		FinancialInstitution fi = new FinancialInstitution(bankName, cardNum);
	}

	public Account getAccount() {return account;}

	public void setAccount(Account account) {this.account = account;}

}
