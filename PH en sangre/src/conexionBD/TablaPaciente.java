/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import modelo.Paciente;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lupita
 */
public class TablaPaciente {

    Conectar conexion;

    public TablaPaciente() {

        conexion = new Conectar();
    }

    public void NuevoPaciente(Paciente p) {

        try {
            PreparedStatement pstm = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO pacientes values(?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, p.getCodigoPaciente());
            pstm.setString(2, p.getNombres());
            pstm.setString(3, p.getApellidos());
            pstm.setString(4, p.getSexo());
            pstm.setString(5, p.getEdad());
            pstm.setString(6, p.getEstadoCivil());
            pstm.setString(7, p.getTelefono());
            pstm.setString(8, p.getDireccion());
            pstm.setString(9, p.getEmail());

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void ModificarPaciente(String codP, String edad, String tel, String dire, String email, String ec) {

        try {
           int grabar;
            PreparedStatement pstm = conexion.getConnection().prepareStatement(" UPDATE Pacientes SET Edad = '"+edad+"', Telefono ='" + tel + "', Direccion ='" + dire + "',  Correo ='" + email + "', EstadoCivil = '" + ec + "' WHERE CodigoPaciente ='" + codP + "' ");
            grabar = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //ESTE METODO ES PARA VISUALIZAR LOS DATOS EN LA TABLA DE RegistroPaciientes 
    public Object[][] getDatos() {

        int registros = 0;
        
        try {
            PreparedStatement pstm = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM pacientes");
            ResultSet resultado = pstm.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        Object[][] data = new String[registros][5];

        try {

            PreparedStatement pstm = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT * FROM pacientes");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String estCodigo = res.getString("CodigoPaciente");
                String estNombre = res.getString("Nombres");
                String estApellido = res.getString("Apellidos");
                String estSexo = res.getString("Sexo");
                String estEdad = res.getString("Edad");

                data[i][0] = estCodigo;
                data[i][1] = estNombre;
                data[i][2] = estApellido;
                data[i][3] = estSexo;
                data[i][4] = estEdad;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return data;

    }
     
    public Paciente BuscarPaciente(String cod) {
        Paciente p = null;
        try {

            PreparedStatement pstm = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT * FROM Pacientes WHERE CodigoPaciente ='" + cod + "' ");
            ResultSet res = pstm.executeQuery();

            while (res.next()){

                String nom = res.getString(2);
                String ape = res.getString(3);
                String sex = res.getString(4);
                String edad = res.getString(5);
                String ec = res.getString(6);
                String tel = res.getString(7);
                String dir = res.getString(8);
                String email = res.getString(9);

                p = new Paciente(cod, nom, ape, sex, edad, ec, tel, dir, email);
            }
            res.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }

    public boolean Encontrado(String tcod) {
        boolean encontrado = false;
        try {
            PreparedStatement pstm = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT * FROM pacientes");
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                if (res.getString("CodigoPaciente").equals(tcod)) {
                    encontrado = true;
                }
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return encontrado;
    }

    public void BorrarPaciente(String codigo) {

        String sql = "DELETE FROM pacientes WHERE CodigoPaciente = '" + codigo + "'";

        try {
            PreparedStatement comando = conexion.getConnection().prepareStatement(sql);
            comando.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Excepcion", JOptionPane.ERROR_MESSAGE);

        }
    }

}
