package com.example.androidunittesting.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoteTest {

    //two notes are equal
    @Test
    void isTwoNotesAreEqualIdenticalPropertyReturnTrue() throws Exception {
        // Arrange
        Note note1 = new Note("Title #1", "Content #1", "11-2019");
        note1.setId(1);
        Note note2 = new Note("Title #1", "Content #1", "11-2019");
        note2.setId(1);

        //Act
        /*nothing for act*/

        //Assert
        Assertions.assertEquals(note1, note2);
        System.out.println("Note Objects are Equal");
    }

    //two notes with different ids
    @Test
    void isTwoNotesMatchWithDifferentIdsReturnFalse() {
        // Arrange
        Note note1 = new Note("Title #1", "Content #1", "11-2019");
        note1.setId(1);
        Note note2 = new Note("Title #1", "Content #1", "11-2019");
        note2.setId(2);

        //Act
        /*nothing for act*/

        //Assert
        Assertions.assertNotEquals(note1, note2);
        System.out.println("Note Objects are not Equal");
    }

    @Test
    void isNotesAreEqualWithDifferentTimeStampReturnTrue() {
        // Arrange
        Note note1 = new Note("Title #1", "Content #1", "11-2019");
        note1.setId(1);
        Note note2 = new Note("Title #1", "Content #1", "12-2019");
        note2.setId(1);

        //Act
        /*nothing for act*/

        //Assert
        Assertions.assertEquals(note1, note2);
        System.out.println("Note Objects are Equal");
    }

    @Test
    void isNotesAreEqualWithDifferentTitleReturnFalse() {
        // Arrange
        Note note1 = new Note("Title #1", "Content #1", "11-2019");
        note1.setId(1);
        Note note2 = new Note("Title #2", "Content #1", "11-2019");
        note2.setId(1);

        //Act
        /*nothing for act*/

        //Assert
        Assertions.assertNotEquals(note1, note2);
        System.out.println("Note Objects are note Equal.. they have different title");
    }

    @Test
    void isNotesAreEqualWithDifferentContentReturnTrue() {
        // Arrange
        Note note1 = new Note("Title #1", "Content #1", "11-2019");
        note1.setId(1);
        Note note2 = new Note("Title #1", "Content #2", "11-2019");
        note2.setId(1);

        //Act
        /*nothing for act*/

        //Assert
        Assertions.assertNotEquals(note1, note2);
        System.out.println("Note Objects are not Equal.. they have different Content");
    }

    @Test
    void name() {
        // Arrange

        //Act

        //Assert
    }
}
