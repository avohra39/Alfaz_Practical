package com.android.alfazpractical.adapter;

import android.content.ContentUris;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.alfazpractical.R;
import com.android.alfazpractical.databinding.LayoutGridBinding;
import com.android.alfazpractical.model.Image;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Image> list;

    public GridAdapter(Context context,ArrayList<Image> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        loadImage(context, holder.binding.ivImage, list.get(position).getUrl());
    }

    public static void loadImage(Context context, ImageView imageView, String imageUrl) {
        Glide.with(context).
                load(imageUrl)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.placeholder_image)
                        .fitCenter()
                        .centerCrop()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        LayoutGridBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = LayoutGridBinding.bind(itemView);
        }
    }

}
