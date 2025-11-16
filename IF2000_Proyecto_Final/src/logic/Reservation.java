/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Flight;
import domain.Passenger;
import domain.Ticket;

/**
 *
 * @author mayco
 */
public class Reservation {
    public static Ticket makeReservation(Flight flight, Passenger passenger, String flightClass) {
        if (!flight.checkAvailability(flightClass)) {
            System.out.println("No availability in " + flightClass + " class.");
            return null;
        }

        flight.reserveSeat(flightClass);
        System.out.println("Reservation successful!");
        return new Ticket(passenger, flight, flightClass);
    }
}