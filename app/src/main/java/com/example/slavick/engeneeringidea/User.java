package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
@Entity()
@TypeConverters({UserConverter.class})
public class User {

    @PrimaryKey
    int age;
    @SerializedName("id")
    String id;
    boolean isActive;
    String balance;
    String picture;
    String eyeColour;
    String name;
    String gender;
    String company;
    String email;
    String phone;
    String address;
    String about;
    String registered;
    Tags tags;
    Friends friends;
    String favoriteFruit;


    public User(int age, String id, boolean isActive, String balance, String picture, String eyeColour, String name, String gender, String company, String email, String phone, String address, String about, String registered, Tags tags,Friends friends, String favoriteFruit) {
        this.age = age;
        this.id = id;
        this.isActive = isActive;
        this.balance = balance;
        this.picture = picture;
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
//                ", friends=" + friends +
                ", favoriteFruit='" + favoriteFruit + '\'' +
                '}';
    }
}

