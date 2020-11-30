package model;

public class Account {
	private String email;
	private String password;
	private FinancialInstitution bank;
	
	public Account(String mail, String pass, String cardNo, String fi) {
		email = mail;
		password = pass;
		bank = new FinancialInstitution(fi, cardNo);
	}
	
	public boolean verifyPassword(String p){
		return (p.equals(password));
	}

	public FinancialInstitution getFI() {return bank;}
	
	public String getEmail() {return email;}
}
