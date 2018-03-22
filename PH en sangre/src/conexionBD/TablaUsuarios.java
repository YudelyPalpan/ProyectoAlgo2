/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.*;

/**
 *
 * @author Lupita
 */
public class TablaUsuarios {
    
    Conectar conexion;
    
    public TablaUsuarios(){
        
        conexion = new Conectar();
    }
    
    public int buscar(String Tusuario, String Tcontraseña){
        
        int resultado = 0;
        try {
            PreparedStatement pstm = (PreparedStatement)conexion.getConnection().prepareStatement("Select * FROM Usuarios");
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                if(rs.getString(1).equals(Tusuario) && rs.getString(2).equals(Tcontraseña)){
                    if(rs.getString(3).equals("Medico")){
                        resultado = 2;
                    } else {
                        resultado = 1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return resultado;
    }
  /*  
    public void modificar(String Tusuario, String Tcontraseña, String Tusuario2){
        
        try {
            int grabar;
            PreparedStatement pstm = conexion.getConnection().prepareStatement("UPDATE usuarios SET User='"+Tusuario+"',Pass='"+Tcontraseña+"' WHERE User='"+Tusuario2+"'");
            grabar = pstm.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);       
        }
    }
    */
    public boolean buscar(String Tdato){
     
        boolean encontrado = false;
        try {
            
            PreparedStatement pstm = conexion.getConnection().prepareStatement("SELECT user, Codigo FROM usuarios");
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                if(resultado.getString(1).equals(Tdato) || resultado.getString(2).equals(Tdato)){
                    encontrado = true;
                }
            }
            
            if(!resultado.isClosed()){
            resultado.close();
        }
        } catch (SQLException e) {
            System.out.println(e);
        }
           
        return encontrado;
    }
    
    public void agregar(String user, String pass, String tipo, String cod){
        
        try{
            PreparedStatement pstm=(PreparedStatement)conexion.getConnection().prepareStatement("insert into Usuarios(User,Password,Tipo,Codigo) values (?,?,?,?)");
            pstm.setString(1, user);
            pstm.setString(2, pass);
            pstm.setString(3, tipo);
            pstm.setString(4, cod);
            pstm.execute();
            pstm.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
