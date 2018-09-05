package com.youngtard.cloupad.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Clou.class}, version = 1, exportSchema = false)
public abstract class ClouDatabase extends RoomDatabase {

    private static final String DATABAASE_NAME = "clouDB";
    private static ClouDatabase clouDBinstance;
    private static final Object LOCK = new Object();

    public static ClouDatabase getInstance(Context context) {
        if(clouDBinstance == null) {
            synchronized (LOCK) {
                clouDBinstance = Room.databaseBuilder(context.getApplicationContext(), ClouDatabase.class, ClouDatabase.DATABAASE_NAME).allowMainThreadQueries().build();
            }
        }

        return clouDBinstance;
    }

    public abstract ClouDao clouDao();
}
