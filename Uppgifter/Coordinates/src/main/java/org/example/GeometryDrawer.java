package org.example;

import java.util.List;

public class GeometryDrawer {

    public String draw(List<Coordinates> coordinatesList){
        String returnString = "";
        int listSize = coordinatesList.size();

        if(listSize == 0){
            returnString = "None";
        }
        else if(listSize == 1){
            returnString = "Dot";
        }
        else if(listSize == 2){
            returnString = "Line";
        }
        else if(listSize == 3){
            returnString = "Triangle";
        }
        else if (listSize == 4) {

            if(coordinatesList.get(0).getCoordinates() == coordinatesList.get(1).getCoordinates() &&
                    coordinatesList.get(1).getCoordinates() == coordinatesList.get(2).getCoordinates() &&
            coordinatesList.get(2).getCoordinates() == coordinatesList.get(3).getCoordinates()){
                returnString = "Square";
            }

        }

        return returnString;
    }

}
