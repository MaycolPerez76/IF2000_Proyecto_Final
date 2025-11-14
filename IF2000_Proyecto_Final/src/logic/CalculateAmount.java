import domain.Invoice;

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