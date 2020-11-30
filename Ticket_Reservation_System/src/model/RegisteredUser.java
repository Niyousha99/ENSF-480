package model;

public class RegisteredUser extends User {
	
	private Account account;
	
	public RegisteredUser(String e, String bankName, String cardNum) {
		super(e);
		setAccount(bankName, cardNum);
	}

	public RegisteredUser(String e, Account a) {
		super(e);
		setAccount(a);
	}
	
	private void setAccount(String bankName, String cardNum) {
		FinancialInstitution fi = new FinancialInstitution(bankName, cardNum);
	}

	public Account getAccount() {return account;}

	public void setAccount(Account account) {this.account = account;}
	
}
