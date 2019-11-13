package com.example.androidunittesting.models;

import android.util.Log;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoteTest {

    //two notes are equal
    @Test
    void isTwoNotesAreEqualIdenticalPropertyReturnTrue() throws Exception {
        // Arrange
        Notes note1 = new Notes("Title #1", "Content #1", "11-2019");
        note1.setId(1);
        Notes note2 = new Notes("Title #1", "Content #1", "11-2019");
        note2.setId(1);

        //Act
        /*nothing for act*/

        //Assert
        Assertions.assertEquals(note1, note2);
        System.out.println("Objects are Equal");
    }

    //two notes with different ids
    @Test
    void isTwoNotesMatchWithDifferentIds() {
        // Arrange

        //Act

        //Assert
    }
}
