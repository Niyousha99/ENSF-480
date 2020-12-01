package model;

public class Ticket {
	private Movie movie;
	private Seat seat;
	private Account account;
	private double price;
	
	public Ticket(Movie m, Seat s, Account a) {
		setMovie(m);
		setSeat(s);
		setAccount(a);
		price = 12.50;
	}

	public Seat getSeat() {
		return seat;
	}
	
	private void setSeat(Seat s) {seat = s;}
	
	public Movie getMovie() {return movie;}

	public void setMovie(Movie movie) {this.movie = movie;}

	public Account getAccount() {return account;}

	public void setAccount(Account account) {this.account = account;}
	
	public void setPrice(int p) {price = p;}
	
	public double getPrice() {return price;}
	
	@Override
	public String toString() {
		String str = movie.getTitle() + "\n";
		str += seat.toString() + "\n\n";
		return str;
	}
}
