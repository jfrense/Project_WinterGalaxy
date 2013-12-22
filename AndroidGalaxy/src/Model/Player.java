package Model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Player {
	private Bitmap bitmap;
	private Rect sourceRect; // the rectangle to be drawn from the animation bitmap
	private int numOfFrames; // number of frames in animation
	private int currentFrame;
	private long frameTicker;
	private int framePeriod; // milliseconds between each frame(1000/fps)
	
	private int spriteWidth;
	private int spriteHeight;
	
	private int x; // the X coordinate of the object (top left of image)
	private int y; // the Y coordinate of the object (top left)
	
	// constructor 
	public Player(Bitmap bitmap, int x, int y, int width, int height, int fps, int frameCount){
		this.bitmap = bitmap;
		this.setX(x);
		this.setY(y);
		currentFrame = 0;
		numOfFrames = frameCount;
		spriteWidth = bitmap.getWidth() / frameCount;
		spriteHeight = bitmap.getHeight();
		sourceRect = new Rect(0,0 ,spriteWidth, spriteHeight);
		framePeriod = 1000/ fps;
		frameTicker = 0l;
		
		
		
	}
	
	public void update(long gameTime){
		if(gameTime > frameTicker + framePeriod) {
			frameTicker = gameTime;
			// increment frame
			currentFrame++;
			if(currentFrame >= numOfFrames){
				currentFrame = 0;
			}
		}
		
		// define the rectangle to cut out sprite
		
		this.sourceRect.left = currentFrame * spriteWidth;
		this.sourceRect.right = this.sourceRect.left + spriteWidth;
		
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	public Rect getSourceRect() {
		return sourceRect;
	}
	public void setSourceRect(Rect sourceRect) {
		this.sourceRect = sourceRect;
	}
	public int getNumOfFrames() {
		return numOfFrames;
	}
	public void setNumOfFrames(int numOfFrames) {
		this.numOfFrames = numOfFrames;
	}
	public int getCurrentFrame() {
		return currentFrame;
	}
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	public int getFramePeriod() {
		return framePeriod;
	}
	public void setFramePeriod(int framePeriod) {
		this.framePeriod = framePeriod;
	}
	public int getSpriteWidth() {
		return spriteWidth;
	}
	public void setSpriteWidth(int spriteWidth) {
		this.spriteWidth = spriteWidth;
	}
	public int getSpriteHeight() {
		return spriteHeight;
	}
	public void setSpriteHeight(int spriteHeight) {
		this.spriteHeight = spriteHeight;
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
	
	// the draw method which draws the corresponding frame
	public void draw(Canvas canvas) {
		// where to draw the sprite
		Rect destRect = new Rect(getX(), getY(), getX() + spriteWidth, getY() + spriteHeight);
		canvas.drawBitmap(bitmap, sourceRect, destRect, null);
		
		
		
	}

	
	
	
}
