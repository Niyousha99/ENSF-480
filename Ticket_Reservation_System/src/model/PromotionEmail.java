package model;

public class PromotionEmail extends Email{
	private MovieNews moviePromos;
	
	public PromotionEmail(String userAddress, MovieNews promos) {
		super(userAddress);
		moviePromos = promos;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}

}
