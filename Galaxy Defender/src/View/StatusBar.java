package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JLabel;

import Controller.Driver;

public class StatusBar extends JComponent {
	public JLabel healthLabel, elimLabel;
	public int hBarLoc = 50;
	public int eBarLoc = (Driver.frameWidth/2)-100;
	public StatusBar(){
		healthLabel = new JLabel("Health");
		healthLabel.setFont(new Font("Serif", Font.BOLD, 18));
		healthLabel.setBounds(hBarLoc+5, 10, 60, 50);
		elimLabel = new JLabel("Eliminated");
		elimLabel.setFont(new Font("Serif", Font.BOLD, 18));
		elimLabel.setBounds(eBarLoc+4, 10, 200, 50);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Health Bar
		add(healthLabel);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3));
		g2d.drawRect(hBarLoc, 10, 60, 50);
		g2d.drawRect(hBarLoc+60, 10, 202, 50);
		g2d.setColor(new Color(255, 0, 0));					// Low Attract => Red
		// Negative Case
		if(Driver.player.getHealth() < 0)				
			g2d.fillRect(hBarLoc+62, 12, 0, 47);
		// Normal Case
		else if(Driver.player.getHealth() <= 100){		
			if ((Driver.player.getHealth() > 33) && (Driver.player.getHealth() <= 66))
				g2d.setColor(new Color(255, 255, 0));			// Medium Attract => Yellow 
			else if(Driver.player.getHealth() > 66)
				g2d.setColor(new Color(0, 255, 0));			// Good Attract => Green
			g2d.fillRect(hBarLoc+62, 12, Driver.player.getHealth()*2, 47);
		}
		// Over Max Case
		else {													
			g2d.setColor(new Color(0, 255, 0));				// Good Attract => Green
			g2d.fillRect(hBarLoc+62, 12, 200, 47);
		}
		
		
		// Eliminated Bar
		elimLabel.setText("Eliminated   " + Driver.player.getNumEliminated() + " Enemies");
		add(elimLabel);
		g2d.setColor(new Color(0, 0, 0));		
		g2d.drawRect(eBarLoc, 10, 90, 50);
		g2d.drawRect(eBarLoc+90, 10, 110, 50);
		
	}
}