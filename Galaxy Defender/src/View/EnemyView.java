package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;

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
			if(Driver.spawner.getEnemies().get(i).isAttacking()){
				if(Driver.player.getY() == Driver.spawner.getEnemies().get(i).getY()){
					g.drawImage(plasmaAttack,Driver.spawner.getEnemies().get(i).plasmaX, Driver.player.getY(),25,25,null);
					Driver.spawner.getEnemies().get(i).setCurrentTime();
					Driver.spawner.getEnemies().get(i).plasmaX -= (int)(0.01*(Driver.spawner.getEnemies().get(i).currentTime - Driver.spawner.getEnemies().get(i).startTime));
					
					// If player is hit
					if(Driver.spawner.getEnemies().get(i).plasmaX <= Driver.player.getX()){
						Driver.spawner.getEnemies().get(i).hit();
						Driver.spawner.getEnemies().get(i).resetPlasmaX();
					}
				}
				else
					Driver.spawner.getEnemies().get(i).setAttacking(false);
			}
			
			
			// Health Bar
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(new Color(255, 0, 0));					// Low Attract => Red
			// Negative Case
			if(Driver.spawner.getEnemies().get(i).getHealth() < 0)				
				g2d.fillRect(Driver.spawner.getEnemies().get(i).getX(), Driver.spawner.getEnemies().get(i).getY()-30, 0, 22);
			// Normal Case
			else if(Driver.player.getHealth() <= 100){		
				if ((Driver.spawner.getEnemies().get(i).getHealth() > 33) && (Driver.spawner.getEnemies().get(i).getHealth() <= 66))
					g2d.setColor(new Color(255, 255, 0));			// Medium Attract => Yellow 
				else if(Driver.player.getHealth() > 66)
					g2d.setColor(new Color(0, 255, 0));			// Good Attract => Green
				g2d.fillRect(Driver.spawner.getEnemies().get(i).getX(), Driver.spawner.getEnemies().get(i).getY()-30, Driver.spawner.getEnemies().get(i).getHealth(), 22);
			}
			// Over Max Case
			else {													
				g2d.setColor(new Color(0, 255, 0));				// Good Attract => Green
				g2d.fillRect(Driver.spawner.getEnemies().get(i).getX(), Driver.spawner.getEnemies().get(i).getY()-30, 100, 22);
			}
		}
	}

}
