/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.BaseDeDatos;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class Interfaz1 {
    JFrame frame;
    JPanel panel;
    private JButton botonConectar;
    private JButton botonRegistrar;
    JLabel nombre;
    JLabel contrasenna;
    JLabel pregunta;
    JLabel blanco;
    private JTextField Tnombre;
    private JPasswordField Tcontrasenia;
    String servidor = "jdbc:mysql://localhost/";
    String bd = "BD";
    String usuario = "user";
    String contrasenia = "1234";
    BaseDeDatos db = new BaseDeDatos();

    public Interfaz1() {
        frame = new JFrame();
        panel = new JPanel();
        nombre = new JLabel("Nombre");
        contrasenna = new JLabel("Contraseña");
        Tnombre = new JTextField(15);
        Tcontrasenia = new JPasswordField(15);
        pregunta = new JLabel("           ¿No tienes cuenta?");
        blanco = new JLabel("");
        botonConectar = new JButton ("Conectarse");
        botonRegistrar= new JButton("Registrarse");
        panel.setLayout(new GridLayout(4,2,5,5));
        
        pregunta.setForeground(java.awt.Color.red);
        
        panel.add(nombre);
        panel.add(Tnombre);
        panel.add(contrasenna);
        panel.add(Tcontrasenia);
        panel.add(blanco);
        panel.add(pregunta);
        panel.add(botonConectar);
        panel.add(botonRegistrar);
        frame.add(panel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void addCalcularListener(ActionListener escucharBoton){
        getBotonConectar().addActionListener(escucharBoton);
        getBotonRegistrar().addActionListener(escucharBoton);
    }

    /**
     * @return the botonConectar
     */
    public JButton getBotonConectar() {
        return botonConectar;
    }

    /**
     * @return the botonRegistrar
     */
    public JButton getBotonRegistrar() {
        return botonRegistrar;
    }

    /**
     * @return the Tnombre
     */
    public JTextField getTnombre() {
        return Tnombre;
    }

    /**
     * @return the Tcontrasenia
     */
    public JPasswordField getTcontrasenia() {
        return Tcontrasenia;
    }
    
}
