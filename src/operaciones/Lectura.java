/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import modelos.ActividadDeportiva;
import modelos.Administrador;
import modelos.Asistente;

/**
 *
 * @author giova
 */
public class Lectura {

    public LinkedList<Administrador> leerAdministrador(String nombreArchivo) {

        LinkedList<Administrador> listaAdministrador = new LinkedList();
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader(nombreArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();

            while (cadenaLeida != null) {
                Administrador administrador = new Administrador();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                administrador.setUsuario(st.nextToken());
                administrador.setContrasena(st.nextToken());

                listaAdministrador.add(administrador);
                cadenaLeida = archivoLectura.readLine();
            }

            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }

        return listaAdministrador;
    }

    public LinkedList<Asistente> leerAsistente(String nombreArchivo) {

        LinkedList<Asistente> listaAsistente = new LinkedList();
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader(nombreArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();

            while (cadenaLeida != null) {
                Asistente asistente = new Asistente();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                int numTokens = st.countTokens();
                numTokens -= 10;
                int numActividades = (numTokens / 6);
                asistente.setIdAsistente(st.nextToken());
                asistente.setNombre(st.nextToken());
                asistente.setApellidoPaterno(st.nextToken());
                asistente.setApellidoMaterno(st.nextToken());
                asistente.setEdad(st.nextToken());
                asistente.setGenero(st.nextToken());
                asistente.setDireccion(st.nextToken());
                asistente.setContacto(st.nextToken());
                asistente.setEmergencia(st.nextToken());
                
                ArrayList<ActividadDeportiva> actividades = new ArrayList();
                if(numActividades>0){
                    for (int i = 0; i < numActividades; i++) {
                        ActividadDeportiva actividad = new ActividadDeportiva();
                        actividad.setActividad(st.nextToken().replaceAll("\\[|\\]", ""));
                        actividad.setInstructor(st.nextToken().replaceAll("\\[|\\]", ""));
                        actividad.setHorario(st.nextToken().replaceAll("\\[|\\]", ""));

                        String equipoString = st.nextToken().replaceAll("\\[|\\]", "");
                        actividad.setEquipo(equipoString.compareTo("true") == 0);

                        String precioEquipoString = st.nextToken().replaceAll("\\[|\\]", "");
                        actividad.setPrecioEquipo(Float.parseFloat(precioEquipoString));

                        String precioString = st.nextToken().replaceAll("\\[|\\]", "");
                        actividad.setPrecio(Float.parseFloat(precioString));

                        actividades.add(actividad);
                    }
                    
                    asistente.setActividades(actividades);
                    asistente.setPrecioTotal(Float.parseFloat(st.nextToken()));
                }else{
                    st.nextToken();
                    asistente.setActividades(actividades);
                    asistente.setPrecioTotal(Float.parseFloat(st.nextToken()));
                }
                

                listaAsistente.add(asistente);
                cadenaLeida = archivoLectura.readLine();
            }

            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }

        return listaAsistente;
    }

    public LinkedList<ActividadDeportiva> leerActividades(String nombreArchivo) {

        LinkedList<ActividadDeportiva> listaActividades = new LinkedList();
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader(nombreArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();

            while (cadenaLeida != null) {
                ActividadDeportiva actividad = new ActividadDeportiva();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                actividad.setActividad(st.nextToken());
                actividad.setInstructor(st.nextToken());
                actividad.setPrecioEquipo(Float.parseFloat(st.nextToken()));
                actividad.setPrecio(Float.parseFloat(st.nextToken()));

                listaActividades.add(actividad);
                cadenaLeida = archivoLectura.readLine();
            }

            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }

        return listaActividades;
    }

}
