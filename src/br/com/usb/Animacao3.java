package br.com.usb;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

public class Animacao3 {
	
	public void piscaView(View view) {

		Animation animation = new AlphaAnimation(1, 0);
				  animation.setDuration(100);
				  animation.setInterpolator(new LinearInterpolator());
				  animation.setRepeatCount(20);
				  animation.setRepeatMode(Animation.REVERSE);

		view.startAnimation(animation);
	}


}
