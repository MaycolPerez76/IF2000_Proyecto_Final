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
public class FlightAvailability {
        PlaneAvailability pa = new PlaneAvailability();
        
    public boolean checkAvailability(Plane plane, String seatClass) {
        return pa.hasAvailability(plane, seatClass);
    }

    public void reserveSeat(Plane plane, String seatClass) {
        pa.reserveSeat(plane, seatClass);
    }

    
    
}
