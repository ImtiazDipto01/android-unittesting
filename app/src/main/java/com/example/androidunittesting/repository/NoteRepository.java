package com.example.androidunittesting.repository;


import androidx.annotation.NonNull;

import com.example.androidunittesting.room.NoteDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NoteRepository {

    @NonNull
    private NoteDao noteDao ;

    @Inject
    public NoteRepository(@NonNull NoteDao noteDao) {
        this.noteDao = noteDao;
    }
}
