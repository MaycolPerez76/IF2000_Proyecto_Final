package domain;

public class Plane {
    private String model;
    private int businessCapacity;
    private int economyCapacity;
    private int businessOccupied;
    private int economyOccupied;

    // Constructor por defecto
    public Plane(String model) {
        this.model = model;
        this.businessCapacity = 10;
        this.economyCapacity = 50;
        this.businessOccupied = 0;
        this.economyOccupied = 0;
    }

    // Constructor COMPLETO (Úsalo siempre)
    public Plane(String model, int businessCapacity, int economyCapacity,
                 int businessOccupied, int economyOccupied) {

        this.model = model;
        this.businessCapacity = businessCapacity;
        this.economyCapacity = economyCapacity;
        this.businessOccupied = businessOccupied;
        this.economyOccupied = economyOccupied;
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
