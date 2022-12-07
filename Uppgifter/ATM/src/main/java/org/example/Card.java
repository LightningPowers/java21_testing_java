package org.example;

public class Card {

    private int id;
    private boolean isLocked;

    public Card(int id) {
        this.id = id;
        this.isLocked = false;
    }

    public int getId() {
        return id;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
