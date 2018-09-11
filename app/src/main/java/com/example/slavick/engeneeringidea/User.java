package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity
public class User implements Serializable {

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
    String tags;
    String friends;
    String favoriteFruit;


    public User(int age, String id, boolean isActive, String balance, String picture, String eyeColour, String name, String gender, String company, String email, String phone, String address, String about, String registered, String tags, String friends, String favoriteFruit) {
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
                "age=" + age +
                ", id='" + id + '\'' +
                ", isActive=" + isActive +
                ", balance='" + balance + '\'' +
                ", picture='" + picture + '\'' +
                ", eyeColour='" + eyeColour + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", about='" + about + '\'' +
                ", registered='" + registered + '\'' +
                ", tags='" + tags + '\'' +
                ", friends='" + friends + '\'' +
                ", favoriteFruit='" + favoriteFruit + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

    public int getAge() {

        return age;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getBalance() {
        return balance;
    }

    public String getPicture() {
        return picture;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAbout() {
        return about;
    }

    public String getRegistered() {
        return registered;
    }

    public String getTags() {
        return tags;
    }

    public String getFriends() {
        return friends;
    }

    public String getFavoriteFruit() {
        return favoriteFruit;
    }
}

