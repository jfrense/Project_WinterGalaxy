package com.example.androidgalaxy;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();


	// called when the activity is first created, think of this as the main
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// turning title off in view
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// making the game fullScreen
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// setting the mainGamePanel as the view
		setContentView(new MainGamePanel(this));
	}

	@Override
	protected void onDestroy(){
		Log.d(TAG, "Destroying...");
		super.onDestroy();

	}


	@Override
	protected void onStop(){
		Log.d(TAG, "Stopping...");
		super.onStop();
	}

}
