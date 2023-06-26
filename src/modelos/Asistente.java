/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import operaciones.ValidarFormulario;

/**
 *
 * @author giova
 */
public class Asistente {
    private static int id = 0;
    private String idAsistente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String edad;
    private String genero;
    private String direccion;
    private String contacto;
    private String emergencia;
    private ArrayList<ActividadDeportiva> actividades;
    private float precioTotal;

    public Asistente(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String genero, String direccion, String contacto, String emergencia, ArrayList<ActividadDeportiva> actividades) {
        id++;
        this.idAsistente = id + "";
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.genero = genero;
        this.direccion = direccion;
        this.contacto = contacto;
        this.emergencia = emergencia;
        this.actividades = actividades;
    }
    
    public Asistente() {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Asistente.id = id;
    }

    public String getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(String idAsistente) {
        this.idAsistente = idAsistente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }

    public ArrayList<ActividadDeportiva> getActividades() {
        return actividades;
    }
    
    public ActividadDeportiva getActividad(int i) {
        return actividades.get(i);
    }

    public void setActividades(ArrayList<ActividadDeportiva> actividades) {
        this.actividades = actividades;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    public boolean validarAsistente(){
        ValidarFormulario validar = new ValidarFormulario();
        boolean res = validar.validarFormulario(nombre, apellidoPaterno, apellidoMaterno, edad, genero, direccion, contacto, emergencia);
        return res;
    }
    

    @Override
    public String toString() {
        return idAsistente + "," + nombre + "," + apellidoPaterno + "," + apellidoMaterno + "," + edad + "," + genero + "," + direccion + "," + contacto + "," + emergencia + "," + actividades + "," + precioTotal;
    }
    
    public String datosPersonales() {
        return idAsistente + "," + nombre + "," + apellidoPaterno + "," + apellidoMaterno + "," + edad + "," + genero + "," + direccion + "," + contacto + "," + emergencia + "," + precioTotal;
    }

    
    
    
    
}
