package logic;

import domain.Invoice;

public class CalculateAmount {

    public static double calcAmount(Invoice inv, String seatClass) {

        if (seatClass.equalsIgnoreCase("Business") || seatClass.equalsIgnoreCase("Economy")) {
            inv.setAmount(350.00);
        } else {
            inv.setAmount(183.00);
        }
        return inv.getAmount();
    }
}