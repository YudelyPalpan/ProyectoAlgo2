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
public class Resultados {
    private String Codigo;
    private double nivelPH;
    private String tipoSangre;

    public Resultados(String Codigo, double nivelPH, String tipoSangre) {
        this.Codigo = Codigo;
        this.nivelPH = nivelPH;
        this.tipoSangre = tipoSangre;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public double getNivelPH() {
        return nivelPH;
    }

    public void setNivelPH(double nivelPH) {
        this.nivelPH = nivelPH;
    }
    
    public String toString() {
        return nivelPH + "-" + tipoSangre;
    }
    
}
