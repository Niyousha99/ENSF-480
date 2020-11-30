package model;

public class User {
	private String email;
	private String name;
	private FinancialInstitution bank;
	
	public User(String n) {name = n;}
	
	public void setEmail(String e) {email = e;}
	
	public String getName() {return name;}
	
	public String getEmail() {return email;}

	public FinancialInstitution getBank() {return bank;}

	public void setBank(FinancialInstitution bank) {this.bank = bank;}
}
