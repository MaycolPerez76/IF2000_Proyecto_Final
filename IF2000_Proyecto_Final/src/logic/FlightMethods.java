/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Flight;
import domain.Plane;



/**
 *
 * @author mayco
 */
public class FlightMethods {
    
    public boolean validateLocations(String origin, String destination) {
        if (origin.equals(destination)) {
            return false;
        }
        return true;
    }
    
    public boolean checkAvailability(Flight flight, String seatClass) {
        PlaneMethods pm = new PlaneMethods();
        //Toda la informacion y datos del avion escogido
        Plane plane = flight.getPlane();
        return pm.hasAvailability(plane, seatClass);
    }
    
    public boolean reserveSeat(Flight flight, String seatClass) {
        PlaneMethods pm = new PlaneMethods();
        Plane plane = flight.getPlane();
        //LLama al metodo de reserveSeat en PlaneMethods
        return pm.reserveSeat(plane, seatClass);
    }
    
    public boolean occupySeat(Flight flight, String seatClass) {
        return reserveSeat(flight, seatClass);
    }
}
