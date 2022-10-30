package com.unix.radiojavan.db;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.unix.radiojavan.models.Music;

@Database(entities = {Music.class,},version = 1,exportSchema = false)
//@androidx.room.Database(entities = {Music.class}, version = 1, exportSchema = false)
public abstract class RoomDb extends RoomDatabase {


    private static RoomDb instance = null;
    public abstract IDAO idao();

    public static RoomDb getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context, RoomDb.class,"radioJavan.db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

}
