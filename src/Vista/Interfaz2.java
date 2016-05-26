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
import javax.swing.JButton;
import javax.swing.JComboBox;
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
/**
 *
 * @author Alumno
 */
public class Interfaz2 {
    private JFrame frame;
    JPanel panel;
    private JButton botonCancelar;
    private JButton botonRegistrar;
    JLabel nombre;
    JLabel apellido;
    JLabel contrasenna;
    JLabel categoria;
    JLabel contrasenna2;
    private JTextField Tnombre;
    private JPasswordField Tcontrasenia;
    private JTextField Tapellido;
    private JPasswordField Tcontrasenia2;
    private JComboBox Tcategoria;
    public String [] categorias = new String[2];
    String servidor = "jdbc:mysql://localhost/";
    String bd = "BD";
    String usuario = "user";
    String contrasenia = "1234";
    BaseDeDatos db = new BaseDeDatos();

    public Interfaz2() {
        categorias[0] = "Presidente";
        categorias[1] = "Director Comercial";
        Tcategoria = new JComboBox(categorias);
        frame = new JFrame();
        panel = new JPanel();
        nombre = new JLabel("Nombre");
        apellido = new JLabel("Apellido");
        categoria = new JLabel("Categoria");
        contrasenna = new JLabel("Contraseña");
        contrasenna2 = new JLabel("Confirmar contraseña");
        Tnombre = new JTextField(15);
        Tapellido = new JTextField(15);
        Tcontrasenia = new JPasswordField(15);
        Tcontrasenia2 = new JPasswordField(15);
        botonCancelar = new JButton("Cancelar");
        botonRegistrar= new JButton("Registrar");
        panel.setLayout(new GridLayout(6,2,5,5));
        
        panel.add(nombre);
        panel.add(Tnombre);
        panel.add(apellido);
        panel.add(Tapellido);
        panel.add(categoria);
        panel.add(Tcategoria);
        panel.add(contrasenna);
        panel.add(Tcontrasenia);
        panel.add(contrasenna2);
        panel.add(Tcontrasenia2);
        panel.add(botonRegistrar);
        panel.add(botonCancelar);
        frame.add(panel);

        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void addCalcularListener(ActionListener escucharBoton){
        getBotonCancelar().addActionListener(escucharBoton);
        getBotonRegistrar().addActionListener(escucharBoton);
    }

    /**
     * @return the botonCancelar
     */
    public JButton getBotonCancelar() {
        return botonCancelar;
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

    /**
     * @return the Tapellido
     */
    public JTextField getTapellido() {
        return Tapellido;
    }

    /**
     * @return the Tcontrasenia2
     */
    public JPasswordField getTcontrasenia2() {
        return Tcontrasenia2;
    }

    /**
     * @return the Tcategoria
     */
    public JComboBox getTcategoria() {
        return Tcategoria;
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
    
}

