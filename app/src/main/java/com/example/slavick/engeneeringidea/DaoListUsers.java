package com.example.slavick.engeneeringidea;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class DaoListUsers extends RoomDatabase {
    public abstract UserDao getUserDao();
}
