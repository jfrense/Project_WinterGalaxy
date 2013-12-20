package Model;
/*******************************************************************************************
 * 	Title:	Enemy Alien
 * 	Purpose: 	Handles Enemy Alien Object
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class EnemyAlien {
	public int x;
	public int y;
	public int power;
	public int range;
	public String imgLoc;
	
	/*
	 * Constructor with Pre-Determined Image 
	 */
	public EnemyAlien(int xCoor, int yCoor, int power, int range){
		this.x = xCoor;
		this.y = yCoor;
		this.power = power;
		this.range = range;
		this.imgLoc = "images/EnemyAlien";
	}
	/*
	 * Main Constructor 
	 */
	public EnemyAlien(int xCoor, int yCoor, int power, int range, String imageLoc){
		this.x = xCoor;
		this.y = yCoor;
		this.power = power;
		this.range = range;
		this.imgLoc = imageLoc;
	}
	public void shiftLeft(){
		x-=2;
	}
	public void shiftRight(){
		x+=2;
	}
}
