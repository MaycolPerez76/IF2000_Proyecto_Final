package Interface;

import domain.Flight;
import domain.Invoice;
import domain.Passenger;
import domain.Plane;
import domain.Ticket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import logic.CalcAmountMethod;
import logic.FlightMethods;
import logic.PlaneMethods;
import logic.SpinnerController;
import logic.ValidateInformation;

public class Interface extends JPanel {

    private JComboBox<String> originCombo, destinationCombo, classCombo, timeCombo;
    private JTextField nameField, idField;
    private JTextArea ticketArea, invoiceArea, viewAvailableSeats;
    private JSpinner dateSpinner, luggageSpinner;
    private JLabel dateLabel, timeLabel, luggageLabel;
    private Plane plane;
    private Flight flight;
    private Passenger passenger;
    private PlaneMethods planemeth;
    private FlightMethods fligmeth;
    private ValidateInformation valInf;
    private CalcAmountMethod calA;
    private SpinnerController spinController;
    

    public Interface() {
        // Inicializar la capa lógica
        this.fligmeth = new FlightMethods();
        this.planemeth = new PlaneMethods();
        this.calA = new CalcAmountMethod();
        this.spinController = new SpinnerController();

        initComponents();
    }

    //TODO el contenido dentro de un metodo
    private void initComponents() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Reservation Details"));

        // Origin
        formPanel.add(new JLabel("Origin:"));
        originCombo = new JComboBox<>(new String[]{"San Jose", "Liberia", "Limon"});
        formPanel.add(originCombo);

        // Destination
        formPanel.add(new JLabel("Destination:"));
        destinationCombo = new JComboBox<>(new String[]{"San Jose", "Liberia", "Mexico", "Nicaragua", "Colombia"});
        formPanel.add(destinationCombo);

        // Class
        formPanel.add(new JLabel("Class:"));
        classCombo = new JComboBox<>(new String[]{"Business", "Economy"});
        formPanel.add(classCombo);

        // Date
        dateLabel = new JLabel("Date:");
        formPanel.add(dateLabel);
        dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        formPanel.add(dateSpinner);

        // Time
        timeLabel = new JLabel("Time:");
        formPanel.add(timeLabel);
        timeCombo = new JComboBox<>();
        formPanel.add(timeCombo);

        // Full name
        formPanel.add(new JLabel("Full Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        // Identification
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        // Luggage (kg)
        luggageLabel = new JLabel("Luggage (kg):");
        formPanel.add(luggageLabel);
        luggageSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        formPanel.add(luggageSpinner);

        // Results panel 
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

        // Button panel 
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
            boolean locationValidated = fligmeth.validateLocations(origin, destination);
            boolean isAvailable = planemeth.hasAvailability(plane, selectedClass);

            //Funciones
            if (!locationValidated) {
                JOptionPane.showMessageDialog(this, "Error, the origin and destination must to be different", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (isAvailable) {
                JOptionPane.showMessageDialog(this, "Seats available in " + selectedClass.toUpperCase(), "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No seats available in " + selectedClass.toUpperCase(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        //___________________________________________FUNCTION_2_______________________________________________________________________
        JButton generateButton = new JButton("Generate Ticket and Invoice");
        generateButton.addActionListener((ActionEvent e) -> {
            // Datos base
            String name = nameField.getText().trim();
            String id = idField.getText().trim();
            String travelClass = (String) classCombo.getSelectedItem();
            String selectedClass = travelClass.toLowerCase();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(dateSpinner.getValue());
            String time = (String) timeCombo.getSelectedItem();
            int luggageKg = (int) luggageSpinner.getValue();

            if (!ValidateInformation.validateName(name)) {
                JOptionPane.showMessageDialog(this,
                        "Please enter your full name or validate that name only contains letters and spaces",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!ValidateInformation.validateID(id)) {
                JOptionPane.showMessageDialog(this,
                        "Please enter your ID or validate that ID only contains numbers",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (plane == null || flight == null) {
                JOptionPane.showMessageDialog(this,
                        "Please check availability first",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!planemeth.hasAvailability(plane, selectedClass)) {
                JOptionPane.showMessageDialog(this, "The " + travelClass + " class is not available", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Creacion de objetos y metodos
            Passenger passenger = new Passenger(name, id);
            Ticket ticket = new Ticket(passenger, flight, travelClass);
            Invoice invoice = new Invoice(0, passenger, flight, plane);
            calA.calcAmount(invoice, travelClass);
        double luggageFee = spinController.calculateLuggageFee(luggageKg);

            // Mostrar informacion de ticket y Invoice
            ticketArea.setText(ticket.showTicketInfo() + "\nDate: " + date + "\nTime: " + time + "\nLuggage: " + luggageKg + " kg" + "\nLuggage Fee: $" + luggageFee);
            invoiceArea.setText(invoice.showInvoice() + "\n\n--- Luggage Details ---" + "\nLuggage: " + luggageKg + " kg" + "\nLuggage Fee: $" + luggageFee);
            JOptionPane.showMessageDialog(this, "Reservation completed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
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
            //Asientos disponibles, ocupados y totales
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
                    "CLASS: " + selectedClass.toUpperCase()
                    + "\nTotal seats: " + totalSeats
                    + "\nOccupied seats: " + occupiedSeats
                    + "\nAvailable seats: " + availableSeats
            );
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(checkButton);
        buttonPanel.add(generateButton);
        buttonPanel.add(seatsButton);
        buttonPanel.add(exitButton);
        add(formPanel, BorderLayout.NORTH);
        add(resultsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        spinController.initializeDateSpinner(dateSpinner, timeCombo);
    }

    //-------------------------Fecha-----------------------------//
    
}
