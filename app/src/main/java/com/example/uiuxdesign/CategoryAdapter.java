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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    
    List<Category> categories;
    MainActivity mainActivity;
    public static int id=0;
    CategoryAdapter(List<Category> apartemens, MainActivity mainActivity){
        this.categories = apartemens;
        this.mainActivity=mainActivity;
    }
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_category, viewGroup, false);
        CategoryViewHolder pvh = new CategoryViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final CategoryViewHolder CategoryViewHolder, int i) {
        CategoryViewHolder.name.setText(categories.get(i).name);
        CategoryViewHolder.img.setImageResource(categories.get(i).img_id);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RoundedImageView img;

        CategoryViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.category_name);
            img = (RoundedImageView)itemView.findViewById(R.id.category_img);
        }
    }

}

