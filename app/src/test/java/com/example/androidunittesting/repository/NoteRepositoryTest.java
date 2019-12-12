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
}
