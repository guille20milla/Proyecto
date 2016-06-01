/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class BaseDeDatos {
    private String bd= "baseproyecto";
    private String usuario= "user";//root
    private String contrasenia= "1234";//1234
    private String servidor="jdbc:mysql://localhost/";
    private Connection conexion;
    
    public BaseDeDatos(){}

    public boolean abrirConexion() {
        boolean estado = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");                //opcional,ayuda a tratar excepciones del driver
            conexion = DriverManager.getConnection(servidor + bd, usuario, contrasenia);
            estado = true;
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("Error en la conexion");
        }
        return estado;
    }

    public void cerrarConexion() {
        boolean estado = false;
        try {
            getConexion().close();
        } catch (SQLException sqle) {
            System.out.println("Error en la conexion");
        }
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }
}
