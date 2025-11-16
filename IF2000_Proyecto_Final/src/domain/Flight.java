package domain;

public class Flight {
    private String origin;
    private String destination;
    private Plane plane;
    private String code;
    private String departure;

    public Flight(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Flight(String origin, String destination, Plane plane) {
        this(origin, destination);
        this.plane = plane;
    }

    public Flight(String code, String origin, String destination, String departure, Plane plane) {
        this(origin, destination, plane);
        this.code = code;
        this.departure = departure;
    }

    public boolean validateLocations(String origin, String destination) {
        if (origin.equals(destination)) {
            return false;
        }
        return true;
    }


    public boolean checkAvailability(String seatClass) {
        return plane.hasAvailability(seatClass);
    }
    public boolean reserveSeat(String seatClass) {
        return plane.reserveSeat(seatClass);
    }
    public boolean occupySeat(String clase) {
        return reserveSeat(clase);
    }

    // Getters
    public String getOrigin() { 
        return origin; 
    }
    public String getDestination() {
        return destination;
    }
    public String getCode() { 
        return code; 
    }
    public String getDeparture() {
        return departure;
    }
    public Plane getPlane() { 
        return plane; 
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}