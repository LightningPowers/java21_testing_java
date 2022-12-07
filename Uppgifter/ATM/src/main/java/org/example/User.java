package org.example;

public class User {

    private String name;
    private int id;
    private Card card;
    private int pinCode;
    private Account account;

    public User(String name, Card card, int pinCode) {
        this.name = name;
        this.id = card.getId();
        this.card = card;
        this.pinCode = pinCode;
        this.account = new Account();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPinCode() {
        return pinCode;
    }

    public Card getCard() {
        return card;
    }

    public Account getAccount() {
        return account;
    }
}
