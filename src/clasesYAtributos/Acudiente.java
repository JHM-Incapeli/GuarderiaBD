/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesYAtributos;
    
/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class Acudiente {
    public String DNI;
    public String Nombre;
    public String direccion;
    public String numeroTelefono;
    public String relacionConInfante;
    

    public Acudiente(String DNI, String Nombre, String direccion, String numeroTelefono, String relacionConInfante) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
        this.relacionConInfante = relacionConInfante;
    }
    public Acudiente(){
    
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getRelacionConInfante() {
        return relacionConInfante;
    }
    
}



























