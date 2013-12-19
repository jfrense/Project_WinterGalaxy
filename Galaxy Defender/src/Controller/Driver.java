package Controller;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import Model.*;
import View.*;
/*******************************************************************************************
 * 	Title:	Driver
 * 	Purpose: 	Instantiates frame, and Essentially connects almost all classes together.
 * 
 *	@author Larry Sell
 *	@version 0.0.1
 *******************************************************************************************/
public class Driver {
	public static int frameWidth = 1000;
	public static int frameHeight = 700;
	public static JLayeredPane pane = new JLayeredPane();
	public static UI uI = new UI();
	public static Background background = new Background(0, "images\background");
	public static Spawner spawner = new Spawner(new int[]{300,400,500});
	public static Player player = new Player(150,400,5,50,1,"a");
	public static PlayerView pView = new PlayerView();
	public static EnemyView eView = new EnemyView();
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(frameWidth, frameHeight);
		uI.setSize(frameWidth, frameHeight);
		pView.setSize(frameWidth, frameHeight);
		eView.setSize(frameWidth, frameHeight);
		background.setSize(frameWidth, frameHeight);
		frame.add(pane);
		pane.add(uI);
		pane.add(pView);
		pane.add(eView);
		pane.add(background);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
