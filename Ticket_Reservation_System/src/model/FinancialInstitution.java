package model;

public class FinancialInstitution {
	private String bankName;
	private String cardNumber;
	private double balance;
	
	public FinancialInstitution(String name, String cardNum) {
		setBankName(name);
		setCardNumber(cardNum);
		setBalance(50);
	}
	
	public void deposit(double amount) {balance += amount;}
	
	public boolean withdraw(double amount) {
		double remainingBalance = balance - amount;
		if (remainingBalance < 0) return false;
		
		balance = remainingBalance;
		return true;
	}
	
	public String getBankName() {return bankName;}
	
	public void setBankName(String bankName) {this.bankName = bankName;}

	public double getBalance() {return balance;}

	public void setBalance(double balance) {this.balance = balance;}

	public String getCardNumber() {return cardNumber;}

	public void setCardNumber(String cardNumber) {this.cardNumber = cardNumber;}
}
