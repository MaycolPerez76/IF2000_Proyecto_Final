package domain;


public class Ticket {
    private Flight flight;
    private Person passenger;
    private String flightClass;

    public Ticket(Flight flight, Person passenger, String flightClass) {
        this.flight = flight;
        this.passenger = passenger;
        this.flightClass = flightClass;
    }

    public Flight getFlight() {
        return flight;
    }

    public Person getPassenger() {
        return passenger;
    }

    public String getFlightClass() {
        return flightClass;
    }


    public void showTicketInfo() {
        System.out.println("=== TICKET ===");
        System.out.println("Flight: " + flight.getOrigin() + " -> " + flight.getDestination());
        System.out.println("Class: " + flightClass);
        System.out.println("Passenger: " + passenger.getName());
    }
}