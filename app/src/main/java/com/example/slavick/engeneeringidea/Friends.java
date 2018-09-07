package com.example.slavick.engeneeringidea;

import java.util.List;

public class Friends {
    List<Friend> friends;


    public Friends(List<Friend> friends) {
        this.friends = friends;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
}
