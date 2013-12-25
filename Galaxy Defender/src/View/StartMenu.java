package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Controller.Driver;

public class StartMenu extends JComponent{
	private BufferedImage menuImg;
	private boolean display = true;
	
	public StartMenu(){
		try {
			menuImg = ImageIO.read(new File("images/StartMenu.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(display){
			g.drawImage(menuImg,0,0,Driver.frameWidth,Driver.frameHeight,null);
		}
	}
	public boolean isDisplay(){
		return display;
	}
	public void setDisplay(boolean d){
		this.display = d;
	}
}
