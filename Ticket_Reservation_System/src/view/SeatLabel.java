package view;
import model.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SeatLabel extends JLabel{
	
	Seat seat;
	
	public SeatLabel(Seat seat, String seatImg) {
		super(new ImageIcon(seatImg));
		this.seat = seat;
	}
	
	public Seat getSeat() {return seat;}
	
}
