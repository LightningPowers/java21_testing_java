package org.example;

public class User {

    private String name;
    private double id;
    private Card card;

    public User(String name, Card card) {
        this.name = name;
        this.id = card.getId();
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public double getId() {
        return id;
    }
}
