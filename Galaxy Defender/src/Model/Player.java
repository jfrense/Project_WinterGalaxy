package Model;

import Controller.Driver;
/*******************************************************************************************
 * 	Title:	Player
 * 	Purpose: 	Handles Player Object
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class Player {
	public int x;
	public int y;
	public int power;
	public int range;
	public int ability;
	public String imgLoc;
	public boolean attacking;
	
	public Player(int xCoor, int yCoor, int power, int range, int ability, String imageLoc){
		this.x = xCoor;
		this.y = yCoor;
		this.power = power;
		this.range = range;
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
		if(y == 280)
			y = 190;
		else if (y == 418)
			y = 280;
	}
	public void crouch(){
		if(y == 190)
			y = 280;
		else if (y == 280)
			y = 418;
	}
	public void attack(){
		for(int i = 0; i < Driver.spawner.getEnemies().size(); i++){
			if((Driver.spawner.getEnemies().get(i).x > Driver.player.x)&&(Driver.spawner.getEnemies().get(i).x < Driver.player.x+range+80) &&
			  (Driver.spawner.getEnemies().get(i).y == y)){
				Driver.spawner.getEnemies().remove(i);
			}
		}
	}
}
