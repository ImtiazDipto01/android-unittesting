package com.example.androidunittesting.repository;

import com.example.androidunittesting.room.NoteDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class NoteRepositoryTest {

    private NoteRepository noteRepository ;

    //@Mock
    private NoteDao noteDao ;

    @BeforeEach
    public void initEach(){
        //MockitoAnnotations.initMocks(this);
        noteDao = Mockito.mock(NoteDao.class);
        noteRepository = new NoteRepository(noteDao);

    }

    @Test
    void checkObjectsNotNull() throws Exception {
        Assertions.assertNotNull(noteDao);
        Assertions.assertNotNull(noteRepository);
    }

    /*
    * Insert Note
    * Verify Correct Method is called
    * Confirm Observer is triggered
    * Confirm new row inserted
    */
    @Test
    void insertNote_ReturnNote() {

    }

    /*
    * Insert Note
    * Failure (return -1)
    */
    @Test
    void insertNote_ReturnFailure() throws Exception{

    }


    /*
    * Insert Note
    * null title
    * confirm throw exception
    * */
    @Test
    void insertNote_NullTitle_ThrowException() throws Exception{

    }

}
