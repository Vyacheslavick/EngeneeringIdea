package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
@Entity
public class User {

    @SerializedName("id")
    @PrimaryKey
    String id;

    boolean isActive;
    String balance;
    String picture;
    int age;
    String eyeColour;
    String name;
    String gender;
    String company;
    String email;
    String phone;
    String address;
    String about;
    String registered;
    ArrayList<String> tags;
    ArrayList<Friends> friends;
    String favoriteFruit;

    public User(String id, boolean isActive, String balance, String picture, int age, String eyeColour, String name, String gender, String company, String email, String phone, String address, String about, String registered, ArrayList<String> tags, ArrayList<Friends> friends, String favoriteFruit) {
        this.id = id;
        this.isActive = isActive;
        this.balance = balance;
        this.picture = picture;
        this.age = age;
        this.eyeColour = eyeColour;
        this.name = name;
        this.gender = gender;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.about = about;
        this.registered = registered;
        this.tags = tags;
        this.friends = friends;
        this.favoriteFruit = favoriteFruit;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", isActive=" + isActive +
                ", balance='" + balance + '\'' +
                ", picture='" + picture + '\'' +
                ", age=" + age +
                ", eyeColour='" + eyeColour + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", about='" + about + '\'' +
                ", registered='" + registered + '\'' +
                ", tags=" + tags +
                ", friends=" + friends +
                ", favoriteFruit='" + favoriteFruit + '\'' +
                '}';
    }
}

