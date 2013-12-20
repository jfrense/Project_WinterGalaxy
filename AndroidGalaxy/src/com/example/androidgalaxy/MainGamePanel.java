package com.example.androidgalaxy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback {
	

	private static final String TAG = MainGamePanel.class.getSimpleName();
	
	private MainThread thread;
	private Background background;

	public MainGamePanel(Context context) {
		super(context);

		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		
		// create and load background
		background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.background));

		// creating game thread
		thread = new MainThread(getHolder(), this);

		//   make the GmaePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		thread.setRunning(true);
		thread.start();
		
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		Log.d(TAG, "Surface is being destroyed");
		boolean retry = true;
		while(retry){
			try{
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again to shutdown thread
			}

		}
		Log.d(TAG, "Thread was shut down cleanly");
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		return super.onTouchEvent(event);
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		canvas.drawBitmap(background.getBackgroundImage(), 0, 0, null);
		
		
	
	
	}



}
