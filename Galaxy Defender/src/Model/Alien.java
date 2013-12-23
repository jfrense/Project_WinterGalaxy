package Model;

public class Alien {
	private int x;
	private int y;
	private int power;
	private int range;
	private String imgLoc;
	
	public Alien(int xCoor, int yCoor, int power, int range){
		this.x = xCoor;
		this.y = yCoor;
		this.power = power;
		this.range = range;
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
	public String getImgLoc(){
		return imgLoc;
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
	public void setImgLoc(String location){
		this.imgLoc = location;
	}
}
