/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

/**
 *
 * @author Informatica
 */
public class variables {
    String nombre;
    String rutina;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutina() {
        return rutina;
    }

    public void setRutina(String rutina) {
        this.rutina = rutina;
    }

    public variables(String nombre, String rutina) {
        this.nombre = nombre;
        this.rutina = rutina;
    }
    
    
}
