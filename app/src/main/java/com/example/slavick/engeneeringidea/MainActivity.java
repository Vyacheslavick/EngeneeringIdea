package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements UsersRecyclerAdapter.OnRecyclerItemClick {
    UsersRecyclerAdapter adapter;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DaoListUsers db = Room.databaseBuilder(getApplicationContext(), DaoListUsers.class, "users").build();
        rx.Observable.just(db).subscribeOn(Schedulers.io()).map(new Func1<DaoListUsers, List<User>>() {
            @Override
            public List<User> call(DaoListUsers daoListUsers) {
                if (db.getUserDao().getAll().size() < 5) {
                    Retrofit.getUsers(new Callback<List<User>>() {
                        @Override
                        public void success(List<User> users, Response response) {
                            for (User user : users) {
                                db.getUserDao().insert(user);
                            }
                            users = db.getUserDao().getAll();
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


                } else {
                    users = db.getUserDao().getAll();
                }
                return users;
            }

        }).subscribe(new Action1<List<User>>() {
            @Override
            public void call(List<User> users) {
                final RecyclerView list = findViewById(R.id.list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                list.setLayoutManager(layoutManager);
                adapter = new UsersRecyclerAdapter(MainActivity.this, users, MainActivity.this);
                list.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onClick(int position) {

    }
}
