package Model;
/*******************************************************************************************
 * 	Title:	Alien
 * 	Purpose: 	Superclass for Player and EnemyAlien. 
 * 				Contains all common attributes, and Getters and Setters.
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class Alien {
	private int x;
	private int y;
	private int power;
	private int range;
	private int health;
	private String imgLoc;
	private boolean attacking;
	
	public Alien(int xCoor, int yCoor, int power, int range, int health){
		this.x = xCoor;
		this.y = yCoor;
		this.power = power;
		this.range = range;
		this.health = health;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getPower(){
		return power;
	}
	public int getRange(){
		return range;
	}
	public int getHealth(){
		return health;
	}
	public String getImgLoc(){
		return imgLoc;
	}
	public boolean isAttacking(){
		return attacking;
	}
	public void setX(int xCoor){
		this.x = xCoor;
	}
	public void setY(int yCoor){
		this.y = yCoor;
	}
	public void setPower(int p){
		this.power = p;
	}
	public void setRange(int r){
		this.range = r;
	}
	public void setHealth(int h){
		this.health = h;
	}
	public void setImgLoc(String location){
		this.imgLoc = location;
	}
	public void setAttacking(boolean a){
		this.attacking = a;
	}
}
