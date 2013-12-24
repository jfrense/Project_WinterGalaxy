package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import Controller.Driver;
/*******************************************************************************************
 * 	Title:	Spawner
 * 	Purpose: 	Creates all instances of Enemies, and holds them in an Array List
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class Spawner {
	private ArrayList<EnemyAlien> enemies = new ArrayList<EnemyAlien>();
	private Random gen = new Random();
	private int [] spawnHeights;
	
	/*
	 * Constructor instantiates optional spawn heights, and adds 1 enemy.
	 */
	public Spawner(int [] sHeights){
		spawnHeights= sHeights;
		enemies.add(new EnemyAlien(Driver.frameWidth-gen.nextInt(200), spawnHeights[gen.nextInt(sHeights.length)], 2, 50));
	}
	// Method returns the ArrayList of enemies
	public ArrayList<EnemyAlien> getEnemies(){
		return enemies;
	}
	// Method adds 1 enemy
	public void addEnemy(){
		enemies.add(new EnemyAlien(Driver.frameWidth+gen.nextInt(300), spawnHeights[gen.nextInt(spawnHeights.length)], 2, 50));
	}
	// Method removes the enemy at (xCoor,YCoor)
	public void removeEnemy(int xCoor, int yCoor){
		for(int i = 0; i<enemies.size(); i++)
			if((enemies.get(i).getX() == xCoor) && (enemies.get(i).getY() == yCoor)){
				enemies.remove(i);
				break;
			}
	}
	// Method Shifts all enemies Left
	public void shiftAllLeft(){
		for(int i = 0; i<enemies.size(); i++)
			enemies.get(i).shiftLeft();
	}
	// Method Shifts all enemies Right
	public void shiftAllRight(){
		for(int i = 0; i<enemies.size(); i++)
			enemies.get(i).shiftRight();
	}
}
