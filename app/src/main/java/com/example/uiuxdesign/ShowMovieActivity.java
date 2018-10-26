package com.example.uiuxdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.makeramen.roundedimageview.RoundedImageView;

public class ShowMovieActivity extends AppCompatActivity {

    Animation heart_beat;
    ImageButton like;
    boolean liked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movie);
        like = (ImageButton) findViewById(R.id.show_like_button);
        heart_beat = AnimationUtils.loadAnimation(this,R.anim.heart_beat);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                like.startAnimation(heart_beat);
                if (liked){
                    liked = false;
                    like.setImageResource(R.drawable.ic_like_stroke);
                }
                else {
                    liked = true;
                    like.setImageResource(R.drawable.ic_like_fill);
                }
            }
        });
    }
}
