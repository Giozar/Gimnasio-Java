/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author giova
 */
public class ActividadDeportiva {
    private String actividad;
    private String instructor;
    private String horario;
    private boolean equipo;
    private float precioEquipo;
    private float precioActividad;  

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isEquipo() {
        return equipo;
    }

    public void setEquipo(boolean equipo) {
        this.equipo = equipo;
    }

    public float getPrecioEquipo() {
        return precioEquipo;
    }

    public void setPrecioEquipo(float precioEquipo) {
        this.precioEquipo = precioEquipo;
    }

    public float getPrecioActividad() {
        return precioActividad;
    }

    public void setPrecio(float precioActividad) {
        this.precioActividad = precioActividad;
    }

    @Override
    public String toString() {
        return actividad + "," + instructor + "," + horario + "," + equipo + "," + precioEquipo + "," + precioActividad;
    }
    
    
}
