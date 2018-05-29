package com.example.asterisk.databaseoperation;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fm;
    public static AppDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase = Room.databaseBuilder(MainActivity.this,AppDatabase.class,"infodb").allowMainThreadQueries().build();
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.frame,new DashFragment()).commit();
    }
}
