package model;

public class Ticket {
	private Movie movie;
	private Seat seat;
	private Account account;
	
	public Ticket(Movie m, Seat s, Account a) {
		setMovie(m);
		setSeat(s);
		setAccount(a);
	}

	public Seat getSeat() {
		return seat;
	}
	
	private void setSeat(Seat s) {seat = s;}
	
	public Movie getMovie() {return movie;}

	public void setMovie(Movie movie) {this.movie = movie;}

	public Account getAccount() {return account;}

	public void setAccount(Account account) {this.account = account;}
	
	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}
}
