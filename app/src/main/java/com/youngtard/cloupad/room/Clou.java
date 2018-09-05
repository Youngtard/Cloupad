package com.youngtard.cloupad.room;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "clou")
public class Clou {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "clou_title")
    private String clouTitle;

    @ColumnInfo(name = "clou_content")
    private String clouContent;


    @Ignore
    public Clou(String clouTitle, String clouContent) {
        this.clouTitle = clouTitle;
        this.clouContent = clouContent;

    }

    public Clou(int id, String clouTitle, String clouContent) {
        this.clouTitle = clouTitle;
        this.clouContent = clouContent;

    }

    public int getId() {
        return id;
    }

    public String getClouTitle() {
        return clouTitle;
    }

    public String getClouContent() {
        return clouContent;
    }

    //    public Clou(String clouTitle, String clouContent) {
//        this.clouTitle = clouTitle;
//        this.clouContent = clouContent;
//    }

//    public String getClouTitle() {
//        return clouTitle;
//    }
//
//    public String getClouContent() {
//        return clouContent;
//    }
}
