package com.android.alfazpractical.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.alfazpractical.adapter.LeftAdapter;
import com.android.alfazpractical.databinding.ActivityTaskSecondBinding;

import java.util.ArrayList;

public class TaskSecond extends AppCompatActivity {

    ActivityTaskSecondBinding binding;
    private LeftAdapter adapter;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTaskSecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        add();
        setAdapter(arrayList, binding.rvA);

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(list.size(), binding.etEnter.getText().toString().trim());
                setAdapter(list, binding.rvB);
            }
        });

        binding.llNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskSecond.this, GridActivity.class);
                startActivity(intent);
            }
        });
    }

    private void add() {
        addItems("A", 0);
        addItems("B", 1);
        addItems("C", 2);
        addItems("D", 3);
        addItems("E", 4);
    }

    private void addItems(String items, int position) {
        arrayList.add(position, items);
    }

    private void setAdapter(ArrayList<String> al, RecyclerView recyclerView) {
        adapter = new LeftAdapter(TaskSecond.this, al);
        recyclerView.setAdapter(adapter);
    }

}