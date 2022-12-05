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

            if (coordinatesList.get(0).getX() == coordinatesList.get(1).getX() &&
                    coordinatesList.get(1).getX() == coordinatesList.get(2).getX() &&
                    coordinatesList.get(2).getX() == coordinatesList.get(3).getX()) {
                returnString = "Square";
            }
            else if (coordinatesList.get(0).getX() == coordinatesList.get(1).getX() &&
                    coordinatesList.get(1).getX() != coordinatesList.get(2).getX() &&
                    coordinatesList.get(2).getX() == coordinatesList.get(3).getX()) {
                returnString = "Rectangle";
            }
            else if (coordinatesList.get(0).getX() != coordinatesList.get(1).getX() ||
                    coordinatesList.get(1).getX() != coordinatesList.get(2).getX() ||
                    coordinatesList.get(2).getX() != coordinatesList.get(3).getX()) {
                returnString = "Parallelogram";
            }
        }

        return returnString;
    }

}
