package com.example.uiuxdesign;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    private final static int EMAIL_STATE = 1;
    private final static int PASSWORD_STATE = 2;
    Animation show, showLeft, hide, hideLeft;
    EditText email, pass;
    ImageButton next, previous;
    AnimatedVectorDrawable nextAnim;
    Drawable nextIcon;
    TextView title;
    int state = EMAIL_STATE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        show = AnimationUtils.loadAnimation(this, R.anim.edit_text_show_right);
        showLeft = AnimationUtils.loadAnimation(this, R.anim.edit_text_show_left);
        hide = AnimationUtils.loadAnimation(this, R.anim.edit_text_hide_right);
        hideLeft = AnimationUtils.loadAnimation(this, R.anim.edit_text_hide_left);
        title = findViewById(R.id.field_title);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);

        email = findViewById(R.id.email_field);
        pass = findViewById(R.id.pass_field);


        next.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (state == EMAIL_STATE) {
                    state = PASSWORD_STATE;
                    email.setVisibility(View.INVISIBLE);
                    email.startAnimation(hideLeft);
                    pass.setVisibility(View.VISIBLE);
                    pass.startAnimation(showLeft);
                    title.setText("رمز عبور");
                    previous.setVisibility(View.VISIBLE);
                    next.setImageResource(R.drawable.next);
                    nextIcon = next.getDrawable();
                    try {
                        nextAnim = (AnimatedVectorDrawable) nextIcon;
                        nextAnim.start();
                    } catch (Exception ett) {
                        next.setImageResource(R.drawable.back);
                    }
                } else if (state == PASSWORD_STATE) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                {
                    state = EMAIL_STATE;
                    pass.startAnimation(hide);
                    email.startAnimation(show);
                    previous.setVisibility(View.INVISIBLE);
                    pass.setVisibility(View.INVISIBLE);
                    email.setVisibility(View.VISIBLE);
                    title.setText("ایمیل");
                    next.setImageResource(R.drawable.back);
                    nextIcon = next.getDrawable();
                    try {
                        nextAnim = (AnimatedVectorDrawable) nextIcon;
                        nextAnim.start();
                    } catch (Exception ett) {
                        next.setImageResource(R.drawable.back);
                    }
                }
            }
        });


    }
}
