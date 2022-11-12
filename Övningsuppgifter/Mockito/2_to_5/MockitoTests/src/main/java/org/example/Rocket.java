package org.example;

public class Rocket {

    private String material;

    public String getMaterial(){
        return material;
    }

    public String launchRocket(){
        String resultString = "";

        if (material.isEmpty() || material.equals("Bricks")){
            throw new RuntimeException();
        }
        else if (material.equals("Aerospace-grade titanium and aluminium alloys")){
            resultString = "The rocket has launched!";
        }

        return resultString;
    }

}
