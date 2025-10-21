package Interface;

import domain.Flight;
import domain.Plane;
import logic.FlightAvailability;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {

    private JTextField originField;
    private JTextField destinationField;
    private JComboBox<String> classCombo;
    private JTextArea outputArea;
    private JButton checkButton;
    private JButton reserveButton;

    private Plane plane;
    private Flight flight;
    private FlightAvailability flightAvailability;

    public Interface() {
        // Crear objetos principales
        plane = new Plane("Boeing 737");
        flight = new Flight("Sin origen", "Sin destino", plane);
        flightAvailability = new FlightAvailability();

        initComponents();
    }

    private void initComponents() {
        setTitle("Compra de Boletos de Avión");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        topPanel.add(new JLabel("Origen:"));
        originField = new JTextField();
        topPanel.add(originField);

        topPanel.add(new JLabel("Destino:"));
        destinationField = new JTextField();
        topPanel.add(destinationField);

        topPanel.add(new JLabel("Clase:"));
        classCombo = new JComboBox<>(new String[]{"Business", "Economy"});
        topPanel.add(classCombo);

        add(topPanel, BorderLayout.NORTH);

        // Área de resultados
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Panel de botones
        JPanel bottomPanel = new JPanel();
        checkButton = new JButton("Verificar Disponibilidad");
        reserveButton = new JButton("Reservar Asiento");

        bottomPanel.add(checkButton);
        bottomPanel.add(reserveButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Eventos
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAvailability();
            }
        });

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserveSeat();
            }
        });
    }

    private void checkAvailability() {
        String origin = originField.getText().trim();
        String destination = destinationField.getText().trim();
        String seatClass = (String) classCombo.getSelectedItem();

        if (origin.isEmpty() || destination.isEmpty()) {
            outputArea.setText("Por favor, ingrese el origen y el destino del vuelo.");
            return;
        }

        // Actualizar vuelo
        flight = new Flight(origin, destination, plane);

        boolean available = flightAvailability.checkAvailability(plane, seatClass);
        if (available) {
            outputArea.setText("✅ Hay disponibilidad en " + seatClass +
                    " para el vuelo " + origin + " → " + destination + ".");
        } else {
            outputArea.setText("❌ No hay asientos disponibles en " + seatClass + ".");
        }
    }

    private void reserveSeat() {
        String origin = originField.getText().trim();
        String destination = destinationField.getText().trim();
        String seatClass = (String) classCombo.getSelectedItem();

        if (origin.isEmpty() || destination.isEmpty()) {
            outputArea.setText("Debe ingresar origen y destino antes de reservar.");
            return;
        }

        flight = new Flight(origin, destination, plane);
        boolean available = flightAvailability.checkAvailability(plane, seatClass);

        if (available) {
            flightAvailability.reserveSeat(plane, seatClass);
            outputArea.setText("🎟️ Reserva exitosa en " + seatClass +
                    " para el vuelo " + origin + " → " + destination + ".");
        } else {
            outputArea.setText("❌ No se pudo realizar la reserva. No hay asientos disponibles.");
        }
    }
}
