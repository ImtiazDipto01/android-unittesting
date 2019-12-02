package com.example.androidunittesting.di.module;

import android.app.Application;

import androidx.room.Room;

import com.example.androidunittesting.repository.NoteRepository;
import com.example.androidunittesting.room.MyDatabaseManager;
import com.example.androidunittesting.room.NoteDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    static MyDatabaseManager provideMyDatabase(Application application){

        return Room.databaseBuilder(application,
                MyDatabaseManager.class, MyDatabaseManager.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                /*.addCallback(roomCallback)*/
                .build();
    }

    @Singleton
    @Provides
    static NoteDao getNotesDao(MyDatabaseManager myDatabaseManager){
        return myDatabaseManager.getNoteDao();
    }

    @Singleton
    @Provides
    static NoteRepository provideNoteRepository(NoteDao noteDao){
        return new NoteRepository(noteDao);
    }



}
