package com.example.androidgalaxy;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
	
	private static final String TAG = MainThread.class.getSimpleName();
	
	
	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;
	private boolean running;
	
	public void setRunning(boolean running){
		this.running = running;
		
	}
	
	public MainThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel){
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
				
		
		
	}
	
	@Override
	public void run(){
		Canvas canvas;
		long tickCount = 0L;
		Log.d(TAG, "Starting game loop");
		while(running){
			canvas = null;
			tickCount++;
			try{
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder){
					//draws canvas on the panel
					
					this.gamePanel.onDraw(canvas);
				}
				
				
			} finally {
				
				if (canvas != null){
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}

		}
		Log.d(TAG, "Game loop executed " + tickCount + " times");
		
		
	}
	

}
