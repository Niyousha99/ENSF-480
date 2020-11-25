package model;

public class Seat {
	private char row;
	private int col;
	private boolean reserved; // == seatBooked
	
	public Seat(char r, int c) {
		assert (r >= 'A' && r <= 'Z' && c > 0);
		row = r;
		col = c;
		reserved = false; // seat is automatically available upon creation
	}

	public int getRow() {
		return row;
	}

	public void setRow(char row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
	public boolean equals(Seat s) {
		if (s.row == row && s.col == col) return true;
		return false;
	}
	
	
	// convert row number to alphabet to general alphanumeric
	// code for seat (e.g. row = 1 and col = 1 translates to A1)
	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}
	
}
