package model;

public class User {
	private String email;
	private FinancialInstitution bank;
	
	public User(String e) {
		email = e;
	}
	
	public void setEmail(String e) {email = e;}
	
	public String getEmail() {return email;}

	public FinancialInstitution getBank() {
		System.out.println("Bank!");
		return bank;
		}

	public void setBank(FinancialInstitution bank) {this.bank = bank;}
}
