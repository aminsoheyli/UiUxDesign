package com.example.uiuxdesign;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * Created by mohd on 18/10/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    
    List<Movie> movies;
    MainActivity mainActivity;
    public static int id=0;
    MovieAdapter(List<Movie> apartemens, MainActivity mainActivity){
        this.movies = apartemens;
        this.mainActivity=mainActivity;
    }
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_movie, viewGroup, false);
        MovieViewHolder pvh = new MovieViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder MovieViewHolder, int i) {
        MovieViewHolder.img.setImageResource(movies.get(i).imageId);
        MovieViewHolder.name.setText(movies.get(i).name);
        MovieViewHolder.subject.setText(movies.get(i).subject);
        MovieViewHolder.rate.setText(movies.get(i).rate+"");
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView name, subject,rate;
        RoundedImageView img;

        MovieViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.movie_card_name);
            subject = (TextView) itemView.findViewById(R.id.movie_card_sub);
            rate = (TextView) itemView.findViewById(R.id.movie_card_rate);
            img = (RoundedImageView) itemView.findViewById(R.id.movie_card_img);

        }
    }

}

