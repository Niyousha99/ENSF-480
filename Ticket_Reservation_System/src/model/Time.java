package model;

public class Time {
	//private int hour, minute;
	private String time; 
	
//	public Time(int h, int m) {
//		hour = h;
//		minute = m;
//	}
	
	public Time(String t) {
		time =t;
	}
	
	//Though we needed this so I added it, turns out we don't but don't delete just in case...
	//@Override
//	public boolean equals(Object o) { 
//		
//		// If the object is compared with itself then return true   
//        if (o == this) { 
//            return true; 
//        } 
//  
//        /* Check if o is an instance of Time or not 
//          "null instanceof [type]" also returns false */
//        if (!(o instanceof Time)) { 
//            return false; 
//        } 
//          
//        // typecast o to Complex so that we can compare data members  
//        Time t = (Time) o; 
//          
//        // Compare the data members and return accordingly  
//		if (hour == t.hour && minute == t.minute) return true; 
//	   
//		return false;
//	}
	
	// Returns time as a string
	@Override
	public String toString() {
		
		return time;
	}
}
