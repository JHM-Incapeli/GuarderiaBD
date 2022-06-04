/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesYAtributos;

/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class consumoDeInfante {
    public String numeroMatriculaInfate,numeroMenu, costoMenu;
    public String fecha;

    public consumoDeInfante(String numeroMatriculaInfate, String fecha,String numeroMenu, String costoMenu) {
        this.numeroMatriculaInfate = numeroMatriculaInfate;
        this.fecha = fecha;
        this.numeroMenu = numeroMenu;
        this.costoMenu = costoMenu;
    }
    
    public consumoDeInfante(){
    
    }

    public String getNumeroMatriculaInfate() {
        return numeroMatriculaInfate;
    }

    public String getNumeroMenu() {
        return numeroMenu;
    }

    public String getCostoMenu() {
        return costoMenu;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    
}
