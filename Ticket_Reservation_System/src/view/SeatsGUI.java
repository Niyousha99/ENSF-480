package view;
import model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeatsGUI extends JFrame implements Constants{
	
	/**
	 * Components of the frame 
	 */
	private JLabel background;
	private JPanel seatsPanel;
	
	private Button reserve, refresh;
	
	private SeatLabel[][] seatLabels;
	
	private ArrayList<Seat> selectedSeats;
	
	public SeatsGUI(Seat[][] seats) {
		super("View Seats");
		setBounds(400, 100, 1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout());
		displaysSeats(seats);
	}
	
	private void displaysSeats(Seat[][] seats) {
		seatLabels = new SeatLabel[SEATROWS][SEATCOLS];
		selectedSeats = new ArrayList<Seat>();
		
		// Add background image
		background = new JLabel(new ImageIcon("src/img/curtains.jpg"));
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
		background.add(Box.createRigidArea(new Dimension(0, 300)));
		
		// Add seats
		setSeatsPanel(seats);
		
		// Add refresh and reserve buttons
		background.add(Box.createRigidArea(new Dimension(0, 100)));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.WHITE);
		refresh = new Button("refresh");
		reserve = new Button("reserve");
		reserve.setEnabled(false);
		buttonPanel.add(refresh);
		buttonPanel.add(reserve);
		background.add(buttonPanel);
		
		add(background);
	}
	
	public void setSeatsPanel(Seat[][] seats) {
		seatsPanel = new JPanel();
		seatsPanel.setLayout(new GridLayout(0, 7));
		seatsPanel.setBackground(Color.WHITE);
		seatsPanel.setSize(210, 90);
		
		for (int i = 0; i < SEATROWS; i++) {
			for (int j = 0, c = 0; j < SEATCOLS; j++, c++) {
				if (c == 3) {
					seatsPanel.add(new JLabel());
					j--;
				}
				else{
					SeatLabel seat = createSeatLabel(seats[i][j]);
					createEventHandler(seat);
					seatsPanel.add(seat);
					seatLabels[i][j] = seat;
				}
			}
		}
		background.add(seatsPanel);
	}

	private SeatLabel createSeatLabel(Seat seat) {
		return new SeatLabel(seat, getSeatImg(seat));
	}
	
	private String getSeatImg(Seat seat) {
		String seatImg;
		if (seat.isReserved()) seatImg = "src/img/reserved_seat.jpg";
		else if(seat.isSelected()) seatImg = "src/img/selected_seat.jpg";
		else seatImg = "src/img/available_seat.jpg";
		
		return seatImg;
	}

	private void createEventHandler(SeatLabel seatLabel) {
		seatLabel.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {
		    	if (seatLabel.getSeat().isReserved()) return;
		    	
		    	seatLabel.getSeat().setSelected(true);
		    	seatLabel.setIcon(new ImageIcon("src/img/selected_seat.jpg"));
		    	selectedSeats.add(seatLabel.getSeat());
		    	reserve.setEnabled(true);
		    }
		});
		
	}
	
	public void refresh() {
		for (SeatLabel[] row: seatLabels) {
			for (SeatLabel col: row) {
				col.getSeat().setSelected(false);
				col.setIcon(new ImageIcon("src/img/available_seat.jpg"));
			}
		}
		reserve.setEnabled(false);
	}

	public JButton getReserveButton() {return reserve;}
	
	public JButton getRefreshButton() {return refresh;}

	public ArrayList<Seat> getSelectedSeats() {return selectedSeats;}

	public JLabel[][] getSeats() {return seatLabels;}

}
