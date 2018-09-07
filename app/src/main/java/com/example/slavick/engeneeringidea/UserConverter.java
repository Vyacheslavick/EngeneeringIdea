package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserConverter {

    @TypeConverter
    public String fromTags(Tags tags) {
        String allTags = "";
        for (String tag : tags.getTags()) {
            allTags += tag + ",";
        }
        return allTags;
    }

    @TypeConverter
    public Tags toTags(String tag) {
        Tags tags = new Tags(Arrays.asList(tag.split(",")));
        return tags;
    }

    @TypeConverter
    public String fromFriends(Friends friends) {
        Gson gson = new Gson();
        return gson.toJson(friends);
    }

    @TypeConverter
    public Friends toFriends(String friendString) {
        Gson gson = new Gson();
        List<Friend> friendsClass= new ArrayList<>();
        Friends friends = new Friends(gson.fromJson(friendString, friendsClass.getClass()));
        return friends;
    }
}
