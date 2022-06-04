/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesYAtributos;

/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class Menu {
    public String numeroMenu;
    public String nombrePlatos;
    public String costoMenu;
    public String costoDelosPlato;
    public String ingredientes;

    public Menu(String numeroMenu, String nombrePlatos, String costoMenu, String costoDelosPlato, String ingredientes) {
        this.numeroMenu = numeroMenu;
        this.nombrePlatos = nombrePlatos;
        this.costoMenu = costoMenu;
        this.costoDelosPlato = costoDelosPlato;
        this.ingredientes = ingredientes;
    }
    
    public Menu(){
    
    }

    public String getNumeroMenu() {
        return numeroMenu;
    }

    public String getNombrePlatos() {
        return nombrePlatos;
    }

    public String getCostoMenu() {
        return costoMenu;
    }

    public String getCostoDelosPlato() {
        return costoDelosPlato;
    }

    public String getIngredientes() {
        return ingredientes;
    }
    
}
