package Model;

import Controller.Driver;
/*******************************************************************************************
 * 	Title:	Player
 * 	Purpose: 	Handles Player Object
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class Player extends Alien {
	public int ability;
	public boolean attacking;
	
	public Player(int xCoor, int yCoor, int power, int range, int ability){
		super(xCoor, yCoor, power, range);
		this.ability = ability;
	}
	public void moveRight(){
		Driver.background.shiftLeft();
		Driver.spawner.shiftAllLeft();
	}
	public void moveLeft(){
		if(Driver.background.getX()<=0){
			Driver.background.shiftRight();
			Driver.spawner.shiftAllRight();
		}
	}
	public void jump(){
		if(getY() == 280)
			setY(190);
		else if (getY() == 418)
			setY(280);
	}
	public void crouch(){
		if(getY() == 190)
			setY(280);
		else if (getY() == 280)
			setY(418);
	}
	public void attack(){
		for(int i = 0; i < Driver.spawner.getEnemies().size(); i++){
			if((Driver.spawner.getEnemies().get(i).getX() > Driver.player.getX()) && 
			  (Driver.spawner.getEnemies().get(i).getX() < Driver.player.getX()+getRange()+80) &&
			  (Driver.spawner.getEnemies().get(i).getY() == getY())){
				Driver.spawner.getEnemies().remove(i);
			}
		}
	}
}
