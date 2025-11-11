
package domain;

public class Plane {
    private String model;
    private int businessCapacity;
    private int economyCapacity;
    private int businessOccupied;
    private int economyOccupied;

    // Constructor
    public Plane(String model) {
        this.model = model;
        this.businessCapacity = 2; // fixed capacity
        this.economyCapacity = 2;  // fixed capacity
        this.businessOccupied = 0;
        this.economyOccupied = 0;
    }

    public Plane(String model, int businessCapacity, int economyCapacity) {
        this.model = model;
        this.businessCapacity = businessCapacity;
        this.economyCapacity = economyCapacity;
    }
    
    

    // Checks availability based on class
    public boolean hasAvailability(String seatClass) {
        if(seatClass == null)return false;
        if (seatClass.equalsIgnoreCase("business")) {
            return businessOccupied < businessCapacity;
        } else if (seatClass.equalsIgnoreCase("economy")) {
            return economyOccupied < economyCapacity;
        } else {
            return false; // invalid class
        }
    }

    // Reserves a seat based on class
    public boolean reserveSeat(String seatClass) {
        if (!hasAvailability(seatClass)) return false;
        if (seatClass.equalsIgnoreCase("business")) {
            businessOccupied++;
        } else if (seatClass.equalsIgnoreCase("economy")) {
            economyOccupied++;
        }else{
            return false;
        }
    return true;
    }

    public boolean checkAvailability(String clase){
    return hasAvailability(clase);
    }
    public boolean occupySeat(String clase){
    return reserveSeat(clase);
    }
    
    // Getters
    public String getModel() {
        return model;
    }

    public int getBusinessCapacity() {
        return businessCapacity;
    }

    public int getEconomyCapacity() {
        return economyCapacity;
    }

    public int getBusinessOccupied() {
        return businessOccupied;
    }

    public int getEconomyOccupied() {
        return economyOccupied;
  
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBusinessCapacity(int businessCapacity) {
        this.businessCapacity = businessCapacity;
    }

    public void setEconomyCapacity(int economyCapacity) {
        this.economyCapacity = economyCapacity;
    }

    public void setBusinessOccupied(int businessOccupied) {
        this.businessOccupied = businessOccupied;
    }

    public void setEconomyOccupied(int economyOccupied) {
        this.economyOccupied = economyOccupied;
    }
    
}
