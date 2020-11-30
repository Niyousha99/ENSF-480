package model;

public class Account {
	private String email;
	private String password;
	private String cardNumber;
	private FinancialInstitution bank;
	
	
	public Account(String mail, String pass, String cardNo, String fi) {
		email = mail;
		password = pass;
		cardNumber = cardNo;
		bank = new FinancialInstitution(fi);
	}
	
	public boolean verifyPassword(String p){
		return (p.equals(password));
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public FinancialInstitution getFI() {
		return bank;
	}
	
	public String getEmail() {
		return email;
	}
}
