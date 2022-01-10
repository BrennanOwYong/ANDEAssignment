package com.example.andeassignment;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;


public class SplashScreen extends AppCompatActivity{

    private ImageView container;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);
        container = findViewById(R.id.AppLogo);
        container.setBackgroundResource(R.drawable.splash_animation);
        MediaPlayer soundeffect= MediaPlayer.create(SplashScreen.this,R.raw.soundeffect);
        soundeffect.start();

        animationDrawable = (AnimationDrawable) container.getBackground();

        Thread splashThread = new Thread() {

            public void run() {
                try {
                    sleep(3000);
                }  catch(InterruptedException e) {
                    e.printStackTrace();
                } finally
                {
                    Intent intent = new Intent(SplashScreen.this, Restaurant.class);
                    startActivity(intent);
                    SplashScreen.this.finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

            }
        };
        splashThread.start();
    }

    @Override
    protected void onResume() {
        super.onResume();

        animationDrawable.start();
    }



}
