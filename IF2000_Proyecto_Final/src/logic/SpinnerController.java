package logic;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class SpinnerController {

    // Inicializa el spinner de fecha con sus límites y carga inicial de horarios
    public void initializeDateSpinner(JSpinner dateSpinner, JComboBox<String> timeCombo) {

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date maxDate = calendar.getTime();

        SpinnerDateModel dateModel = new SpinnerDateModel(today, today, maxDate, Calendar.DAY_OF_YEAR);
        dateSpinner.setModel(dateModel);

        // Listener: al cambiar fecha, recargar horarios
        dateSpinner.addChangeListener(e -> {
            loadTimeSlots((Date) dateSpinner.getValue(), timeCombo);
        });

        loadTimeSlots(today, timeCombo);
    }

    // Carga horarios segun la fecha seleccionada
    public void loadTimeSlots(Date selectedDate, JComboBox<String> timeCombo) {

        if (timeCombo != null) {
            timeCombo.removeAllItems();

            Calendar cal = Calendar.getInstance();
            cal.setTime(selectedDate);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            // Domingo → Horarios cada 2 horas y uno extra a las 23:00
            if (dayOfWeek == Calendar.SUNDAY) {
                for (int hour = 5; hour <= 21; hour += 2) {
                    timeCombo.addItem(String.format("%02d:00", hour));
                }
                timeCombo.addItem("23:00");
            } else {
                // Resto de días → Horarios cada hora
                for (int hour = 5; hour <= 21; hour++) {
                    timeCombo.addItem(String.format("%02d:00", hour));
                }
            }
        }
    }

    // Calcula precio por equipaje extra
    public double calculateLuggageFee(int luggageKg) {
        double freeAllowance = 15.0;
        if (luggageKg <= freeAllowance) {
            return 0.0;
        }
        return (luggageKg - freeAllowance) * 2.0;
    }
}
