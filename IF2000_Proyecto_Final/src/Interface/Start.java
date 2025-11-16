package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class Start extends JFrame {

    private Image backgroundImage;

    public Start() {
        setTitle("Airline - Start");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        
        try {
ImageIcon icon = new ImageIcon(getClass().getResource("/Interface/Plane.png"));
            System.out.println("Image uploaded from classpath");
        } catch (Exception e) {
            System.out.println("It was not found in classpath, trying direct route...");
        }

        
        if (backgroundImage == null) {
            File f = new File("src/Interface/Plane.png");
            if (f.exists()) {
                backgroundImage = new ImageIcon(f.getAbsolutePath()).getImage();
                System.out.println("Image uploaded from: " + f.getAbsolutePath());
            } else {
                System.out.println("The image was nor found on any route");
            }
        }

        // Panel de fondo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    g.setColor(Color.GRAY);
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.setColor(Color.WHITE);
                    g.drawString("Image not found", getWidth() / 2 - 40, getHeight() / 2);
                }
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // Texto superior
        JLabel titleLabel = new JLabel("Welcome to Airline UCR", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(60, 0, 40, 0));
        backgroundPanel.add(titleLabel, BorderLayout.NORTH);

        // Botón principal
        JButton startButton = new JButton("Buy Ticket");
        startButton.setFont(new Font("Segoe UI", Font.BOLD, 22));
        startButton.setBackground(new Color(0, 102, 204));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setPreferredSize(new Dimension(220, 60));
        startButton.addActionListener((ActionEvent e) -> {
            dispose();
            openReservationInterface();
        });

        // Panel del botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(startButton);
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(backgroundPanel);
        setVisible(true);
    }

    private void openReservationInterface() {
        JFrame frame = new JFrame("Flight Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new Interface());
        frame.setVisible(true);
    }
}
