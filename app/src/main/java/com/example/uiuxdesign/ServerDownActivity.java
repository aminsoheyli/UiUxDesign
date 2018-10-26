package com.example.uiuxdesign;

import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Random;

public class ServerDownActivity extends AppCompatActivity {
    CountDownTimer timer,cheshmak;
    private ImageView bg,image;
    int i=0;
    TransitionDrawable transitionBg,transitionImage;
    MediaPlayer lightFlicker;
    int x;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_down);
        bg = (ImageView) findViewById(R.id.server_down_bg);
        image = (ImageView) findViewById(R.id.server_down_image);
        transitionImage = (TransitionDrawable) image.getDrawable();
        lightFlicker = MediaPlayer.create(this, R.raw.light_flicker);
        random = new Random();
        lightFlicker.start();
        transitionBg = (TransitionDrawable) bg.getBackground();
        transitionBg.startTransition(500);
        transitionImage.startTransition(500);
        cheshmak = new CountDownTimer(1000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                transitionBg.reverseTransition(500);
                transitionImage.reverseTransition(500);
                lightFlicker.start();
            }
        }.start();
        timer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                x = random.nextInt(4);
                if (x == 0) {
                    lightFlicker.start();
                    transitionBg.startTransition(500);
                    transitionImage.startTransition(500);
                    cheshmak = new CountDownTimer(1000,500) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override
                        public void onFinish() {
                            transitionBg.reverseTransition(500);
                            transitionImage.reverseTransition(500);
                            lightFlicker.start();
                        }
                    }.start();

                }

            }

            @Override
            public void onFinish() {
                timer.start();
            }
        }.start();
    }

    @Override
    protected void onPause() {
        timer.cancel();
        lightFlicker.stop();
        super.onPause();
    }
}
