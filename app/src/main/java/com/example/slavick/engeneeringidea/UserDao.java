package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User... users);

    @Query("SELECT * FROM user")
    List<User> getAll();

}
