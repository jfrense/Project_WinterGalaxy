package Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Background {
private Bitmap backgroundImage;	
private int x;
private int y;
private int backgroundWidth;
private int backgroundHeight;
private Rect sourceRect; // the rectangle to be drawn from the background bitmap

	
public Background(Bitmap bitmap, int x, int y, int width, int height){
	
	this.setX(x);
	this.setY(y);
	this.setBackgroundWidth(width);
	this.setBackgroundHeight(height);
	this.backgroundImage = bitmap;
	sourceRect = new Rect(0,0 ,backgroundWidth, backgroundHeight);
	}

public void ScrollForward(){
	this.sourceRect.left-=2;
	//this.sourceRect.right = this.sourceRect.left + spriteWidth;
	
}

public void ScrollBackward(){
	this.sourceRect.left+=2;
	//this.sourceRect.right = this.sourceRect.left + spriteWidth;
	
}

	
	


	public Bitmap getBackgroundImage() {
		return backgroundImage;
	}


	public void setBackgroundImage(Bitmap backgroundImage) {
		this.backgroundImage = backgroundImage;
	}





	public int getX() {
		return x;
	}





	public void setX(int x) {
		this.x = x;
	}





	public int getY() {
		return y;
	}





	public void setY(int y) {
		this.y = y;
	}





	public int getBackgroundWidth() {
		return backgroundWidth;
	}





	public void setBackgroundWidth(int backgroundWidth) {
		this.backgroundWidth = backgroundWidth;
	}





	public int getBackgroundHeight() {
		return backgroundHeight;
	}





	public void setBackgroundHeight(int backgroundHeight) {
		this.backgroundHeight = backgroundHeight;
	}
	
	public void draw(Canvas canvas) {
		// where to draw the sprite
		Rect destRect = new Rect(getX(), getY(), getX() + backgroundWidth, getY() + backgroundHeight);
		canvas.drawBitmap(backgroundImage, sourceRect, destRect, null);
		
		
		
	}
	

}
