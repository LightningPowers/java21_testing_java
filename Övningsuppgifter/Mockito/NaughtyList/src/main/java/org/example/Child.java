package org.example;

public class Child {

    private String name;
    private int personalNumber;
    private boolean isNaughty;

    public Child(String name, int personalNumber, boolean isNaughty) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.isNaughty = isNaughty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }
}
