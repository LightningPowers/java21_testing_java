package org.example;

public class Walking {

    public static Foot currentFoot = Foot.upright;

    public enum Foot {
        right,
        left,
        upright
    }

    public void goToLeft(){
        if (currentFoot == Foot.left){
            throw new IllegalStateException();
        }
        currentFoot = Foot.left;
    }

    public void goToRight(){
        if (currentFoot == Foot.right){
            throw new IllegalStateException();
        }
        currentFoot = Foot.right;
    }

    public void stayUpright(){
        currentFoot = Foot.upright;
    }
}
