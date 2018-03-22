/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lupita
 */
public class Medico extends Persona {
    
    private int numeroColegiatura;
    private String gadoAcademico;

    public Medico(String nombres, String apellidos, int numerocolegiatura, String sexo, String estadoCivil, 
            String fechaNac, String direccion, String telefono, String email, String gradoAcademico) {
        
        super(nombres, apellidos, sexo, estadoCivil, fechaNac, direccion, telefono, email);
        this.gadoAcademico = gadoAcademico;
        this.numeroColegiatura = numeroColegiatura;
    }
    
    
    public int getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(int numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }

    public void setGadoAcademico(String gadoAcademico) {
        this.gadoAcademico = gadoAcademico;
    }

    public String getGadoAcademico() {
        return gadoAcademico;
    }

}
