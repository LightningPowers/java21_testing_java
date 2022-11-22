package org.example;

public class Sheep {
    private Planet planet;

    public Sheep(Planet planet) {
        this.planet = planet;
    }

    public boolean isDead() {
        return planet.getTemp() < -30 || planet.getOxygenRate() < 20 || planet.hasKillerSnails();
    }
}
