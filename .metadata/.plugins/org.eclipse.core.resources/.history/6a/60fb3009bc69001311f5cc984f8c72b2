package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Controller.Driver;
/*******************************************************************************************
 * 	Title:	EnemyView
 * 	Purpose: 	Displays all current enemies
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class EnemyView extends JComponent{
	public BufferedImage enemyImg;
	public EnemyView(){
		try {
			enemyImg = ImageIO.read(new File("images/EnemyAlien.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < Driver.spawner.getEnemies().size(); i++){
			g.drawImage(enemyImg,Driver.spawner.getEnemies().get(i).x,Driver.spawner.getEnemies().get(i).y,75,75,null);
		}
	}

}
