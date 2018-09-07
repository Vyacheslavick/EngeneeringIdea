package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.Entity;

@Entity
public class Friend {
    int id;
    String name;

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Friend(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
