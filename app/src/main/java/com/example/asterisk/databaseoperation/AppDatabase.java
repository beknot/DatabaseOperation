package com.example.asterisk.databaseoperation;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

    @Database(entities = Info.class,version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract DatabaseAccessObject dbObj();

    }
