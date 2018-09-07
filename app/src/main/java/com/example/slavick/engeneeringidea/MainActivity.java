package com.example.slavick.engeneeringidea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements UsersRecyclerAdapter.OnRecyclerItemClick {
    UsersRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit.getUsers(new Callback<List<User>>() {
            @Override
            public void success(List<User> users, Response response) {
                final RecyclerView list = findViewById(R.id.list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                list.setLayoutManager(layoutManager);
                adapter = new UsersRecyclerAdapter(MainActivity.this, users, MainActivity.this);
                list.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    @Override
    public void onClick(int position) {

    }
}
