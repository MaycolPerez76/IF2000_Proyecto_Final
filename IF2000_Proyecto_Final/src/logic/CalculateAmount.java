/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package logic;

import domain.Invoice;

/**
 *
 * @author mayco
 */

public class CalculateAmount {
    
    private void calculateAmount(Invoice inv) {
        if (inv.getTicket() != null) {
            if (inv.getClass().toString().equalsIgnoreCase("Business")) {
                inv.setAmount(350.00);
            } else {
                inv.setAmount(183.00);
            }
        }
    }
}