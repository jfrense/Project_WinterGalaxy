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
	public BufferedImage enemyImg, plasmaAttack;
	public EnemyView(){
		try {
			enemyImg = ImageIO.read(new File("images/EnemyAlien.png"));
			plasmaAttack = ImageIO.read(new File("images/ElectricAttack.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < Driver.spawner.getEnemies().size(); i++){ 
			// Draw Enemies
			g.drawImage(enemyImg,Driver.spawner.getEnemies().get(i).getX(),Driver.spawner.getEnemies().get(i).getY(),75,75,null);
			// Draw Enemies' Attack
			if(Driver.spawner.getEnemies().get(i).isAttacking())
				if(Driver.player.getX() < Driver.spawner.getEnemies().get(i).getX())	// Attack Left
					g.drawImage(plasmaAttack,Driver.player.getX()-Driver.player.getRange(), Driver.player.getY(),Driver.player.getRange(),60,null);
				else 			// Attack Right
					g.drawImage(plasmaAttack,Driver.player.getX()+80, Driver.player.getY(),Driver.player.getRange(),60,null);
		}
	}

}
