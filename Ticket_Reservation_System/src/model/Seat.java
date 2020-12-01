package model;

public class Seat {
	private char row;
	private int col;
	private boolean selected, reserved; 
	
	public Seat(char r, int c) {
		assert (r >= 'A' && r <= 'Z' && c > 0);
		row = r;
		col = c;
		setSelected(false);
		reserved = false; // seat is automatically available upon creation
	}

	public int getRow() {return row;}

	public void setRow(char row) {this.row = row;}

	public int getCol() {return col;}

	public void setCol(int col) {this.col = col;}

	public boolean isReserved() {return reserved;}

	public void setReserved(boolean reserved) {this.reserved = reserved;}

	public boolean isSelected() {return selected;}

	public void setSelected(boolean selected) {this.selected = selected;}
	
	public boolean equals(Seat s) {
		if (s.row == row && s.col == col) return true;
		return false;
	}
	
	@Override
	public boolean equals(Object o) { 
		// If the object is compared with itself then return true   
        if (o == this) return true; 
  
        /* Check if o is an instance of Time or not 
          "null instance of [type]" also returns false */
        if (!(o instanceof Seat)) return false; 
         
        // type-cast o to Complex so that we can compare data members  
        Seat t = (Seat) o; 
          
        // Compare the data members and return accordingly  
		if (toString().equalsIgnoreCase(o.toString())) return true; 
		return false;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += row;
		str += Integer.toString(col);
		
		return str;
	}
}
