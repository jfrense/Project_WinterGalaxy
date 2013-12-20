package Controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
/*******************************************************************************************
 * 	Title:	User Interface
 * 	Purpose: 	Handles all user control of the game
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class UI extends JComponent implements MouseListener{
	public boolean rightHeld = false;
	public boolean leftHeld = false;
	public int moveCount = 0;
	public UI(){
		addMouseListener(this);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(rightHeld){
			Driver.pView.imgNum = (Driver.pView.imgNum + 1) % Driver.pView.frameCount;
			Driver.player.moveRight();
			moveCount++;
		}
		else if( leftHeld){
			Driver.player.moveLeft();
			moveCount--;
		}
		if(moveCount > 500){
			Driver.spawner.addEnemy();
			moveCount = 0;
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("X: " + e.getX() +"\t Y: " + e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX() > Driver.frameWidth-200){
			Driver.player.moveRight();
			rightHeld = true;
		}
		else if (e.getX() < 200){
			Driver.player.moveLeft();
			leftHeld = true;
		}
		else{
			Driver.player.attacking = true;
			Driver.player.attack();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		rightHeld = false;
		leftHeld = false;
		Driver.player.attacking = false;
	}

}