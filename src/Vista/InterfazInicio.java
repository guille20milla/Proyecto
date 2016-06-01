/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.BaseDeDatos;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class InterfazInicio {
    private JFrame frame;
    JPanel panel;
    private JButton conectarse;
    private JButton mostrarTablaEquipo;
    private JButton mostrarTablaPersonas;
    private JButton mostrarTablaVentas;
    private JButton consultas;
    String servidor = "jdbc:mysql://localhost/";
    String bd = "BD";
    String usuario = "user";
    String contrasenia = "1234";
    BaseDeDatos db = new BaseDeDatos();
    
    
    public InterfazInicio(){
        frame = new JFrame();
        panel=new JPanel();
        frame.setTitle("Bienvenido a mi proyecto");
        
        conectarse= new JButton("Conectarse");
        mostrarTablaEquipo =new JButton("Mostrar equipos");
        mostrarTablaPersonas =new JButton("Mostrar personas");
        mostrarTablaVentas = new JButton("Mostrar ventas");
        consultas = new JButton("Consultas");
        
        panel.add(conectarse);
        panel.add(mostrarTablaEquipo);
        panel.add(mostrarTablaPersonas);
        panel.add(mostrarTablaVentas);
        panel.add(consultas);
        
        frame.add(panel);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void addCalcularListener(ActionListener escucharBoton){
        getConectarse().addActionListener(escucharBoton);
        getMostrarTablaEquipo().addActionListener(escucharBoton);
        getMostrarTablaPersonas().addActionListener(escucharBoton);
        getMostrarTablaVentas().addActionListener(escucharBoton);
        getConsultas().addActionListener(escucharBoton);
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @return the conectarse
     */
    public JButton getConectarse() {
        return conectarse;
    }

    /**
     * @return the mostrarTablaEquipo
     */
    public JButton getMostrarTablaEquipo() {
        return mostrarTablaEquipo;
    }

    /**
     * @return the mostrarTablaPersonas
     */
    public JButton getMostrarTablaPersonas() {
        return mostrarTablaPersonas;
    }

    /**
     * @return the mostrarTablaVentas
     */
    public JButton getMostrarTablaVentas() {
        return mostrarTablaVentas;
    }

    /**
     * @return the consultas
     */
    public JButton getConsultas() {
        return consultas;
    }
}
