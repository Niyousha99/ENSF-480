package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MoviePosterGUI {
	
	private JLabel poster;
	
	public MoviePosterGUI(String movieTitle) {
		// get image
		ImageIcon imageIcon = new ImageIcon(getImgFile(movieTitle));
					
		// re-scale image
		Image image = imageIcon.getImage();
		Image newImage = image.getScaledInstance(400, 700, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newImage);
		
		// create movie poster with image
		poster = new JLabel(imageIcon);
		poster.setHorizontalAlignment(JLabel.CENTER);
        poster.setVerticalAlignment(JLabel.CENTER);
	}

	// assuming that movie titles are capitalized and spaced apart
	private String getImgFile(String movieTitle) {
		StringBuilder imgFile = new StringBuilder("src/img/");
		imgFile.append(movieTitle.replace(' ', '_'));
		imgFile.append(".jpg");
		return imgFile.toString();
	}
	
	public JLabel getPoster() {return poster;}
}
