/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package domain;



public class Flight {
    private String origin;
    private String destination;
    private Plane plane;


    // Constructor without plane
    public Flight(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    // Constructor with plane
    public Flight(String origin, String destination, Plane plane) {
        this.origin = origin;
        this.destination = destination;
        this.plane = plane;
    }

    //GETTERS
    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Plane getPlane() {
        return plane;
    }

  
}
