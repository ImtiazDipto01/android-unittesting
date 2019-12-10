package com.example.androidunittesting.repository;


import androidx.annotation.NonNull;

import com.example.androidunittesting.models.Note;
import com.example.androidunittesting.room.NoteDao;
import com.example.androidunittesting.utils.Resource;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class NoteRepository {

    public static final String NOTE_TITLE_NULL = "Note title cannot be null";
    public static final String INVALID_NOTE_ID = "Invalid id. Can't delete note";
    public static final String DELETE_SUCCESS = "Delete success";
    public static final String DELETE_FAILURE = "Delete failure";
    public static final String UPDATE_SUCCESS = "Update success";
    public static final String UPDATE_FAILURE = "Update failure";
    public static final String INSERT_SUCCESS = "Insert success";
    public static final String INSERT_FAILURE = "Insert failure";

    private int timeDelay = 0;
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    @NonNull
    private NoteDao noteDao ;

    @Inject
    public NoteRepository(@NonNull NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public Flowable<Resource<Integer>> insertNote(Note note) throws Exception{
        checkNoteNull(note);
    }

    private void checkNoteNull(Note note) throws Exception{
        if(note == null){
            throw new Exception(NOTE_TITLE_NULL);
        }
    }


}
