/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author mayco
 */
import domain.Flight;
import domain.Invoice;
import domain.Person;
import domain.Reservation;
import domain.Ticket;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author mayco
 */
public class ReservationWindow extends JFrame {
 private JComboBox<String> cbOrigin, cbDestination;
    private JRadioButton rbBusiness, rbEconomy;
    private JTextField tfName, tfId;
    private JTextArea taTicket, taInvoice;
    private JButton btnCheckAvailability, btnGenerate, btnExit;

    private Flight flight;
    private Aircraft aircraft;

    public ReservationWindow() {
        setTitle("Simulador de Reservación de Vuelos");
        setSize(650, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        JLabel lblOrigin = new JLabel("Origen:");
        lblOrigin.setBounds(30, 30, 100, 20);
        add(lblOrigin);

        cbOrigin = new JComboBox<>(new String[]{"San Jose", "Liberia", "Puntarenas"});
        cbOrigin.setBounds(100, 30, 150, 25);
        add(cbOrigin);

        JLabel lblDestination = new JLabel("Destino:");
        lblDestination.setBounds(30, 70, 100, 20);
        add(lblDestination);

        cbDestination = new JComboBox<>(new String[]{"Liberia", "San Jose", "Puntarenas"});
        cbDestination.setBounds(100, 70, 150, 25);
        add(cbDestination);

        btnCheckAvailability = new JButton("Verificar Disponibilidad");
        btnCheckAvailability.setBounds(280, 50, 180, 30);
        add(btnCheckAvailability);

        JLabel lblClass = new JLabel("Clase:");
        lblClass.setBounds(30, 110, 100, 20);
        add(lblClass);

        rbBusiness = new JRadioButton("Ejecutiva");
        rbBusiness.setBounds(100, 110, 100, 20);
        rbEconomy = new JRadioButton("Económica");
        rbEconomy.setBounds(200, 110, 100, 20);
        rbEconomy.setSelected(true);

        ButtonGroup groupClass = new ButtonGroup();
        groupClass.add(rbBusiness);
        groupClass.add(rbEconomy);

        add(rbBusiness);
        add(rbEconomy);

        JLabel lblName = new JLabel("Nombre completo:");
        lblName.setBounds(30, 150, 150, 20);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(160, 150, 200, 25);
        add(tfName);

        JLabel lblId = new JLabel("Identificación:");
        lblId.setBounds(30, 190, 150, 20);
        add(lblId);

        tfId = new JTextField();
        tfId.setBounds(160, 190, 200, 25);
        add(tfId);

        btnGenerate = new JButton("Generar Tiquete y Factura");
        btnGenerate.setBounds(380, 150, 220, 30);
        add(btnGenerate);

        btnExit = new JButton("Salir");
        btnExit.setBounds(500, 320, 100, 30);
        add(btnExit);

        // Ticket text area
        taTicket = new JTextArea();
        taTicket.setEditable(false);
        taTicket.setBorder(BorderFactory.createTitledBorder("Tiquete"));
        JScrollPane scrollTicket = new JScrollPane(taTicket);
        scrollTicket.setBounds(30, 230, 250, 120);
        add(scrollTicket);

        // Invoice text area
        taInvoice = new JTextArea();
        taInvoice.setEditable(false);
        taInvoice.setBorder(BorderFactory.createTitledBorder("Factura"));
        JScrollPane scrollInvoice = new JScrollPane(taInvoice);
        scrollInvoice.setBounds(320, 230, 250, 120);
        add(scrollInvoice);

        // Event handling
        btnCheckAvailability.addActionListener(e -> checkAvailability());
        btnGenerate.addActionListener(e -> generateTicketAndInvoice());
        btnExit.addActionListener(e -> System.exit(0));
    }

    private void checkAvailability() {
        String origin = cbOrigin.getSelectedItem().toString();
        String destination = cbDestination.getSelectedItem().toString();
        String flightClass = null;

        
         if (rbBusiness.isSelected()) {
        flightClass = "Business";
    } else if (rbEconomy.isSelected()) {
        flightClass = "Economy";
    }
        
        
        if (origin.equals(destination)) {
            JOptionPane.showMessageDialog(this, "El origen y destino no pueden ser iguales.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        aircraft = new Aircraft("Boeing 737", 2, 2);
        flight = new Flight(origin, destination, aircraft);

  //VERIFICAR QUE ESTE HABILITADO EL VUELO
        if ( flight.checkAvailability(flightClass)) {
            JOptionPane.showMessageDialog(this, "Hay espacio disponible en clase " + flightClass + ".", "Disponibilidad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No hay asientos disponibles en clase " + flightClass + ".", "Sin disponibilidad", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void generateTicketAndInvoice() {
        if (flight == null) {
            JOptionPane.showMessageDialog(this, "Primero verifique la disponibilidad del vuelo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String name = tfName.getText().trim();
        String id = tfId.getText().trim();
        if (name.length() == 0 || id.length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre e identificación.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String flightClass = null;
        
            if (rbBusiness.isSelected()) {
        flightClass = "Business";
    } else if (rbEconomy.isSelected()) {
        flightClass = "Economy";
    }
        
        Person passenger = new Person(name, id);
        Ticket ticket = Reservation.makeReservation(flight, passenger, flightClass);

        if (ticket == null) {
            JOptionPane.showMessageDialog(this, "No se pudo realizar la reservación.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Invoice invoice = new Invoice(ticket);

        // Show info
        taTicket.setText("Vuelo: " + flight.getOrigin() + " → " + flight.getDestination() +
                         "\nClase: " + flightClass +
                         "\nPasajero: " + passenger.getName());

        taInvoice.setText("Vuelo: " + flight.getOrigin() + " → " + flight.getDestination() +
                          "\nPasajero: " + passenger.getName() +
                          "\nMonto: €" + invoice.getAmount());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReservationWindow().setVisible(true);
        });
    }
}
