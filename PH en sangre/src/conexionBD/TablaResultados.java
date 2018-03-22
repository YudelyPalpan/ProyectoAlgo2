/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.*;
import modelo.*;
import java.util.*;

/**
 *
 * @author Lupita
 */
public class TablaResultados {
    
    public String guardarResultado(Resultados resultado){
        
        Conectar conexion = new Conectar();
        String mensaje = "Resultado guardado correctamente";
        String sql = "INSERT INTO resultados VALUES(?,?,?)";
        
        try {
            Connection miConexion = conexion.getConnection();
            PreparedStatement consulta = miConexion.prepareStatement(sql);
            consulta.setString(1, resultado.getCodigo());
            consulta.setDouble(2, resultado.getNivelPH());
            consulta.setString(3, resultado.getTipoSangre());
            
            int exito = consulta.executeUpdate();
            
            if(exito == 0) {
                mensaje = "No se pudo realizar la actualizacion";
            } 
           
        } catch (Exception e) {
            mensaje = e.getMessage();
        } finally {
            conexion.desconectar();
        }
        
        return mensaje;
    }
    
    
    public Resultados obtenerResultado (String cod) {
        Conectar conexion = new Conectar();
        Resultados miResultado = null;
        try {

            PreparedStatement pstm = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT * FROM resultados WHERE CodigoPaciente = ? ");
            pstm.setString(1, cod);
            ResultSet res = pstm.executeQuery();

            while (res.next()){

                String codigo = res.getString(1);
                double nivelPH = res.getDouble(2);
                String tipoSangre = res.getString(3);

                miResultado = new Resultados(codigo,nivelPH,tipoSangre);
            }
            res.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conexion.desconectar();
        }
        return miResultado;
    }
   
}
