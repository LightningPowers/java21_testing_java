package org.example;

import java.util.ArrayList;

public class EggBasket {

    ArrayList<Egg> eggs = new ArrayList<>();

    public ArrayList<Egg> getEggBasket(){
        return eggs;
    }

    public int removeEgg(int index){
        eggs.remove(index);
        if (eggs.isEmpty()){
            System.out.println("The basket is now empty.");
        }
        else {
            System.out.println("There are " + (eggs.size()) + " eggs left in the basket.");
        }
        return eggs.size();
    }
}
