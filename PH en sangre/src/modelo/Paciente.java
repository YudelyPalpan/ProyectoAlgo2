
package modelo;

/**
 *
 * @author Lupita
 */
public class Paciente extends Persona {
    
    private String codigoPaciente;

    public Paciente(String codigoPaciente, String nombres, String apellidos, String sexo,
            String edad, String estadoCivil, String telefono, String direccion, String email) {
        
        super(nombres, apellidos, sexo, edad, estadoCivil, telefono, direccion, email);
        this.codigoPaciente = codigoPaciente;
        //averiguar
         
    }
    public String getCodigoPaciente() {
        return codigoPaciente;
    }

}
    

