package controller;
import view.*;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;
import view.*;

// initialize and run application 

public class MasterController implements Constants{
	
	public static void main (String args[]) throws SQLException {
		// instantiate DBManager and get all required data from DB
		// to communicate between other controllers, models, views
		
		DBManager db = new DBManager();
		db.connectToLoadDB(DBURL, DBUSERNAME, DBPASSWORD);
		GUIController gui = new GUIController(db.getMovies(), db.getAccounts());
	}
}
