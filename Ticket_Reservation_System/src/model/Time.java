package model;

public class Time {
	private String time; 
	
	public Time(String t) {
		time = t;
	}
	
	@Override
	public boolean equals(Object o) { 
		
		// If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Time or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Time)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Time t = (Time) o; 
          
        // Compare the data members and return accordingly  
		if (time.equalsIgnoreCase(o.toString())) return true; 
		return false;
	}
	
	// Returns time as a string
	@Override
	public String toString() {return time;}
}
