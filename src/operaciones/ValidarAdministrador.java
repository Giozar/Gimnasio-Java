/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.util.LinkedList;
import modelos.Administrador;

/**
 *
 * @author giova
 */
public class ValidarAdministrador {

    public boolean validarUsuario(Administrador adm, LinkedList lista) {

        for (int i = 0; i < lista.size(); i++) {
            Administrador admin = (Administrador) lista.get(i);
            if (adm.getUsuario().compareTo(admin.getUsuario()) == 0) {
                if (adm.getContrasena().compareTo(admin.getContrasena()) == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
