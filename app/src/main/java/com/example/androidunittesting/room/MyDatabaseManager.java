package com.example.androidunittesting.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.androidunittesting.models.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class MyDatabaseManager extends RoomDatabase {

    public static final String DATABASE_NAME = "notedb" ;
    private static MyDatabaseManager instance ;

    public abstract NoteDao getNoteDao();


}
