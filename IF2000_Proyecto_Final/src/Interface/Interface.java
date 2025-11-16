package Interface;

import domain.Flight;
import domain.Invoice;
import domain.Passenger;
import domain.Plane;
import domain.Ticket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import logic.CalculateAmount;
import logic.ValidateInformation;

public class Interface extends JPanel {
    
    private JComboBox<String> originCombo, destinationCombo, classCombo;
    private JTextField nameField, idField;
    private JTextArea ticketArea, invoiceArea, viewAvailableSeats;
    private Plane plane;
    private Flight flight;
    private Passenger passenger;
    private Ticket ticket;
    private Invoice total;
    private Flight locations;
    private Ticket ticketInfo;
    private Invoice amount;
    private double totalAmount;
    
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
        

        
        // ViewAvailableSeats
        JPanel viewAvailableSeatsPanel = new JPanel(new BorderLayout());
        viewAvailableSeatsPanel.setBorder(BorderFactory.createTitledBorder("View Available Seats"));
        viewAvailableSeats = new JTextArea(8, 20);
        viewAvailableSeats.setEditable(false);
        viewAvailableSeats.setText("Available Seats will appear here...");
        JScrollPane viewAvailableSeatsScroll = new JScrollPane(viewAvailableSeats);
        viewAvailableSeatsPanel.add(viewAvailableSeatsScroll, BorderLayout.CENTER);


        resultsPanel.add(ticketPanel);
        resultsPanel.add(invoicePanel);
        resultsPanel.add(viewAvailableSeatsPanel);

        

        // Button panel (south)
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        
        
        //___________________________________________FUNCTION_1________________________________________________________________________
        JButton checkButton = new JButton("Check Availability");
        checkButton.addActionListener((ActionEvent e) -> {
            //Atributos
            String selectedClass = ((String) classCombo.getSelectedItem()).toLowerCase();
            String origin = (String) originCombo.getSelectedItem();
            String destination = (String) destinationCombo.getSelectedItem();
            int businessCap = 1;
            int economyCap = 1;
            int businessOccup = 1;
            int economyOccup = 1;

            //Funcion
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

            //Implementacion de las clases y metodos
            plane = new Plane("Boeing 737", businessCap, economyCap, businessOccup, economyOccup);
            flight = new Flight(origin, destination, plane);
            boolean locationValidated = flight.validateLocations(origin, destination);
            boolean isAvailable = plane.hasAvailability(selectedClass);

            //Funciones
            if (!locationValidated) {
                JOptionPane.showMessageDialog(this, "Error, the origin and destination must to be different", " ", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (isAvailable) {
                JOptionPane.showMessageDialog(this, "Seats available in " + selectedClass.toUpperCase() + " ", "successfully", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No seats available in " + selectedClass.toUpperCase() + " ", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        });



                //___________________________________________FUNCTION_2_______________________________________________________________________
        JButton generateButton = new JButton("Generate Ticket and Invoice");
        generateButton.addActionListener((ActionEvent e) -> {
          // Datos base
    String name = nameField.getText().trim();
    String id = idField.getText().trim();
    String origin = (String) originCombo.getSelectedItem();
    String destination = (String) destinationCombo.getSelectedItem();
    String travelClass = (String) classCombo.getSelectedItem();
    String selectedClass = travelClass.toLowerCase();

    // Validaciones
    if (!ValidateInformation.validateName(name)) {
        ticketArea.setText("There was an error validating your name.");
        return;
    }
    if (!ValidateInformation.validateID(id)) {
        ticketArea.setText("There was an error validating your ID.");
        return;
    }
    if (!plane.hasAvailability(selectedClass)) {
        JOptionPane.showMessageDialog(this, "The plane class is not available.");
        return;
    }

    // Creacion de objetos  y metodos
    passenger = new Passenger(name, id);
    locations = new Flight(origin, destination);
    plane = new Plane(travelClass);
    Ticket ticket = new Ticket(passenger, locations, plane);
    Invoice invoice = new Invoice(0, passenger, locations, plane);
    CalculateAmount.calcAmount(invoice, travelClass);
    boolean isAvailable = plane.hasAvailability(selectedClass);
    
    // Mostrar informacion de ticket y Invoice
    if (isAvailable) {
    ticketArea.setText(ticket.showTicketInfo());
    invoiceArea.setText(invoice.showInvoice());
    } else {
  JOptionPane.showMessageDialog(this, "The class " + selectedClass.toUpperCase() + " is not available " + " ", "Error", JOptionPane.INFORMATION_MESSAGE);
    }
});

     //___________________________________________FUNCTION_3________________________________________________________________________
JButton seatsButton = new JButton("View Available Seats");
seatsButton.addActionListener((ActionEvent e) -> {
    //Atributos
    String selectedClass = ((String) classCombo.getSelectedItem()).toLowerCase();
    int totalSeats = 0;
    int occupiedSeats = 0;
    int availableSeats = 0;

        //Funciones
        if (plane == null) {
        viewAvailableSeats.setText("Please check availability first.");
        return;
    }
    if (selectedClass.equals("business")) {
        totalSeats = plane.getBusinessCapacity();
        occupiedSeats = plane.getBusinessOccupied();
        availableSeats = totalSeats - occupiedSeats; 
    } else if (selectedClass.equals("economy")) {
        totalSeats = plane.getEconomyCapacity();
        occupiedSeats = plane.getEconomyOccupied();
        availableSeats = totalSeats - occupiedSeats;
    }
    viewAvailableSeats.setText(
            "CLASS: " + selectedClass.toUpperCase() +
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