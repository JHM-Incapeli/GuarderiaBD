/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesYAtributos;

/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class PersonaCosteaMensualidad {
    public Acudiente acudiente =new Acudiente();
    public String numeroDeCuenta;
    
    public PersonaCosteaMensualidad(){
    
    }

    public PersonaCosteaMensualidad(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }
    
     public String getNombreCostea() {
        return acudiente.Nombre;
    }
    
    public String getDNICotea(){
        return acudiente.DNI;
    }
     
    public String getDireccionCostea(){
            return acudiente.direccion;
    }
    
    public String getNumeroTelefono(){
        return acudiente.numeroTelefono;
    }
}
