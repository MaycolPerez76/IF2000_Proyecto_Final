package domain;

public class Flight {
    private String origin;
    private String destination;
    private Plane plane;

    private String code;
    private String departure;
    
    // Constructor without plane
    public Flight(String origin, String destination) {
        validateLocations(origin, destination);
        this.origin = origin;
        this.destination = destination;
    }

    // Constructor with plane
    public Flight(String origin, String destination, Plane plane) {
        validateLocations(origin, destination);
        this.origin = origin;
        this.destination = destination;
        this.plane = plane;
    }
    //Full constructor
    public Flight(String code, String origin, String destination, String departure, Plane plane){
    validateLocations(origin, destination);
    this.code = code;
    this.origin = origin;
    this.destination = destination;
    this.departure = departure;
    this.plane = plane;
    }

    public boolean validateLocations(String origin, String destination){
        if (origin.equals(destination)) {
            return false;      
        }
        return true;
    }
    
    private void ensurePlane(){
        if (plane == null) throw new IllegalStateException("There is no aircraft assigned to the flight");
    }
    
    // Check availability for a given class
    public boolean checkAvailability(String seatClass) {
        ensurePlane();
        return plane.hasAvailability(seatClass);
    }

    // Reserve a seat for a given class
    public boolean reserveSeat(String seatClass) {
        ensurePlane();
        return plane.reserveSeat(seatClass);
    }
    
    public boolean occupySeat(String clase) { 
        return reserveSeat(clase);
    }
    
    // Getters
    public String getOrigin() {
    return origin;
    }
    
    public String getDestination(){
    return destination;
    }
    
    public String getCode(){
    return code;
    }
    
    public String getDeparture(){
    return departure;
    }
    
    //Prueba
    
    public Plane getPlane(){
    return plane;
    }
    
    public void setPlane(Plane plane){
    this.plane = plane;    
    }
}