package model;

import java.util.ArrayList;

public class MovieNews {
	private ArrayList<Movie> movies;
	
	public MovieNews(ArrayList<Movie> movieList) {
		movies = new ArrayList<Movie>();
		updateMovies(movieList);
		
	}
	
	public void updateMovies(ArrayList<Movie> movieList) {
		movies.clear();
		for(Movie m: movieList) {
			movies.add(m);
		}
	}
	
	// movie news announcement
	@Override
	public String toString() {
		String str = "";
		
		
		
		return str;
	}
	
	
}
