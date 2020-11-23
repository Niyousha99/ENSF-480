package model;

import java.util.ArrayList;

public class Theater implements Constants{
	private ArrayList<Movie> movieList;
	private Seat[][] seats; // added seats to be constructed in theater
	private MovieNews news;
	
	public Theater() {
		seats = new Seat[SEATROWS][SEATCOLS];
		setSeats();
		createMovieNews();
	}
	
	private void createMovieNews() {
		news = new MovieNews(movieList);
		
	}

	private void setSeats(){
		for (int i = 1; i <= SEATROWS; i++) {
			for (int j = 1; j <= SEATCOLS; j++) {
				
			}
		}
	}
	
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void addMovie(Movie m) {
		movieList.add(m);
		news.updateMovies(movieList);
	}
	
	public void deleteMovie(Movie targetMovie) {
		movieList.remove(targetMovie);
		news.updateMovies(movieList);
	}
	
	public String announceMovieNews() {
		return news.toString();
	}
	
	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}
	
}
