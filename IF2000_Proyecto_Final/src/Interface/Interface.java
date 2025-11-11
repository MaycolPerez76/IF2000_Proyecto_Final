package Interface;

import domain.Flight;
import domain.Plane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Interface extends JPanel {
    
    private JComboBox<String> originCombo, destinationCombo, classCombo;
    private JTextField nameField, idField;
    private JTextArea ticketArea, invoiceArea;
    private Plane plane;
        private Flight flight;
    public Interface() {
        initComponents();
    }

    private void initComponents() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form panel (left) - GridLayout for alignment
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Reservation Details"));
        
        // Origin - MANTENIDO
        formPanel.add(new JLabel("Origin:"));
        originCombo = new JComboBox<>(new String[]{"San Jose", "Liberia","Limon"});
        formPanel.add(originCombo);

        // Destination - MANTENIDO
        formPanel.add(new JLabel("Destination:"));
        destinationCombo = new JComboBox<>(new String[]{"San Jose", "Liberia","Mexico","Nicaragua","Colombia"});
        formPanel.add(destinationCombo);

        // Class - MANTENIDO
        formPanel.add(new JLabel("Class:"));
        classCombo = new JComboBox<>(new String[]{"Business", "Economy"});
        formPanel.add(classCombo);

        // Full name - Empty field - MANTENIDO
        formPanel.add(new JLabel("Full Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        // Identification - MANTENIDO
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        // Results panel (center)
        JPanel resultsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        
        // Ticket
        JPanel ticketPanel = new JPanel(new BorderLayout());
        ticketPanel.setBorder(BorderFactory.createTitledBorder("Ticket"));
        ticketArea = new JTextArea(8, 20);
        ticketArea.setEditable(false);
        ticketArea.setText("Ticket will appear here...");
        JScrollPane ticketScroll = new JScrollPane(ticketArea);
        ticketPanel.add(ticketScroll, BorderLayout.CENTER);

        // Invoice
        JPanel invoicePanel = new JPanel(new BorderLayout());
        invoicePanel.setBorder(BorderFactory.createTitledBorder("Invoice"));
        invoiceArea = new JTextArea(8, 20);
        invoiceArea.setEditable(false);
        invoiceArea.setText("Invoice will appear here...");
        JScrollPane invoiceScroll = new JScrollPane(invoiceArea);
        invoicePanel.add(invoiceScroll, BorderLayout.CENTER);

        resultsPanel.add(ticketPanel);
        resultsPanel.add(invoicePanel);

        // Button panel (south)
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        
        
              //___________________________________________FUNCTION_1________________________________________________________________________
JButton checkButton = new JButton("Check Availability");
checkButton.addActionListener((ActionEvent e) -> {
    // FUNCIÓN: Verificar disponibilidad de asientos
    // Business: $275.00 | Economy: $201.30
    String selectedClass = ((String) classCombo.getSelectedItem()).toLowerCase();
    String origin = (String) originCombo.getSelectedItem();
    String destination = (String) destinationCombo.getSelectedItem();

  
    int businessCap = 1;
    int economyCap = 1;
    int businessOccup = 1;
    int economyOccup = 1;

    switch (destination) {
        case "Mexico":
            businessCap = 5;
            economyCap = 6;
            businessOccup = 2;
            economyOccup = 3;
            break;
        case "San Jose":
            businessCap = 6;
            economyCap = 8;
            businessOccup = 4;
            economyOccup = 8;
            break;
        case "Liberia":
            businessCap = 3;
            economyCap = 4;
            businessOccup = 3;
            economyOccup = 2;
            break;
        case "Colombia":
            businessCap = 5;
            economyCap = 7;
            businessOccup = 3;
            economyOccup = 5;
            break;
        case "Nicaragua":
            businessCap = 4;
            economyCap = 5;
            businessOccup = 4;
            economyOccup = 5;
            break;
    }
    plane = new Plane("Boeing 737", businessCap, economyCap, businessOccup, economyOccup);
    flight = new Flight(origin, destination, plane);

    boolean locationValidated = flight.validateLocations(origin, destination);
    if (!locationValidated) {
        ticketArea.setText("Error, origin and destination must be different.");
        return;
    }

    boolean isAvailable = plane.hasAvailability(selectedClass);
    if (isAvailable) {
        ticketArea.setText("✅ Seats available in " + selectedClass.toUpperCase() +
                "\nBusiness: " + plane.getBusinessCapacity() + " total, " + plane.getBusinessOccupied()  + " occupied" +
                "\nEconomy: " + plane.getEconomyCapacity() + " total, " + plane.getEconomyOccupied() + " occupied");
    } else {
        ticketArea.setText("❌ No seats available in " + selectedClass.toUpperCase());
    }
});

        
                //___________________________________________FUNCTION_2_______________________________________________________________________
        JButton generateButton = new JButton("Generate Ticket and Invoice");
        generateButton.addActionListener((ActionEvent e) -> {
            // FUNCIÓN: Debe generar ticket y factura
            // Validar campos y calcular montos
            ticketArea.setText("Generate Ticket - Función por implementar");
            invoiceArea.setText("Invoice - Función por implementar");
        });
        
     //___________________________________________FUNCTION_3________________________________________________________________________
JButton seatsButton = new JButton("View Available Seats");
seatsButton.addActionListener((ActionEvent e) -> {
    // FUNCIÓN: Mostrar estado de asientos disponibles
    if (plane == null) {
        ticketArea.setText("Please check availability first.");
        return;
    }

    String selectedClass = ((String) classCombo.getSelectedItem()).toLowerCase();

    int totalSeats = 0;
    int occupiedSeats = 0;
    int availableSeats = 0;

    if (selectedClass.equals("business")) {
        totalSeats = plane.getBusinessCapacity();
        occupiedSeats = plane.getBusinessOccupied();
        availableSeats = totalSeats - occupiedSeats;
    } else if (selectedClass.equals("economy")) {
        totalSeats = plane.getEconomyCapacity();
        occupiedSeats = plane.getEconomyOccupied();
        availableSeats = totalSeats - occupiedSeats;
    }

    ticketArea.setText(
            "✈️ CLASS: " + selectedClass.toUpperCase() +
            "\nTotal seats: " + totalSeats +
            "\nOccupied seats: " + occupiedSeats +
            "\nAvailable seats: " + availableSeats
    );
});
        


        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        
        buttonPanel.add(checkButton);
        buttonPanel.add(generateButton);
        buttonPanel.add(seatsButton);
        buttonPanel.add(exitButton);

        // Add all panels
        add(formPanel, BorderLayout.NORTH);
        add(resultsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}