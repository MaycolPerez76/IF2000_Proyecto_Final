package Interface;

import domain.Plane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Interface extends JPanel {
    
    private JComboBox<String> originCombo, destinationCombo, classCombo;
    private JTextField nameField, idField;
    private JTextArea ticketArea, invoiceArea;
    private Plane plane;
    
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
        
        JButton checkButton = new JButton("Check Availability");
        checkButton.addActionListener((ActionEvent e) -> {
            // FUNCIÓN: Debe verificar disponibilidad de asientos
            // Business: $275.00 | Economy: $201.30
            plane = new Plane("Boeing 737", 2, 2);
              String selectedClass = (String) classCombo.getSelectedItem();

    if (selectedClass == null || selectedClass.isEmpty()) {
        ticketArea.setText("Please select a class.");
        return;
    }

    boolean available = plane.checkAvailability(selectedClass);

    if (available) {
        int remaining = selectedClass.equalsIgnoreCase("Business")
            ? plane.getBusinessCapacity() - plane.getBusinessOccupied()
            : plane.getEconomyCapacity() - plane.getEconomyOccupied();

        ticketArea.setText(selectedClass + " class is available.\nSeats remaining: " + remaining);
    } else {
        ticketArea.setText("No seats available in " + selectedClass + " class.");
    }
        });
        
        JButton generateButton = new JButton("Generate Ticket and Invoice");
        generateButton.addActionListener((ActionEvent e) -> {
            // FUNCIÓN: Debe generar ticket y factura
            // Validar campos y calcular montos
            ticketArea.setText("Generate Ticket - Función por implementar");
            invoiceArea.setText("Invoice - Función por implementar");
        });
        
        JButton seatsButton = new JButton("View Available Seats");
        seatsButton.addActionListener((ActionEvent e) -> {
            // FUNCIÓN: Mostrar estado de asientos disponibles
            ticketArea.setText("View Seats - Función por implementar");
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