package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class WalkingTest {

    Walking walking;

    @BeforeEach
    public void setUp(){
        walking = new Walking();
    }

    @Test
    public void whenGoLeft_ShouldGoLeft(){
        walking.goToLeft();
        assertEquals(Walking.Foot.left, Walking.currentFoot);
    }

    @Test
    public void whenGoRight_ShouldGoRight(){
        walking.goToRight();
        assertEquals(Walking.Foot.right, Walking.currentFoot);
    }

    @Test
    public void whenGoUpright_ShouldGoUpright(){
        walking.stayUpright();
        assertEquals(Walking.Foot.upright, Walking.currentFoot);
    }

    @Test
    public void whenGoRightTwice_ShouldThrowException(){
        walking.goToRight();
        Executable executable = () -> walking.goToRight();
        assertThrows(IllegalStateException.class, executable);
    }

    @Test
    public void whenGoLeftTwice_ShouldThrowException(){
        walking.goToLeft();
        Executable executable = () -> walking.goToLeft();
        assertThrows(IllegalStateException.class, executable);
    }

    @Test
    public void shouldGoNormal(){
        for (int i = 0; i < 1000; i++){
            assertDoesNotThrow(() -> walking.goToRight());
            assertDoesNotThrow(() -> walking.goToLeft());
        }
        walking.stayUpright();
    }
}