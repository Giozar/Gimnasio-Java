/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import javax.swing.JOptionPane;

/**
 *
 * @author giova
 */
public class ValidarFormulario {
    
    public boolean validarFormulario(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String genero, String direccion, String contacto, String emergencia) {
        String message = "";
        int campos = 0;
        if (nombre == null || nombre.isEmpty()) {
            message += "El campo 'Nombre' es obligatorio.\n";
            //JOptionPane.showMessageDialog(null, "Se registró correctamente", "Datos registrados", JOptionPane.INFORMATION_MESSAGE);
            campos++;
        }
        
        if (apellidoPaterno == null || apellidoPaterno.isEmpty()) {
            message += "El campo 'Apellido Paterno' es obligatorio.\n";
            campos++;
        }
        
        if (apellidoMaterno == null || apellidoMaterno.isEmpty()) {
            message += "El campo 'Apellido Materno' es obligatorio.\n";
            campos++;
        }
        
        if (edad == null || edad.isEmpty()) {
            message += "El campo 'Edad' es obligatorio.\n";
            campos++;
        }
        
        else if (!edad.matches("\\d+")){
            message += "El campo 'Edad' es incoreccto.\n";
            campos++;
        } 
        
        if (genero == null || genero.isEmpty()) {
            message += "El campo 'Genero' es obligatorio.\n";
            campos++;
        }
        
        if (direccion == null || direccion.isEmpty()) {
            message += "El campo 'Direccion' es obligatorio.\n";
            campos++;
        }
        
        if (contacto == null || contacto.isEmpty()) {
            message += "El campo 'Contacto' es obligatorio.\n";
            campos++;
        }
        else if (!contacto.matches("\\d+")){
            message += "El campo 'Contacto' es incoreccto.\n";
            campos++;
        } 
        
        if (emergencia == null || emergencia.isEmpty()) {
            message += "El campo 'Emergencia' es obligatorio.\n";
            campos++;
        }
        else if (!emergencia.matches("\\d+")){
            message += "El campo 'Emergencia' es incoreccto.\n";
            campos++;
        } 
        
        if (campos > 0){
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
