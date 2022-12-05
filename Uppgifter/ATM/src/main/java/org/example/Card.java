package org.example;

public class Card {

    private double id;
    private boolean isLocked;

    public Card(double id) {
        this.id = id;
        this.isLocked = false;
    }

    public double getId() {
        return id;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
