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
		Driver.background.shiftRight();
		Driver.spawner.shiftAllRight();
	}
}
