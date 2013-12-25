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
	private int ability;
	private boolean isAlive; 
	private int distTraveled;
	private int enemiesEliminated;	
	
	public Player(int xCoor, int yCoor, int power, int range, int health, int ability){
		super(xCoor, yCoor, power, range, health);
		this.ability = ability;
		this.isAlive = true;
		this.distTraveled = 0;
	}
	public void moveRight(){
		//Driver.background.shiftLeft();
		Driver.spawner.shiftAllLeft();
		distTraveled++;
	}
	public void moveLeft(){
		if(Driver.background.getX()<=0){
			//Driver.background.shiftRight();
			Driver.spawner.shiftAllRight();
			distTraveled--;
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
		if(isAlive){
			for(int i = 0; i < Driver.spawner.getEnemies().size(); i++){
				if((Driver.spawner.getEnemies().get(i).getX() > getX()) && (Driver.spawner.getEnemies().get(i).getX() < getX()+getRange()+80) &&
				  (Driver.spawner.getEnemies().get(i).getY() == getY())){
					Driver.spawner.getEnemies().get(i).setHealth(Driver.spawner.getEnemies().get(i).getHealth() - getPower());
						if(Driver.spawner.getEnemies().get(i).getHealth() <= 0){
							enemiesEliminated++;
							Driver.spawner.getEnemies().remove(i);
						}
				}
			}
		}
	}
	public boolean isAlive(){
		return isAlive;
	}
	public void setAlive(boolean a){
		this.isAlive = a;
	}
	public int getDistTraveled(){
		return distTraveled;
	}
	public int getNumEliminated(){
		return enemiesEliminated;
	}
}
