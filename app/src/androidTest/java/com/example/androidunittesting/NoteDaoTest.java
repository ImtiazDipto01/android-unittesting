package com.example.androidunittesting;

import com.example.androidunittesting.models.Note;
import com.example.androidunittesting.util.LiveDataTestUtil;
import com.example.androidunittesting.util.TestUtil;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class NoteDaoTest extends MyDatabaseManagerTest {

    // Insert, Read, Delete
    @Test
    public void testInsertReadDelete() throws Exception{
        Note note = new Note(TestUtil.TEST_NOTE_1);

        //Insert
        getNoteDao().insertNote(note).blockingGet(); //wait until inserted because we are using rxJava

        //read
        LiveDataTestUtil<List<Note>> liveDataTestUtilList = new LiveDataTestUtil<>();
        List<Note> insertedList = liveDataTestUtilList.getValue(getNoteDao().getNoteList());

        Assert.assertNotNull(insertedList);

        Assert.assertEquals(note.getContent(), insertedList.get(0).getContent());
        Assert.assertEquals(note.getTimestamp(), insertedList.get(0).getTimestamp());
        Assert.assertEquals(note.getTitle(), insertedList.get(0).getTitle());

        note.setId(insertedList.get(0).getId());
        Assert.assertEquals(note, insertedList.get(0));

        //delete
        insertedList = liveDataTestUtilList.getValue(getNoteDao().getNoteList());
        Assert.assertEquals(0, insertedList.size());

    }

}
