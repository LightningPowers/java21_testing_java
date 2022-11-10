package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class NaughtyListTest {

    private NaughtyList naughtyList;

    @BeforeEach
    public void setUp(){
        naughtyList = mock(NaughtyList.class);
        Child child1 = new Child("Charlie", 1001, true);
        naughtyList.addChild(child1);
    }

    @Test
    public void getNaughtyChild(){
        String expected = "Charlie";
        String actual = naughtyList.getChild(1001).getName();
        assertEquals(expected, actual);
    }

}
