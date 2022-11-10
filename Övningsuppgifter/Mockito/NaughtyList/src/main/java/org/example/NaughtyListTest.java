package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class NaughtyListTest {

    private NaughtyList naughtyList = new NaughtyList();

    @BeforeEach
    public void setUp(){
        naughtyList = mock(NaughtyList.class);
    }

    @Test
    public void getNaughtyListChild(){
        Child kid = naughtyList.getChildList().get(2);
        System.out.println(kid.getName());
    }

}
