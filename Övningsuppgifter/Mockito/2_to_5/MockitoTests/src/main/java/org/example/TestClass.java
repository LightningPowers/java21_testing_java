package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestClass {

    private EggBasket eggBasket;
    private Rocket rocket;

    @BeforeEach
    public void setup(){
        eggBasket = mock(EggBasket.class);
        rocket = mock(Rocket.class);
    }

    // My way (which is good)
    @Test
    public void getEggFromBasket(){
        ArrayList<Egg> tempEggBasket = new ArrayList<>
                (List.of(new Egg(), new Egg(),new Egg(), new Egg(),new Egg(),
                        new Egg(),new Egg(), new Egg(),new Egg(), new Egg()));

        when(eggBasket.getEggBasket()).thenReturn(tempEggBasket);

        Iterator<Egg> i = eggBasket.getEggBasket().iterator();
        int index = 10;
        while (i.hasNext()){
            Egg pickedEgg = i.next(); // Needed to use remove method
            i.remove();
            index--;
            assertEquals(index, eggBasket.getEggBasket().size());
            if (eggBasket.getEggBasket().isEmpty()){
                System.out.println("The basket is now empty.");
            }
            else {
                System.out.println("There are " + (eggBasket.getEggBasket().size()) + " eggs left in the basket.");
            }
        }
    }

    // The intended way for this assignment
    @Test
    public void getEggFromBasket2(){
        ArrayList<Egg> tempEggBasket = new ArrayList<>
                (List.of(new Egg(), new Egg(),new Egg(), new Egg(),new Egg(),
                        new Egg(),new Egg(), new Egg(),new Egg(), new Egg()));

        when(eggBasket.getEggBasket()).thenReturn(tempEggBasket);

        System.out.println(eggBasket.getEggBasket().size());

        assertAll(
                () -> assertEquals(9, eggBasket.removeEgg(9)),
                () -> assertEquals(8, eggBasket.removeEgg(8)),
                () -> assertEquals(7, eggBasket.removeEgg(7)),
                () -> assertEquals(6, eggBasket.removeEgg(6)),
                () -> assertEquals(5, eggBasket.removeEgg(5)),
                () -> assertEquals(4, eggBasket.removeEgg(4)),
                () -> assertEquals(3, eggBasket.removeEgg(3)),
                () -> assertEquals(2, eggBasket.removeEgg(2)),
                () -> assertEquals(1, eggBasket.removeEgg(1)),
                () -> assertEquals(0, eggBasket.removeEgg(0))
        );
    }

    @Test
    public void askGenieForAxe(){
        String requestedAxe = "Neither";

        String expected = "All";
        String actual = null;

        if (requestedAxe.equals("Neither")){
            System.out.println("The genie nods in approval. The iron axe as well as the other two were given to you!");
            actual = "All";
        }
        else if (requestedAxe.equals("Gold") || requestedAxe.equals("Silver")){
            System.out.println("The genie disapproves of your greed, and disappears into the river...");
            actual = "Nothing";
        }
        else {
            System.out.println("The genie is confused by your request...");
            actual = "Confused";
        }

        assertEquals(expected, actual);
    }

    @Test
    public void rocketLaunchMaterial(){
        String tempMaterial = "Bricks";

        when(rocket.getMaterial()).thenReturn(tempMaterial);

        System.out.println(rocket.launchRocket());
    }
}
