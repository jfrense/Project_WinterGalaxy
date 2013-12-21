package Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {
private Bitmap backgroundImage;	
	
public Background(Bitmap bitmap){
	this.backgroundImage = bitmap;
	}

	
	


	public Bitmap getBackgroundImage() {
		return backgroundImage;
	}


	public void setBackgroundImage(Bitmap backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
	

}
