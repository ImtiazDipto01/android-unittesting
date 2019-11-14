package com.example.androidunittesting.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

public class DateUtilTest {

    public static final String today = "11-2019" ;

    @Test
    public void testGetCurrentTimeStampAndReturnTimeStamp() {
        // Arrange

        //Act

        //Assert
        Assertions.assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                Assertions.assertEquals(today, DateUtil.getCurrentTimeStamp());
                System.out.println("TimeStamp Generate Correctly");
            }
        });

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
    void testMonthFromMonthNumberAndReturnSucess(int monthNumber, TestInfo testInfo, TestReporter testReporter) {
        // Arrange

        //Act

        //Assert
        Assertions.assertEquals(DateUtil.months[monthNumber], DateUtil.getMonthFromNumber(DateUtil.monthNumbers[monthNumber]));
        System.out.println(DateUtil.monthNumbers[monthNumber]+" : "+DateUtil.months[monthNumber]);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
    void testMonthFromMonthNumberAndReturnError(int monthNumber, TestInfo testInfo, TestReporter testReporter) {
        // Arrange

        //Act

        //Assert
        int randomNumber = new Random().nextInt(90) ;
        randomNumber = (randomNumber + 1)*15 ;
        Assertions.assertEquals(DateUtil.GET_MONTH_ERROR, DateUtil.getMonthFromNumber(String.valueOf(randomNumber)));
        System.out.println(DateUtil.monthNumbers[monthNumber]+" : "+DateUtil.GET_MONTH_ERROR);
    }

    @Test
    void name() {
        // Arrange

        //Act

        //Assert
    }
}
