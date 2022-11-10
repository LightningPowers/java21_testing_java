package org.example;

import java.util.ArrayList;

public class NaughtyList {

    private final ArrayList<Child> childList = new ArrayList<>();

    public ArrayList<Child> getChildList() {
        return childList;
    }

    public Child getChild(int personNum){
        Child child = null;
        for (Child item : childList) {
            if (item.getPersonalNumber() == personNum){
                child = item;
            }
        }
        return child;
    }

    public void addChild(Child child){
        childList.add(child);
    }
}
