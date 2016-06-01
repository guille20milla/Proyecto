/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.AccesoBase;
import Modelo.BaseDeDatos;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class InterfazConsulta {

    private JFrame frame;
    JPanel panel1;
    JLabel fecha;
    private JDateChooser Tfecha;
    JLabel fecha2;
    private JDateChooser Tfecha2;
    JLabel precio;
    private JLabel Tprecio;
    private JButton aceptar;
    JPanel panel2;
    private JComboBox Tequipo;
    JLabel vacio;
    JLabel fecha3;
    private JDateChooser Tfecha3;
    JLabel fecha4;
    private JDateChooser Tfecha4;
    JLabel precio1;
    private JLabel Tprecio1;
    private JButton aceptar2;
    JTabbedPane pestañas;
    BaseDeDatos bd = new BaseDeDatos();

    public InterfazConsulta() {
        frame = new JFrame();
        panel1 = new JPanel();
        panel2 = new JPanel();
        pestañas = new JTabbedPane();
        ImageIcon escudoAlta = new ImageIcon("escudoAlta.gif");
        ImageIcon escudoBaja = new ImageIcon("escudoBaja.gif");

        panel1.setLayout(new GridLayout(4, 2, 5, 5));
        fecha = new JLabel("Primera fecha");
        Tfecha= new JDateChooser("dd/MM/yyyy", "##/##/####", '*');
        fecha2= new JLabel("Segunda fecha");
        Tfecha2= new JDateChooser("dd/MM/yyyy", "##/##/####", '*');
        precio  = new JLabel("Suma total");
        Tprecio = new JLabel();
        aceptar = new JButton("Realizar consulta");
        
        panel1.add(fecha);
        panel1.add(Tfecha);
        panel1.add(fecha2);
        panel1.add(Tfecha2);
        panel1.add(precio);
        panel1.add(Tprecio);
        panel1.add(aceptar);
        

        panel2.setLayout(new GridLayout(5, 2, 5, 5));
        Tequipo = new JComboBox(AccesoBase.consultaEquipos());
        vacio = new JLabel();
        fecha3 = new JLabel("Primera fecha");
        Tfecha3= new JDateChooser("dd/MM/yyyy", "##/##/####", '*');
        fecha4= new JLabel("Segunda fecha");
        Tfecha4= new JDateChooser("dd/MM/yyyy", "##/##/####", '*');
        precio1  = new JLabel("Suma total");
        Tprecio1 = new JLabel();
        aceptar2 = new JButton("Realizar consulta");
        
        panel2.add(Tequipo);
        panel2.add(vacio);
        panel2.add(fecha3);
        panel2.add(Tfecha3);
        panel2.add(fecha4);
        panel2.add(Tfecha4);
        panel2.add(precio1);
        panel2.add(Tprecio1);
        panel2.add(aceptar2);

        pestañas.addTab("Consulta todas las ventas", panel1);
        pestañas.addTab("Consulta ventas de un equipo", panel2);

        frame.add(pestañas);

        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(900, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void addCalcularListener(ActionListener escucharBoton) {
        getAceptar().addActionListener(escucharBoton);
        getAceptar2().addActionListener(escucharBoton);
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @return the Tfecha
     */
    public Date getTfecha() {
        return Tfecha.getDate();
    }

    /**
     * @return the Tfecha2
     */
    public Date getTfecha2() {
        return Tfecha2.getDate();
    }

    /**
     * @return the Tprecio
     */
    public JLabel getTprecio() {
        return Tprecio;
    }

    /**
     * @return the aceptar
     */
    public JButton getAceptar() {
        return aceptar;
    }

    /**
     * @return the Tequipo
     */
    public JComboBox getTequipo() {
        return Tequipo;
    }

    /**
     * @return the Tfecha3
     */
    public Date getTfecha3() {
        return Tfecha3.getDate();
    }

    /**
     * @return the Tfecha4
     */
    public Date getTfecha4() {
        return Tfecha4.getDate();
    }

    /**
     * @return the Tprecio1
     */
    public JLabel getTprecio1() {
        return Tprecio1;
    }

    /**
     * @return the aceptar2
     */
    public JButton getAceptar2() {
        return aceptar2;
    }
}
