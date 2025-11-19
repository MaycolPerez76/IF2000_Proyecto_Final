/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author mayco
 */
public class ValidateInformation {
    public static boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return name.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$");
    }
    
    public static boolean validateID(String id) {
        if (id == null || id.trim().isEmpty()) {
            return false;
        }
        return id.matches("\\d+");
    }
}
