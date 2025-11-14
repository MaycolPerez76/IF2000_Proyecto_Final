package logic;

import domain.Invoice;



public class CalculateAmount {

    public static void calcAmount(Invoice inv, String seatClass) {

        if (seatClass.equalsIgnoreCase("Business")) {
            inv.setAmount(350.00);
        } else {
            inv.setAmount(183.00);
        }
    }
}
