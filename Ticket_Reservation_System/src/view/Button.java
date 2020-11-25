package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class Button extends JButton{
	private Color top, bottom;
    private Paint gradient;
    private Point[] stopPoints = new Point[2];
    
    public Button(String name) {
    	this(name, Color.WHITE, Color.DARK_GRAY); // default gradient
    }
    
    public Button(String name, Color t, Color b){
        super(name);
        setContentAreaFilled(false);
        setFocusPainted(false);
        
        top = t;
        bottom = b;
        
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                invalidate();
            }
        });
    }

    public void invalidate() {
        super.invalidate();

        stopPoints[0] = new Point(0, 0);
        stopPoints[1] = new Point(0, getHeight());

        if (getModel().isPressed()) {
            gradient = new GradientPaint(stopPoints[0], bottom, stopPoints[1], top);
        } else {
            gradient = new GradientPaint(stopPoints[0], top, stopPoints[1], bottom);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
    	Graphics2D g2 = (Graphics2D) g.create();

        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();

        super.paintComponent(g);
    }
}
