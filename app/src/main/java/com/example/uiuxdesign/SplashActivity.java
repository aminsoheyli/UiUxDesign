package com.example.uiuxdesign;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class SplashActivity extends AppCompatActivity {
    View black, orange;
    Animation rotate, dance, up;
    Button loginButton;
    ProgressBar progressBar;
    CountDownTimer wait, timer, t;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        loginButton = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.progressbar);
        orange = findViewById(R.id.orange_bg);
        black = findViewById(R.id.black_bg);
        //dance = AnimationUtils.loadAnimation(this,R.anim.dance);
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        loginButton.setVisibility(View.INVISIBLE);
        /*CountDownTimer timer1 = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                loginButton.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                loginButton.startAnimation(up);
            }
        };*/
        spinner();
    }

    public void spinner() {
        //Animation beats = AnimationUtils.loadAnimation(this, R.anim.heart_beat);
        wait = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                timer = new CountDownTimer(900, 1) {
                    @Override
                    public void onTick(long l) {
                        black.getLayoutParams().width = 2000 - i;
                        black.requestLayout();
                        i += 150;
                    }

                    @Override
                    public void onFinish() {
                        i = 0;
                        t = new CountDownTimer(600, 1) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                orange.getLayoutParams().height = 3000 - i;
                                orange.requestLayout();
                                i += 300;
                            }

                            @Override
                            public void onFinish() {
                                CountDownTimer timer = new CountDownTimer(3000, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        progressBar.setVisibility(View.INVISIBLE);
                                        loginButton.startAnimation(up);
                                        loginButton.setVisibility(View.VISIBLE);

                                    }
                                }.start();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();

    }
}

