package com.youngtard.cloupad.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ClouDao {

    @Insert
    void insertClou(Clou clou);

    @Query("SELECT * FROM clou")
    List<Clou> loadAllClous();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateClou(Clou clou);

    @Delete
    void deleteClou(Clou clou);

}
