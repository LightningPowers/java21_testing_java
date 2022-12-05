package org.example;

import java.util.List;

public class Coordinates {

    private double x;
    private double y;
    private double z;

    public Coordinates(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public List<Double> getCoordinates(){
        return List.of(x, y, z);
    }
}