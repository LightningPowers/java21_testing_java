package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeometryDrawerTest {

    GeometryDrawer geometryDrawer;

    @BeforeEach
    public void setUp(){
        geometryDrawer = new GeometryDrawer();
    }

    @Test
    public void TestEmptyList(){
        List<Coordinates> coordinatesList = List.of();

        String expected = "None";
        String actual = geometryDrawer.draw(coordinatesList);
        System.out.println(actual);

        assertEquals(expected, actual);
    }
}