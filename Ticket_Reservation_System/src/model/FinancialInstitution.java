package model;

public class FinancialInstitution {
	private String bankName;
	// TODO Think of other attributes and operations for bank
	// perhaps credit card balance to show effects of purchases and refunds?
	public FinancialInstitution(String name) {
		setBankName(name);
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	

}
