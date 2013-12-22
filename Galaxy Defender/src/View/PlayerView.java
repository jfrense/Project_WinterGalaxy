package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Controller.Driver;
/*******************************************************************************************
 * 	Title:	Player View
 * 	Purpose: 	Displays the users character, and the D-Pad
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class PlayerView extends JComponent {
	BufferedImage[][] imgs;
	BufferedImage dPad,electricAttack;
	public int imgNum = 0;
	public int frameCount = 4;
	public PlayerView(){
		BufferedImage[] img = createAnimation();
		imgs = new BufferedImage[img.length][frameCount];
		for(int j = 0; j < img.length; j++) {
			for(int i = 0; i < 4; i++)
				imgs[j][i] = img[j].getSubimage((128) * i, 0, 128, 100);
		}
		try {
			dPad = ImageIO.read(new File("images/D-Pad.png"));
			electricAttack = ImageIO.read(new File("images/ElectricAttack.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Character Animation
		g.drawImage(imgs[0][imgNum],Driver.player.x, Driver.player.y,80,80,null);
		// Movement D-Pad
		g.drawImage(dPad, 50, Driver.frameHeight-185, 160, 160, null);
		if(Driver.player.attacking)
			g.drawImage(electricAttack,Driver.player.x+80, Driver.player.y,Driver.player.range,60,null);
	}
	
	//Read images from file and return
	private BufferedImage[] createAnimation() {
		BufferedImage[] bufferedImage = new BufferedImage[1];
		try {
			bufferedImage[0] = ImageIO.read(new File("images/PlayerWalkRight.png"));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
