/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.AccesoBase;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class Interfaz4 {
    
    private JFrame frame;
    JPanel panel;
    JLabel nombreEquipo;
    private JComboBox TnombreEquipo;
    JLabel fecha;
    private JDateChooser Tfecha;
    JLabel precio;
    private JLabel Tprecio;
    JLabel vacio;
    private JButton seleccionEquipo;
    private JButton aceptarVenta;
    
    public Interfaz4(){
        frame = new JFrame();
        panel= new JPanel();
        
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        vacio=new JLabel();
        nombreEquipo = new JLabel("Nombre equipo");
        TnombreEquipo = new JComboBox(AccesoBase.consultaEquipos());
        seleccionEquipo=new JButton("Seleccionar");
        fecha = new JLabel("Fecha");
        Tfecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '*');
        precio = new JLabel("Precio");
        Tprecio = new JLabel();
        aceptarVenta = new JButton("Vender");

        panel.add(nombreEquipo);
        panel.add(TnombreEquipo);
        panel.add(vacio);
        panel.add(seleccionEquipo);
        panel.add(fecha);
        panel.add(Tfecha);
        panel.add(precio);
        panel.add(Tprecio);
        panel.add(aceptarVenta);
        
        frame.add(panel);
        
        
        frame.setTitle("Venta de entradas");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void addCalcularListener(ActionListener escucharBoton) {
        getAceptarVenta().addActionListener(escucharBoton);
        getSeleccionEquipo().addActionListener(escucharBoton);
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @return the TnombreEquipo
     */
    public JComboBox getTnombreEquipo() {
        return TnombreEquipo;
    }

    /**
     * @return the Tfecha
     */
    public Date getTfecha() {
        return Tfecha.getDate();
    }

    /**
     * @return the Tprecio
     */
    public JLabel getTprecio() {
        return Tprecio;
    }

    /**
     * @return the seleccionEquipo
     */
    public JButton getSeleccionEquipo() {
        return seleccionEquipo;
    }

    /**
     * @return the aceptarVenta
     */
    public JButton getAceptarVenta() {
        return aceptarVenta;
    }
}
