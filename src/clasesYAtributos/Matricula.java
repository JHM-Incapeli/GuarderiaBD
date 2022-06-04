
package clasesYAtributos;

/**
 *
 * @author Javier_Andres Herrera Manjarrez
 */
public class Matricula {
    public String numeroMatricula;
    public String nombreDeInfante, fechaNacimiento, fechaIngresoGuarderia, siSeDioBajaAlNinoFecha, alergiaDelInfante;

    public Matricula(){
    
    }

    public Matricula(String numeroMatricula, String nombreDeInfante, String fechaNacimiento, String fechaIngresoGuarderia, String siSeDioBajaAlNinoFecha, String alergiaDelInfante) {
        this.numeroMatricula = numeroMatricula;
        this.nombreDeInfante = nombreDeInfante;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngresoGuarderia = fechaIngresoGuarderia;
        this.siSeDioBajaAlNinoFecha = siSeDioBajaAlNinoFecha;
        this.alergiaDelInfante = alergiaDelInfante;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public String getNombreDeInfante() {
        return nombreDeInfante;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaIngresoGuarderia() {
        return fechaIngresoGuarderia;
    }

    public String getSiSeDioBajaAlNinoFecha() {
        return siSeDioBajaAlNinoFecha;
    }

    public String getAlergiaDelInfante() {
        return alergiaDelInfante;
    }
    
    
}
