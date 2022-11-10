package org.example;

import java.util.ArrayList;

public class NaughtyList {

    private ArrayList<Child> childList = new ArrayList<>();

    public ArrayList<Child> getChildList() {
        return childList;
    }

    public Child getChild(int personNum){
        System.out.println(childList.size());
        Child child = null;
        int i = 0;
        System.out.println(childList.size());
        for (Child item : childList) {
            i++;
            System.out.println("Hehe XD: " + i);
            if (item.getPersonalNumber() == personNum){
                child = item;
            }
        }
        if (childList != null){
            for (i = 0; i < childList.size(); i++){

            }
        }
        return child;
    }

    public void addChild(Child child){
        childList.add(child);
    }
}
