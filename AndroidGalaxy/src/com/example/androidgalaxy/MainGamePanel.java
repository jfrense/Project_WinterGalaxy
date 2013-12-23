package com.example.androidgalaxy;

import Model.Background;
import Model.Player;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback {


	private static final String TAG = MainGamePanel.class.getSimpleName();

	private MainThread thread;
	private Background background;
	private Player mainPlayer;
	private boolean continueScrollingForward;
	private boolean continueScrollingBackward;


	public MainGamePanel(Context context) {
		super(context);

		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);

		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		int screenWidth = metrics.widthPixels;
		int screenHeight = metrics.heightPixels;
		// create and load background
		background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.background),0,0, BitmapFactory.decodeResource(getResources(), R.drawable.background).getWidth(), 
				BitmapFactory.decodeResource(getResources(), R.drawable.background).getHeight());

		//create and load main character
		mainPlayer = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.playerwalkright), screenWidth - (screenWidth - 50) , screenHeight - (screenHeight - 280), 128, 100, 5, 4);

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




		if(event.getAction() == MotionEvent.ACTION_UP){

			continueScrollingBackward = false;
			continueScrollingForward = false;

		}


		else if (event.getAction() == MotionEvent.ACTION_DOWN && event.getX() > mainPlayer.getX()) {
			continueScrollingBackward = true;
		}
		else if (event.getAction() == MotionEvent.ACTION_DOWN && event.getX() < mainPlayer.getX()){
			continueScrollingForward = true;

		}




		return true;

	}

	// render images onto screen
	public void render(Canvas canvas){

		background.draw(canvas);
		mainPlayer.draw(canvas);


	}

	public void update(){
		if(continueScrollingBackward){
			mainPlayer.update(System.currentTimeMillis());
			background.ScrollBackward();
		}
		else if(continueScrollingForward){
			mainPlayer.update(System.currentTimeMillis());
			background.ScrollForward();
		}

	}



}