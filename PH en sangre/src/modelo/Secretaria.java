
package modelo;

/**
 *
 * @author Lupita
 */
public class Secretaria extends Persona {
     
    private String gradoAcademico;

    public Secretaria(String gradoAcademico, String nombres, String apellidos, String sexo, String estadoCivil, String fechaNac, String direccion, String telefono, String email) {
        super(nombres, apellidos, sexo, estadoCivil, fechaNac, direccion, telefono, email);
        this.gradoAcademico = gradoAcademico;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }
    
    
}
