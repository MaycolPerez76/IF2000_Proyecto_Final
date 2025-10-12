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

    // Check availability for a given class
    public boolean checkAvailability(String seatClass) {
        return plane.hasAvailability(seatClass);
    }

    // Reserve a seat for a given class
    public void reserveSeat(String seatClass) {
        plane.reserveSeat(seatClass);
    }

    // Getters
    public String getOrigin() {
    return origin;
    }
}