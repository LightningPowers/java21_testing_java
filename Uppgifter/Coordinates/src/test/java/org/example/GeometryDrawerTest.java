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

    @Test
    public void TestDotCoordinates(){
        List<Coordinates> coordinatesList = List.of(new Coordinates(1, 1, 0));

        String expected = "Dot";
        String actual = geometryDrawer.draw(coordinatesList);
        System.out.println(actual);

        assertEquals(expected, actual);
    }

    @Test
    public void TestLineCoordinates(){
        List<Coordinates> coordinatesList = List.of(new Coordinates(1, 1, 0), new Coordinates(1, 2, 1));

        String expected = "Line";
        String actual = geometryDrawer.draw(coordinatesList);
        System.out.println(actual);

        assertEquals(expected, actual);
    }

    @Test
    public void TestTriangleCoordinates(){
        List<Coordinates> coordinatesList = List.of(new Coordinates(1, 1, 0), new Coordinates(1, 2, 1),
                new Coordinates(1, 2, 3));

        String expected = "Triangle";
        String actual = geometryDrawer.draw(coordinatesList);
        System.out.println(actual);

        assertEquals(expected, actual);
    }

    @Test
    public void TestFourCoordinates(){
        List<Coordinates> coordinatesList = List.of(new Coordinates(1, 1, 1), new Coordinates(1, 1, 1),
                new Coordinates(2, 1, 1), new Coordinates(3, 1, 1));

        String expected = "Square";
        String actual = geometryDrawer.draw(coordinatesList);
        System.out.println(actual);

        assertNotEquals(expected, actual);
    }
}