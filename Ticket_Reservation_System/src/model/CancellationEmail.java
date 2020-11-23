package model;

public class CancellationEmail extends Email{

	private Receipt cancellationReceipt;
	// Did not include cancellation link because it is a GUI property instead
	
	public CancellationEmail(String userAddress) {
		super(userAddress);
	}

	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}
}
