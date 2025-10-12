/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final;

import grafiic.ReservationWindow;
import javax.swing.SwingUtilities;

/**
 *
 * @author mayco
 */
public class Proyecto_final {

    public static void main(String[] args) {

        
       SwingUtilities.invokeLater(() -> {
            new ReservationWindow().setVisible(true);
        });
        
        
        
    }
}
