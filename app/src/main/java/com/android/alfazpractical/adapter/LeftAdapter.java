package com.android.alfazpractical.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.alfazpractical.R;
import com.android.alfazpractical.databinding.LayoutLeftBinding;

import java.util.ArrayList;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> list;

    public LeftAdapter(Context context,ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_left, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (list != null){
            holder.binding.tvText.setText(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        LayoutLeftBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = LayoutLeftBinding.bind(itemView);
        }
    }

}
