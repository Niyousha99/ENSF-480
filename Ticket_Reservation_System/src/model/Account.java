package model;

public class Account {
	private String password;
	private Payment paymentInfo;
	private String cardNumber;
	private FinancialInstitution bank;
	
	
	public Account(String pass, Payment pay, String cardNo, FinancialInstitution fi) {
		password = pass;
		paymentInfo = pay;
		cardNumber = cardNo;
		bank = fi;
		
	}
	
	public boolean verifyPassword(String p){
		return (p.equals(password));
	}

	public Payment getPaymentInfo() {
		return paymentInfo;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public FinancialInstitution getFi() {
		return bank;
	}
}
