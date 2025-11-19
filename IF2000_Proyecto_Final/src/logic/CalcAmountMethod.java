/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Invoice;

/**
 *
 * @author mayco
 */
public class CalcAmountMethod {
          public static double calcAmount(Invoice inv, String seatClass) {
        if (seatClass.equalsIgnoreCase("Business") || seatClass.equalsIgnoreCase("Economy")) {
            inv.setAmount(350.00);
        } else {
            inv.setAmount(183.00);
        }
        return inv.getAmount();
    }
}
