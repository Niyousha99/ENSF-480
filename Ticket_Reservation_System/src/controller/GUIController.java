package controller;
import view.*;
import model.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUIController {
	private ArrayList<Movie> movies;
	private ArrayList<Account> accounts;
	
	private MainGUI mainFrame;
	private LoginGUI loginWindow;
	private MoviesGUI moviesFrame;
	private SeatsGUI seatsFrame;
	
	public GUIController(ArrayList<Movie> m, ArrayList<Account> a) {
		movies = m;
		accounts = a;
		initMainFrame();
	}
	
	private void initMainFrame() {
		mainFrame = new MainGUI();
		mainFrame.setVisible(true);
		mainFrameEventHandler();
	}
	
	
	private void initCancelTicketFrame() {
		// TODO Auto-generated method stub
		
	}

	private void initLoginFrame() {
		loginWindow = new LoginGUI();
		loginWindow.setVisible(true);
		loginEventHandler();
	}
	
	
	private void initMoviesFrame() {
		moviesFrame = new MoviesGUI(movies);
		moviesFrame.setVisible(true);
		moviesFrameEventHandler();
		
	}
	
	private void initShowtimesFrame(Movie m) {
		
		//showtimesFrame = new ShowtimesGUI(m);
		// 
	}
	
	private void initSeatsFrame() {
		//seatsFrame = new SeatsGUI();
		seatsFrame.setVisible(true);
		seatsFrameEventHandler();
	}
	
	/**
	 * Switches back to the desired frame supplied by the first parameter by disposing the frame supplied by the second parameter 
	 * and setting the desired frame to visible.
	 * 
	 * @param desiredFrame is the frame to be displayed
	 * @param disposeFrame is the frame to be disposed
	 */
	private void switchFrame(JFrame desiredFrame, JFrame disposeFrame) {
		disposeFrame.dispose();
		desiredFrame.setVisible(true);
	}
	
	
	/**
	 * Waits and responds to events in mainFrame through lambda expressions.
	 */
	private void mainFrameEventHandler() {
		mainFrame.getBrowseMoviesButton().addActionListener((ActionEvent e) ->{
			mainFrame.dispose();
			initMoviesFrame();
		});
		
		mainFrame.getCancelTicketButton().addActionListener((ActionEvent e) ->{
			mainFrame.dispose();
			initCancelTicketFrame();
		});
	}
	
	// TODO Login event handlers
	
	private void loginEventHandler() {
		loginWindow.getLoginButton().addActionListener((ActionEvent e) ->{
					
		});	
		
		loginWindow.getRegisterButton().addActionListener((ActionEvent e) ->{
			
		});
	}
	
	// TODO Movies Frame event handlers

	private void moviesFrameEventHandler() {
		
		moviesFrame.getShowtimeMenu().addActionListener((ActionEvent e) ->{
			String selectedShowtime = (String)(((JComboBox)e.getSource()).getSelectedItem());
			
			
		});	
		
		for (JButton b: moviesFrame.getBookSeatsButtons()) {
			b.addActionListener((ActionEvent e) ->{
				
			});
			
			
		}
	}

	// TODO Seats Frame event handlers
	private void seatsFrameEventHandler() {
		loginWindow.getLoginButton().addActionListener((ActionEvent e) ->{
			
		});	
	}

}
