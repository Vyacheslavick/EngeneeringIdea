package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements UsersRecyclerAdapter.OnRecyclerItemClick {
    UsersRecyclerAdapter adapter;
    List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userList.add(0, new User(0,"",false,"","","","Sorry, give for us few seconds, please","","","","","","","","","",""));
        final RecyclerView list = findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        adapter = new UsersRecyclerAdapter(this, userList, this );
        list.setAdapter(adapter);
        final DaoListUsers db = Room.databaseBuilder(getApplicationContext(), DaoListUsers.class, "users").build();
        Observable.just(db).subscribeOn(Schedulers.io()).map(new Func1<DaoListUsers, List<User>>() {
            @Override
            public List<User> call(DaoListUsers daoListUsers) {
                if (db.getUserDao().getAll().size() < 5 || db.getUserDao().getAll() == null){
                    final List<String> str = new ArrayList<>();
                    final List<String> frd = new ArrayList<>();

                    Retrofit.getWrongUsers(new Callback<List<WrongUser>>() {
                        @Override
                        public void success(List<WrongUser> wrongUsers, Response response) {
                            int counter = 0;
                            for (WrongUser wrongUser : wrongUsers){
                                String tag = "";
                                String fr = "";
                                for (int i = 0; i < wrongUser.tags.size(); i++) {
                                    tag += wrongUser.tags.get(i);
                                }
                                for (int i = 0; i < wrongUser.friends.size(); i++) {
                                    fr += wrongUser.friends.get(i).name;
                                }
                                frd.add(counter, fr);
                                str.add(counter,  tag);
                                counter += 1;
                            }
                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });
                    Retrofit.getUsers(new Callback<List<User>>() {
                        @Override
                        public void success(List<User> users, Response response) {
                            int i = 0;
                            for (User user : users) {
                                db.getUserDao().insert(new User(user.age, user.id, user.isActive, user.balance, user.picture, user.eyeColour, user.name, user.gender, user.company, user.email, user.phone, user.address, user.about, user.registered, str.get(i), frd.get(i), user.favoriteFruit));
                                i += 1;
                            }
                            userList = db.getUserDao().getAll();
                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });


                } else {
                    userList = db.getUserDao().getAll();
                }
                return userList;
            }

        }).subscribe(new Action1<List<User>>() {
            @Override
            public void call(List<User> users) {
                if (userList != null){
                    recyclerViewCreator();
                    Log.d("List", "was created");
                }
            }
        });
    }
    public void recyclerViewCreator(){

        adapter.notifyDataSetChanged();
        }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(MainActivity.this, UserInformationActivity.class);
        intent.putExtra("name", userList.get(position).name);
        startActivity(intent);
    }
}
