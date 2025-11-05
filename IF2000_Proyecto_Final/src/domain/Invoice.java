/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author mayco
 */
public class Invoice {
    private Ticket ticket;
    private double amount;

    public Invoice(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public void showInvoice() {
        System.out.println("=== INVOICE ===");
        System.out.println("Flight: " + ticket.getFlight().getOrigin() + " -> " + ticket.getFlight().getDestination());
        System.out.println("Passenger: " + ticket.getPassenger().getName());
        System.out.println("Amount: €" + amount);
    }
}