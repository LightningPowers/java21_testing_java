package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NaughtyListTest {

    // Tests are meant to mock classes and methods, NOT variables/lists
    // Variables and lists are declared in each test method separately
    private NaughtyList naughtyListMock;

    @BeforeEach
    public void setup(){
        naughtyListMock = spy(NaughtyList.class);
        // mock method is used for creating a dummy object
        // spy method is used to use the real object
    }

    // If I want to test for example child isNaughty value, I need a different method
    // Aka, use different test methods to test different test cases

    @Test
    public void getNaughtyChild(){
        ArrayList<Child> childList =
                new ArrayList<>(List.of(new Child("Charlie", 1001, true),
                        new Child("Jeremy", 1002, false)));
        when(naughtyListMock.getChildList()).thenReturn(childList);

        String actual = null;
        String expected = "Charlie";

        // This works
        for (Child item: naughtyListMock.getChildList()) {
            if (item.getPersonalNumber() == 1001){
                actual = item.getName();
            }
        }

        assertEquals(expected, actual);
    }
}
