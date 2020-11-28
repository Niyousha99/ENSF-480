package view;
import java.awt.Color;

import model.*;

public class BookSeatsButton extends Button{
	private Movie movie;
	
	public BookSeatsButton(String name, Movie m) {
		super(name);
		setMovie(m);
	}
	
	public BookSeatsButton(String name, Movie m, Color t, Color b) {
		super(name, t, b);
		setMovie(m);
	}
	
	public BookSeatsButton(String name, Color t, Color b) {
		super(name, t, b);
	}

	public Movie getMovie() {return movie;}

	public void setMovie(Movie movie) {this.movie = movie;}

}
