package com.example.androidunittesting;

import android.database.sqlite.SQLiteConstraintException;

import com.example.androidunittesting.models.Note;
import com.example.androidunittesting.util.LiveDataTestUtil;
import com.example.androidunittesting.util.TestUtil;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Not;

import java.util.List;

public class NoteDaoTest extends MyDatabaseManagerTest {

    public static final String TEST_TITLE = "This is a test Title";
    public static final String TEST_CONTENT = "This is a test Content";
    public static final String TEST_TIMESTAMP = "01-2019";

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

    //Insert read update read delete
    @Test
    public void testInsertReadUpdateReadDelete() throws Exception{
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

        //update
        note.setTitle(TEST_TITLE);
        note.setTimestamp(TEST_TIMESTAMP);
        note.setContent(TEST_CONTENT);
        getNoteDao().updateNote(note).blockingGet();

        //read
        insertedList = liveDataTestUtilList.getValue(getNoteDao().getNoteList());
        Assert.assertEquals(TEST_TITLE, insertedList.get(0).getTitle());
        Assert.assertEquals(TEST_TIMESTAMP, insertedList.get(0).getTimestamp());
        Assert.assertEquals(TEST_CONTENT, insertedList.get(0).getContent());

        note.setId(insertedList.get(0).getId());
        Assert.assertEquals(note, insertedList.get(0));


        //delete
        insertedList = liveDataTestUtilList.getValue(getNoteDao().getNoteList());
        Assert.assertEquals(0, insertedList.size());

    }

    @Test(expected = SQLiteConstraintException.class)
    public void insertNoteTitleNullThrowSQLiteConstraintExection() throws Exception{
        Note note = new Note(TestUtil.TEST_NOTE_1) ;
        note.setTitle(null);

        getNoteDao().insertNote(note).blockingGet();
    }

    @Test(expected = SQLiteConstraintException.class)
    public void updateNoteTitleNullThrowSQLiteConstraintExection() throws Exception{
        Note note = new Note(TestUtil.TEST_NOTE_1) ;

        //insert
        getNoteDao().insertNote(note).blockingGet();

        //update
        LiveDataTestUtil<List<Note>> liveDataTestUtil = new LiveDataTestUtil<>();
        List<Note> noteList = liveDataTestUtil.getValue(getNoteDao().getNoteList()) ;
    }


}
