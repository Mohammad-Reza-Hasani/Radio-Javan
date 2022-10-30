package com.unix.radiojavan.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.unix.radiojavan.models.Music;

import java.util.List;

@Dao
public interface IDAO {


    @Insert
    long insertMusic(Music music);

    @Update
    void update(Music music);

    @Query("SELECT * FROM tbl_music")
    List<Music> getMusicList();



    @Query("SELECT EXISTS (SELECT * FROM tbl_music WHERE id = :id)")
     boolean isRowExist(int id);

    @Query("DELETE FROM tbl_music WHERE id = :id")
    void deleteMusic(int id);

}
