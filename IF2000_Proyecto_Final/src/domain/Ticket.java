package domain;

public class Ticket {
    private Passenger passenger;
    private Flight locations;
    private Plane travelClass;

    public Ticket(Passenger passenger, Flight locations, Plane travelClass) {
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
    public Plane getTravelClass() {
        return travelClass; 
    }

    public String showTicketInfo() {
        return "TICKET INFORMATION\n"
            + "Passenger: " + passenger.getName() + " (" + passenger.getId() + ")\n"
            + "Origin: " + locations.getOrigin() + "\n"
            + "Destination: " + locations.getDestination() + "\n"
            + "Class: " + travelClass.getModel() + "\n"
            + "Plane: Boeing 737";
    }
}