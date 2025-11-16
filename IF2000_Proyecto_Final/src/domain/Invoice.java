package domain;

public class Invoice {
   private double amount;
    private Passenger passenger;
    private Flight locations;
    private Plane travelClass;

    public Invoice() {}

    public Invoice(double amount, Passenger passenger, Flight locations, Plane travelClass) {
        this.amount = amount;
        this.passenger = passenger;
        this.locations = locations;
        this.travelClass = travelClass;
    }

    public double getAmount() { 
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
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

    public String showInvoice() {
        return "INVOICE\n"
            + "Passenger: " + passenger.getName() + "\n"
            + "Route: " + locations.getOrigin() + " -> " + locations.getDestination() + "\n"
            + "Class: " + travelClass.getModel() + "\n"
            + "Amount: €" + amount + "\n";
    }
}