package org.example;

public class Child {

    private String name;
    private int personalNumber;

    /*
    public Child(String name, int personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
    }
    */

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
