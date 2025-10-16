/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package domain;


public class Plane {
    private String model;
    private int businessCapacity;
    private int economyCapacity;
    private int businessOccupied;
    private int economyOccupied;

    // Constructor

    public Plane(String model, int businessCapacity, int economyCapacity, int businessOccupied, int economyOccupied) {
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

    public void setBusinessCapacity(int businessCapacity) {
        this.businessCapacity = businessCapacity;
    }

    public int getEconomyCapacity() {
        return economyCapacity;
    }

    public void setEconomyCapacity(int economyCapacity) {
        this.economyCapacity = economyCapacity;
    }

    public int getBusinessOccupied() {
        return businessOccupied;
    }

    public void setBusinessOccupied(int businessOccupied) {
        this.businessOccupied = businessOccupied;
    }

    public int getEconomyOccupied() {
        return economyOccupied;
    }

    public void setEconomyOccupied(int economyOccupied) {
        this.economyOccupied = economyOccupied;
    }

    

    
    
    
}