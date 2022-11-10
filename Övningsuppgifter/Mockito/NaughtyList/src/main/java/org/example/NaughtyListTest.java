package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NaughtyListTest {

    private NaughtyList naughtyListMock;

    @BeforeEach
    public void setup(){
        naughtyListMock = mock(NaughtyList.class);
    }

    @Test
    public void getNaughtyChild(){
        ArrayList<Child> childList =
                new ArrayList<>(List.of(new Child("Charlie", 1001, true), new Child("Jeremy", 1002, false)));
        when(naughtyListMock.getChildList()).thenReturn(childList);

        String actual = null;
        String expected = "Charlie";

        //Todo: Find out if standard/optimal way to get data
        for (Child item: naughtyListMock.getChildList()) {
            if (item.getPersonalNumber() == 1001){
                actual = item.getName();
            }
        }

        assertEquals(expected, actual);
    }
}
