/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Plane;

/**
 *
 * @author mayco
 */
public class PlaneMethods {

    public boolean hasAvailability(Plane plane, String seatClass) {
        if (seatClass.equalsIgnoreCase("business")) {
            return plane.getBusinessOccupied() < plane.getBusinessCapacity();
        } else if (seatClass.equalsIgnoreCase("economy")) {
            return plane.getEconomyOccupied() < plane.getEconomyCapacity();
        }
        return false;
    }

    public boolean reserveSeat(Plane plane, String seatClass) {
        if (seatClass.equalsIgnoreCase("business")) {
            plane.setBusinessOccupied(plane.getBusinessOccupied() + 1);

        } else if (seatClass.equalsIgnoreCase("economy")) {
            plane.setEconomyOccupied(plane.getEconomyOccupied() + 1);
        }

        return true;
    }
}
   
