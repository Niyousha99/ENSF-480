package model;

public class Time {
	private int hour, minute;
	
	public Time(int h, int m) {
		hour = h;
		minute = m;
	}
	
	// Returns time as a string
	@Override
	public String toString() {
		String str = hour + ":" + minute;
		
		return str;
	}
}
