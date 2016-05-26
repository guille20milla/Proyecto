/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class AccesoBase {
    BaseDeDatos bd = new BaseDeDatos();
    
    public static int obtenerIdPersona(Persona p, BaseDeDatos bd) {
        CallableStatement cs;
        ResultSet rs;
        int id = 0;
        try {
            cs = bd.getConexion().prepareCall("{call buscarPersona_in(?,?)}");
            cs.setString(1, p.getNombre());
            cs.setString(2, p.getContrasenia());

            rs = cs.executeQuery();
            if (rs == null) {
                id = 0;
            } else {
                rs.beforeFirst();
                id = rs.getInt(1);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        return id;
    }

    public static String obtenerCategoria(int id, BaseDeDatos bd) {
        CallableStatement cs;
        ResultSet rs;
        String categoria = "";

        try {
            cs = bd.getConexion().prepareCall("{call obtenercategoria(?)}");
            cs.setInt(1, id);

            rs = cs.executeQuery();

            categoria = rs.getString(4);

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

        return categoria;
    }

    public static void crearPersona(Persona p, BaseDeDatos bd) {
        CallableStatement cs;
        bd.abrirConexion();
        try {

            cs = bd.getConexion().prepareCall("{call insertarPersona(?,?,?,?)}");
            cs.setString(1, p.getNombre());
            cs.setString(2, p.getApellido());
            cs.setString(3, p.getCategoria());
            cs.setString(4, p.getContrasenia());

            cs.execute();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        bd.cerrarConexion();
    }
}
