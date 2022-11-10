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

        //Todo: METHOD 1: Find out if data is supposed to be collected in THIS method OR (METHOD 2) mocked class' method
        for (Child item: naughtyListMock.getChildList()) {
            if (item.getPersonalNumber() == 1001){
                actual = item.getName();
            }
        }

        assertEquals("Charlie", actual);
    }

    /*@Test
    public void getNaughtyChild(){
        ArrayList<Child> childList =
                new ArrayList<>(List.of(new Child("Charlie", 1001, true), new Child("Jeremy", 1002, false)));
        when(naughtyListMock.getChildList()).thenReturn(childList);
        System.out.println(childList.get(0).getName());

        System.out.println(naughtyListMock.getChild(1001));

        String expected = "Charlie";
        String actual = naughtyListMock.getChild(1001).getName();
        assertEquals(expected, actual);
    }*/
}
