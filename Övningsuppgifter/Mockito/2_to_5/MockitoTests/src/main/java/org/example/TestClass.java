package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestClass {

    private EggBasket eggBasket;

    @BeforeEach
    public void setup(){
        eggBasket = mock(EggBasket.class);
    }

    @Test
    public void getEggFromBasket(){
        ArrayList<Egg> tempEggBasket = new ArrayList<>
                (List.of(new Egg(), new Egg(),new Egg(), new Egg(),new Egg(),
                        new Egg(),new Egg(), new Egg(),new Egg(), new Egg()));

        when(eggBasket.getEggBasket()).thenReturn(tempEggBasket);

        for (int i = eggBasket.getEggBasket().size(); i > 0; i--){
            eggBasket.getEggBasket().remove(i);
            System.out.println(eggBasket.getEggBasket().size());
        }

    }
}
