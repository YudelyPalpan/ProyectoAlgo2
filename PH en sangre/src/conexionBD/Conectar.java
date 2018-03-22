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
public class Conectar {
    
    Connection conexion = null;
    
    public Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/Clinica","root","");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Connection getConnection(){
        return conexion;
    }
    
    public void desconectar(){
        
        try {
            if(!conexion.isClosed()){
                conexion.close();
            }
        } catch (SQLException e) {

            System.out.println(e);
        }
    }
    
    
}
