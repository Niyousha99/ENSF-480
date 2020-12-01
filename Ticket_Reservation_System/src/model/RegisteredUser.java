package model;

public class RegisteredUser extends User {
	
	private Account account;
	
	public RegisteredUser(String e, Account a) {
		super(e);
		setAccount(a);
	}

	public Account getAccount() {return account;}

	public void setAccount(Account account) {this.account = account;}
	
}
