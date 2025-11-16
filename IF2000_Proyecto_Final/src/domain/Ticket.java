package domain;

public class Ticket {
    private final Passenger passenger;
    private final Flight locations;
    private final String travelClass;

    public Ticket(Passenger passenger, Flight locations, String travelClass) {
        this.passenger = passenger;
        this.locations = locations;
        this.travelClass = travelClass;
    }

    public Passenger getPassenger() {
        return passenger;
    }
    public Flight getLocations() { 
        return locations; 
    }
    public String getTravelClass() {
        return travelClass; 
    }

    public String showTicketInfo() {
        return "TICKET INFORMATION\n"
            + "Passenger: " + passenger.getName() + " (" + passenger.getId() + ")\n"
            + "Origin: " + locations.getOrigin() + "\n"
            + "Destination: " + locations.getDestination() + "\n"
            + "Class: " + travelClass + "\n"
            + "Plane: " + locations.getPlane().getModel();
    }
}