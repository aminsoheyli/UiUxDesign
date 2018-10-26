package com.example.uiuxdesign;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FrameLayout menuFragment ;
    ImageButton menu,like ;
    Animation slideUp,slideDown,heart_beat;
    AnimatedVectorDrawable menuAnim;
    Drawable menuIconDrawable;
    RecyclerView rv,movieRv;
    RoundedImageView movieImage;
    TextView movieName;
    CategoryAdapter adapter;
    MovieAdapter movieAdapter;
    ArrayList<Category> categories;
    ArrayList<Movie> movies;
    LinearLayoutManager llm,llm2;
    LinearLayout imdb, serverDownButton;
    boolean liked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heart_beat = AnimationUtils.loadAnimation(this,R.anim.heart_beat);
        slideUp = AnimationUtils.loadAnimation(this,R.anim.menu_show);
        slideDown = AnimationUtils.loadAnimation(this,R.anim.rotate_left);
        menuFragment = (FrameLayout) findViewById(R.id.menu_fragment);
        rv = (RecyclerView) findViewById(R.id.category_rv);
        movieRv = (RecyclerView) findViewById(R.id.movie_rv);
        menu = (ImageButton) findViewById(R.id.menu_button);
        like = (ImageButton) findViewById(R.id.like_button);
        imdb = (LinearLayout) findViewById(R.id.imdb_ll);
        serverDownButton = (LinearLayout) findViewById(R.id.server_down_button);
        movieImage = (RoundedImageView) findViewById(R.id.movie_img);
        movieName = (TextView) findViewById(R.id.movie_name);


        serverDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServerDownActivity.class);
                startActivity(intent);
            }
        });
        movieImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowMovieActivity.class);
                Pair<View, String> p1 = Pair.create((View)movieName, "movieName");
                Pair<View, String> p2 = Pair.create((View)movieImage, "movieImage");
                Pair<View, String> p3 = Pair.create((View)like, "movieLike");
                Pair<View, String> p4 = Pair.create((View)imdb, "imdb");
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this , p1, p2,p3, p4);
                startActivity(intent,options.toBundle());

            }
        });


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


        setData();
        movieRv.setLayoutManager(new GridLayoutManager(this, 2));
        movieRv.setNestedScrollingEnabled(false);
        movieAdapter = new MovieAdapter(movies,MainActivity.this);
        movieRv.setAdapter(movieAdapter);
        llm = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(llm);
        adapter = new CategoryAdapter(categories,MainActivity.this);
        rv.setAdapter(adapter);

    }


    public void setData(){
        movies = new ArrayList<>();
        movies.add(new Movie("The Dark Knight",  R.drawable.dark_knight, "جنایی" , 9.1f));
        movies.add(new Movie("Dump and Dumper",  R.drawable.bg_comdey, "کمدی" , 8.3f));
        movies.add(new Movie("Im qare",  R.drawable.bg_scary, "ترسناک" , 7.1f));
        movies.add(new Movie("Pink Panther",  R.drawable.pink_panther, "انیمیشن" , 7.8f));
        categories = new ArrayList<>();
        categories.add(new Category("اکشن",R.drawable.bg_action));
        categories.add(new Category("کمدی",R.drawable.bg_comedy));
        categories.add(new Category("انیمیشن",R.drawable.bg_anim));
        categories.add(new Category("ترسناک",R.drawable.bg_scary));
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void show_menu(View view){
        if (menuFragment.getVisibility() == View.VISIBLE) {
            menuFragment.startAnimation(slideUp);
            menuFragment.setVisibility(View.INVISIBLE);
            menu.setImageResource(R.drawable.menu_second);
            menuIconDrawable = menu.getDrawable();
            try {
                menuAnim = (AnimatedVectorDrawable) menuIconDrawable;
                menuAnim.start();
            } catch (Exception err) {
                menu.setImageResource(R.drawable.menu_first);
            }
        }
        else if (menuFragment.getVisibility()==View.INVISIBLE) {
            menuFragment.startAnimation(slideDown);
            menu.setImageResource(R.drawable.menu_first);
            menuIconDrawable = menu.getDrawable();
            try {
                menuAnim = (AnimatedVectorDrawable) menuIconDrawable;
                menuAnim.start();
            } catch (Exception err) {
                menu.setImageResource(R.drawable.menu_second);
            }
            menuFragment.setVisibility(View.VISIBLE);
        }


    }

    public void NoOp(View view){

    }
}
