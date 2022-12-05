package org.example;

import java.util.List;

public class GeometryDrawer {

    public String draw(List<Coordinates> coordinatesList){
        String returnString = "";

        if(coordinatesList.size() == 0){
            returnString = "None";
        }

        return returnString;
    }

}
