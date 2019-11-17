package com.example.androidunittesting.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidunittesting.models.Note;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface NoteDao {

    @Insert
    Single<Long> insertNote(Note note) throws Exception;

    @Query("Select * from notes")
    LiveData<List<Note>> getNoteList();

    @Delete
    Single<Integer> deleteNote(Note note);

    @Update
    Single<Integer> updateNote(Note note);


}
