/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Asistente;

/**
 *
 * @author giova
 */
public class Escritura {
    public void escribir(String nombreArchivo, Asistente asis) {
        try {// se crea una variable del objeto para poder leer
            FileWriter fw = new FileWriter(nombreArchivo, true);
            BufferedWriter archivoEscritura = new BufferedWriter(fw);
            //se crea el objeto y recupera el objeto pasado
            Asistente asistente = asis;
            //se escribe todo el toString
            archivoEscritura.write(asistente.toString() + "\n" );
            //se cierra el archivo
            archivoEscritura.flush();
            archivoEscritura.close();
            //captura cualquier error
        } catch (IOException ex) {
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limpiar(String nombreArchivo) {
        try {// se crea una variable del objeto para poder leer
            FileWriter fw = new FileWriter(nombreArchivo, false);
            BufferedWriter archivoEscritura = new BufferedWriter(fw);
            //se cierra el archivo
            archivoEscritura.flush();
            archivoEscritura.close();
            //captura cualquier error
        } catch (IOException ex) {
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LinkedList borrarAsistente(LinkedList lista, int posicion){
        lista.remove(posicion);
        return lista;
    }
    
    public int buscarAsistente(LinkedList lista, String nombre){
        int posicion = -1;
        for(int i=0;i<lista.size();i++){
            Asistente al = (Asistente) lista.get(i);
        if(al.getNombre().compareTo(nombre)==0){
            posicion = i;
            break;}}
        return posicion;
    }
    
}
