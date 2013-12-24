package Model;

import Controller.Driver;

/*******************************************************************************************
 * 	Title:	Enemy Alien
 * 	Purpose: 	Handles Enemy Alien Object
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class EnemyAlien extends Alien {
	public long startTime, currentTime;		// Used for shooting
	public int plasmaX;
	/*
	 * Constructor with Pre-Determined Image 
	 */
	public EnemyAlien(int xCoor, int yCoor, int power, int range, int health){
		super(xCoor, yCoor, power, range, health);
		this.setImgLoc("images/EnemyAlien");
	}
	public void shiftLeft(){
		this.setX(getX()-2);
	}
	public void shiftRight(){
		this.setX(getX()+2);
	}
	public void attack(){
		startTime = System.currentTimeMillis();
		plasmaX = getX();
		setAttacking(true);
	}
	public void hit(){
		Driver.player.setHealth(Driver.player.getHealth()-getPower());
		System.out.println("Health: " + Driver.player.getHealth());
		if(Driver.player.getHealth() <= 0){
			Driver.spawner.stopAll();
			Driver.player.setAlive(false);
		}
	}
	public void setCurrentTime(){
		currentTime = System.currentTimeMillis();
	}
	public void resetPlasmaX(){
		startTime = System.currentTimeMillis();
		plasmaX = getX();
	}
}
