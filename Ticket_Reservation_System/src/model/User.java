package model;

public class User {
	private String email;
	private FinancialInstitution bank;
	
	public User(String e) {
		email = e;
	}
	
	public User(String e, String cardNum, String bankName) {
		email = e;
		bank = new FinancialInstitution(cardNum, bankName);
	}
	
	public void setEmail(String e) {email = e;}
	
	public String getEmail() {return email;}

	public FinancialInstitution getBank() {
		return bank;
		}

	public void setBank(FinancialInstitution bank) {this.bank = bank;}
}
