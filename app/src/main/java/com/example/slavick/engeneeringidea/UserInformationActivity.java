package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserInformationActivity extends AppCompatActivity {
    TextView name;
    TextView age;
    TextView gender;
    TextView fruit;
    TextView status;
    TextView balance;
    TextView company;
    TextView phone;
    TextView email;
    TextView address;
    TextView registered;
    TextView tags;
    TextView friends;
    TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String tag = "";
        String friendie = "";
        String string;
        String seek = getIntent().getStringExtra("name");
        DaoListUsers db = Room.databaseBuilder(getApplicationContext(), DaoListUsers.class, "users").build();
        User user = db.getUserDao().getUserWithName(seek);
        for (String s : user.tags.tags){
            tag += s + ", ";
        }
        for (Friend friend : user.friends.friends){
            friendie += friend.name + ", ";
        }
        if (user.isActive){
            string = "active";
        } else {
            string = "not active";
        }
        setContentView(R.layout.activity_user_information);
        name = findViewById(R.id.name);
        name.setText(user.name);
        age = findViewById(R.id.age);
        age.setText(user.age);
        gender = findViewById(R.id.gender);
        gender.setText(user.gender);
        fruit = findViewById(R.id.fruit);
        fruit.setText(user.favoriteFruit);
        status = findViewById(R.id.status);
        status.setText(string);
        balance = findViewById(R.id.balance);
        balance.setText(user.balance);
        company = findViewById(R.id.company);
        company.setText(user.company);
        phone = findViewById(R.id.phone);
        phone.setText(user.phone);
        email = findViewById(R.id.email);
        email.setText(user.email);
        address = findViewById(R.id.address);
        address.setText(user.address);
        registered = findViewById(R.id.registered);
        registered.setText(user.registered);
        tags = findViewById(R.id.tags);
        tags.setText(tag);
        friends = findViewById(R.id.friends);
        friends.setText(friendie);
        about = findViewById(R.id.about);
        about.setText(user.about);
    }
}
