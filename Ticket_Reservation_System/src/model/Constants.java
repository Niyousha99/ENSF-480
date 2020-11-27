package model;

public interface Constants {
	// A typical theater has 25 rows with 30 seats in each row
	public static final int SEATROWS = 3;
	public static final int SEATCOLS = 6;
	
	// Credentials to connect to database
	public static final String DBURL = "jdbc:mysql://localhost:8000/ticket_reservation_backend";
	public static final String DBUSERNAME = "root";
	public static final String DBPASSWORD = "root";
}
