package com.android.alfazpractical.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.alfazpractical.adapter.GridAdapter;
import com.android.alfazpractical.api.ApiClient;
import com.android.alfazpractical.api.ApiInterface;
import com.android.alfazpractical.databinding.ActivityGridBinding;
import com.android.alfazpractical.model.Image;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GridActivity extends AppCompatActivity {

    ActivityGridBinding binding;
    private GridAdapter adapter;
    private ArrayList<Image> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGridBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getImages();
    }

    private void setAdapter() {
        adapter = new GridAdapter(GridActivity.this, list);
        binding.rvImages.setAdapter(adapter);
        binding.rvImages.setHasFixedSize(true);
    }


    private void getImages() {

        Call<JsonObject> call = ApiClient.getClient().create(ApiInterface.class).getImages();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    Type type = new TypeToken<ArrayList<Image>>() {
                    }.getType();
                    ArrayList<Image> images = gson.fromJson(response.body().get("images").getAsJsonArray(), type);
                    list.addAll(images);
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });

    }
}