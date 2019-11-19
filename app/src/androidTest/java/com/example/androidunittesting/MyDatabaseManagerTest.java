package com.example.androidunittesting;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.androidunittesting.room.MyDatabaseManager;
import com.example.androidunittesting.room.NoteDao;

import org.junit.After;
import org.junit.Before;

public abstract class MyDatabaseManagerTest {

    private MyDatabaseManager myDatabaseManager ;

    public NoteDao getNoteDao(){
        return myDatabaseManager.getNoteDao() ;
    }

    @Before
    public void init(){
        myDatabaseManager = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                MyDatabaseManager.class).build() ;
    }

    @After
    public void finish(){
        myDatabaseManager.close();
    }
}