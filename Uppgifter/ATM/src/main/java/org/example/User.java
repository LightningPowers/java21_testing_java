package org.example;

public class User {

    private String name;
    private double id;
    private Card card;

    private int pinCode;

    public User(String name, Card card, int pinCode) {
        this.name = name;
        this.id = card.getId();
        this.card = card;
        this.pinCode = pinCode;
    }

    public String getName() {
        return name;
    }

    public double getId() {
        return id;
    }

    public int getPinCode() {
        return pinCode;
    }
}
