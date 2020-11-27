package model;

public class Date {
	private String year, month, day;
	
	public Date(String y, String m, String d) {
		year = y;
		month = m;
		day = d;
	}
	
	// Returns date as a string
	@Override
	public String toString() {
		String str = day + " " + month + ", " + year;
		return str;
	}
}
