package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlanetTest {

    Planet planet;

    @BeforeEach
    public void setUp(){
        planet = mock(Planet.class);
        when(planet.getTemp()).thenReturn(10.0);
        when(planet.getOxygenRate()).thenReturn(33.3);
    }

    @Test
    public void shouldReturnOxygenRateWhenGetOxygenRate(){
        when(planet.getOxygenRate()).thenReturn(20.2);
        assertEquals(20.2, planet.getOxygenRate());
    }

    @Test
    public void shouldReturnTempWhenGetTemp(){
        when(planet.getTemp()).thenReturn(30.9);
        assertEquals(30.9, planet.getTemp());
    }

    @Test
    public void shouldReturnTrueWhenHasKillerSnails(){
        when(planet.hasKillerSnails()).thenReturn(true);
        assertTrue(planet.hasKillerSnails());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-40.2, -33.2, -90.4, -293.1})
    public void shouldDieIfTempIsLowerMinus30(double temp){
        Sheep sheep = new Sheep(planet);
        when(planet.getTemp()).thenReturn(temp);
        boolean actual = sheep.isDead();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(doubles = {40.2, 33.2, 90.4, 86.1})
    public void shouldDieIfOxygenIsHigherThan20Percent(double oxygenRate){
        Sheep sheep = new Sheep(planet);
        when(planet.getOxygenRate()).thenReturn(oxygenRate);
        boolean actual = sheep.isDead();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDieIfThereAreKillerSnails(){
        Sheep sheep = new Sheep(planet);
        when(planet.hasKillerSnails()).thenReturn(false);
        boolean actual = sheep.isDead();
        boolean expected = false;
        assertEquals(expected, actual);
    }
}