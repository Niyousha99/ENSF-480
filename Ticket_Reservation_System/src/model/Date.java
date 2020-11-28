package model;

public class Date {
	private String year, month, day;
	
	public Date(String y, String m, String d) {
		year = y;
		month = m;
		day = d;
	}
	
	//Though we needed this so I added it, turns out we don't but don't delete just in case...
	@Override
	public boolean equals(Object o) { 
		
		// If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Date)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Date d = (Date) o; 
          
        // Compare the data members and return accordingly  
		if (year.equalsIgnoreCase(d.year) && month.equalsIgnoreCase(d.month) && day.equalsIgnoreCase(d.day)) return true; 
	    
		return false;
	}
	
	// Returns date as a string
	@Override
	public String toString() {
		String str = day + "/" + month + "/" + year;
		return str;
	}
}
