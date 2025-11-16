package domain;

public class Ticket {
    private final Passenger passenger;
    private final Flight flight;
    private final String travelClass;

    public Ticket(Passenger passenger, Flight flight, String travelClass) {
        this.passenger = passenger;
        this.flight = flight;
        this.travelClass = travelClass;
    }

    public Passenger getPassenger() {
        return passenger;
    }
    public Flight getFlight() { 
        return flight; 
    }
    public String getTravelClass() {
        return travelClass; 
    }

    public String showTicketInfo() {
        return "TICKET INFORMATION\n"
            + "Passenger: " + passenger.getName() + " (" + passenger.getId() + ")\n"
            + "Origin: " + flight.getOrigin() + "\n"
            + "Destination: " + flight.getDestination() + "\n"
            + "Class: " + travelClass + "\n"
            + "Plane: " + flight.getPlane().getModel();
    }
}