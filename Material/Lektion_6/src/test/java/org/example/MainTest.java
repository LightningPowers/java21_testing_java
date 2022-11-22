package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testInputNameCorrect(){
        String name = "Omar\nKalthoum";
        ByteArrayInputStream in = new ByteArrayInputStream(name.getBytes());
        System.setIn(in);
        Main.main(null);
        assertEquals("Omar Kalthoum", Main.name);
    }

    @Test
    @DisplayName("IsAdultWhenOlderThan18")
    public void whenUserIsOlderOrEqualTo18_ReturnAdult(){
        String age = "19";
        ByteArrayInputStream in = new ByteArrayInputStream(age.getBytes());
        System.setIn(in);
        Main.getUserAge();
        assertTrue(Main.isAdult);
    }

    @Test
    @DisplayName("IsNotAdultWhenYoungerThan18")
    public void whenUserIsYoungerThan18_ReturnNotAdult(){
        String age = "12";
        ByteArrayInputStream in = new ByteArrayInputStream(age.getBytes());
        System.setIn(in);
        Main.getUserAge();
        assertFalse(Main.isAdult);
    }

    @Test
    @DisplayName("ExceptionWhenInputIsNotInteger")
    public void whenUserInputWrongAge_ReturnNotAdult(){
        String age = "odt";
        ByteArrayInputStream in = new ByteArrayInputStream(age.getBytes());
        System.setIn(in);
        assertThrows(NumberFormatException.class, Main::getUserAge);
    }
}