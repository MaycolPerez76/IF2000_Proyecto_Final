package logic;

import domain.Plane;

public class PlaneAvailability {

    
      public boolean hasAvailability(Plane plane, String flightClass) {
    if (flightClass.equals("Business")) {
        if (plane.getBusinessOccupied() < plane.getBusinessCapacity()) {
            return true;
        } else {
            return false;
        }
    } else if (flightClass.equals("Economy")) {
        if (plane.getEconomyOccupied() < plane.getEconomyCapacity()) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

public void reserveSeat(Plane plane, String flightClass) {
    
    if (hasAvailability(plane, flightClass)) {   
        if (flightClass.equals("Business")) {
            plane.setBusinessOccupied(plane.getBusinessCapacity() + 1);

        } else if (flightClass.equals("Economy")) {
            plane.setBusinessOccupied(plane.getBusinessCapacity() + 1);

        }
    } else {
        System.out.println("There is no availability in " + flightClass);
    }
}

    
    
    
    
}
