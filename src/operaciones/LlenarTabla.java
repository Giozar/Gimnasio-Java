/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import modelos.ActividadDeportiva;
import modelos.Asistente;

/**
 *
 * @author giova
 */
public class LlenarTabla {
    
    public Vector<String>tituloColumnas(){
        Vector<String>listaTitulos = new Vector();
        
        Lectura llenado = new Lectura();
        LinkedList<ActividadDeportiva> listaActividad = new LinkedList(); 
        listaActividad = llenado.leerActividades("Actividad.txt");
        
        for(int i=0;i<listaActividad.size();i++){
            int numAct = i+1;
            String aux = "Actividad "+ numAct;
            listaTitulos.add(aux);
        }
        
        String asistente = "Datos del asistente";
        listaTitulos.add(0, asistente);
        
        
        
        return listaTitulos;
        
    }
    
    /*
     * Llena los datos de la celda a partir de la
     * información de los alumnos, los exámenes
     * y las calificaciones de cada alumno 
     * para cada examen
     */
    public Vector elementosCelda(){
         Vector filas = new Vector();
         Vector<Object>fila;
         Lectura llenado = new Lectura();
          
         LinkedList<Asistente>listaAsistente = new LinkedList();
         
        
         int nAsistente;

        listaAsistente = llenado.leerAsistente("asistentes.txt");
        nAsistente = listaAsistente.size();
        
       
         for(int i=0;i<nAsistente;i++){
            fila = new Vector();
                ArrayList<ActividadDeportiva> listaActividad = new ArrayList();  
            
            Asistente asis = listaAsistente.get(i);
            fila.add(asis);
            
            listaActividad = asis.getActividades();
            for(int j=0;j<listaActividad.size();j++){
                ActividadDeportiva aux = listaActividad.get(j);
                fila.add(aux);
            }
            
            filas.add(fila);
         }
         
         
         return filas;
        
    }
    
}
